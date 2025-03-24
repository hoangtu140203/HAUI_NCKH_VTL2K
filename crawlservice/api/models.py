from pydantic import BaseModel
from datetime import datetime

class Page_info(BaseModel):
    page_url: str
    post_url: str
    access_token: str

class Post(BaseModel):
    post_id: str
    post_content: str
    post_time: datetime
    page_id: str
    access_token: str

class Comment(BaseModel):
    cmt_content: str
    cmt_time: datetime
    cmt_creator: str