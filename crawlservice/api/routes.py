from fastapi import FastAPI, HTTPException

from fastapi import APIRouter, Depends, HTTPException, Header
from datetime import datetime
import json
import facebook as fb
import requests

from api.models import Page_info, Post, Comment

router = APIRouter(prefix="/crawl")


@router.post("/postPage")
async def postPage(item: Page_info):
    return {
        "page_url": item.page_url,
        "post_url": item.post_url,
        "access_token": item.access_token
    }

@router.post("/postPost")
async def postPost(item: Page_info):
    start_index = item.page_url.find("id=") + 3
    p = Post(post_id="", post_content="", post_time=datetime.now(), page_id="", access_token="")
    p.page_id = item.page_url[start_index:]
    start_index = item.post_url.find("fbid=") + len("fbid=")
    end_index = item.post_url.find("&set", start_index)
    fbid = item.post_url[start_index:end_index]
    p.post_id = fbid
    asafb = fb.GraphAPI(item.access_token)
    content = asafb.get_object(f"{p.page_id}_{p.post_id}")
    p.post_time = datetime.strptime(content['created_time'], "%Y-%m-%dT%H:%M:%S%z")
    p.post_content = content.get('message', 'No message')
    p.access_token = item.access_token
    return {
        "post_content": p.post_content,
        "post_time": p.post_time,
        "page_id": p.page_id,
        "post_id": p.post_id,
        "access_token": p.access_token
    }

@router.post("/postCMT")
async def postCMT(item: Post):
    url = f'https://graph.facebook.com/v16.0/{item.page_id}_{item.post_id}/comments?access_token={item.access_token}'
    response = requests.get(url)
    if response.status_code != 200:
        raise HTTPException(status_code=response.status_code, detail="Không thể lấy dữ liệu từ Facebook API")
    data = json.loads(response.text)
    listCMT = []
    for item in data['data']:
        try:
            # Kiểm tra xem trường 'from' có tồn tại không
            if 'from' in item and 'name' in item['from']:
                cmt_creator = item['from']['name']
            else:
                cmt_creator = "Người dùng Facebook"  # Giá trị mặc định
            cmt = Comment(
                cmt_content=item.get('message', 'No message'),
                cmt_time=datetime.strptime(item['created_time'], "%Y-%m-%dT%H:%M:%S%z"),
                cmt_creator=cmt_creator
            )
            listCMT.append(cmt)
        except KeyError as e:
            print(f"Lỗi: Thiếu trường dữ liệu {e} trong bình luận {item}")
            continue
    return {"comments": [cmt.model_dump() for cmt in listCMT]}