# Python 3.12 이미지 사용
FROM python:3.12

# 컨테이너 내 작업 디렉토리 설정
WORKDIR /app

# Python 패키지 의존성 복사
COPY ./requirements.txt

# 의존성 설치
RUN pip install --no-cache-dir -r requirements.txt

# 모든 소스 코드를 컨테이너로 복사
COPY . .

# Uvicorn을 사용하여 FastAPI 애플리케이션 실행
CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]

# 컨테이너에서 사용할 포트를 노출
EXPOSE 8000
