# app/main.py
from fastapi import FastAPI, HTTPException
from . import models, schemas
from .cors import add_cors_middleware
from .database import create_table


# FastAPI 애플리케이션 생성
app = FastAPI()

create_table()

add_cors_middleware(app)

# 현재 숫자 조회
@app.get("/api/count", response_model=schemas.CountResponse)
def get_count():
    return models.get_count()

# 숫자 증가
@app.post("/api/increase", response_model=schemas.CountResponse)
def increase_count():
    return models.increase_count()

# 숫자 감소
@app.post("/api/decrease", response_model=schemas.CountResponse)
def decrease_count():
    return models.decrease_count()
