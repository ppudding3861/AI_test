# app/database.py
import pymysql
import time
from .config import settings

# MySQL 연결 함수
def get_connection(retries=5, delay=2):
    for attempt in range(retries):
        try:
            connection = pymysql.connect(
                host=settings.MYSQL_HOST,
                user=settings.MYSQL_USER,
                password=settings.MYSQL_PASSWORD,
                database=settings.MYSQL_DB,
                port=settings.MYSQL_PORT,
                cursorclass=pymysql.cursors.DictCursor
            )
            return connection
        except pymysql.MySQLError as e:
            if attempt < retries - 1:
                time.sleep(delay)
            else:
                raise e


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