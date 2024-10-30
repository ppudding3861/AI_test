# app/database.py
import pymysql
from .config import settings

# MySQL 연결 함수
def get_connection():
    return pymysql.connect(
        host=settings.MYSQL_HOST,
        user=settings.MYSQL_USER,
        password=settings.MYSQL_PASSWORD,
        database=settings.MYSQL_DB,
        port=settings.MYSQL_PORT,
        cursorclass=pymysql.cursors.DictCursor
    )

# 테이블 생성 함수
def create_table():
    connection = get_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("""
            CREATE TABLE IF NOT EXISTS counter (
                id INT PRIMARY KEY AUTO_INCREMENT,
                count INT NOT NULL DEFAULT 0
            );
            """)
        connection.commit()
    finally:
        connection.close()