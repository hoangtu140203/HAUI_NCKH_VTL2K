import socket

import uvicorn
from fastapi import FastAPI, HTTPException
import py_eureka_client.eureka_client as eureka_client
import os
from api.routes import router

EUREKA_SERVER = "http://localhost:8761/eureka"
SERVICE_NAME = "CRAWL-SERVICE"
SERVICE_PORT = 8001  # Change based on your setup

HOST_NAME = "localhost"

eureka_client.init(
    eureka_server=EUREKA_SERVER,
    app_name=SERVICE_NAME,
    instance_host=HOST_NAME,
    instance_port=SERVICE_PORT
)
app = FastAPI()

app.include_router(router)


if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8001)