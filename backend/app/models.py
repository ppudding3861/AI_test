# app/models.py
from .database import get_connection

# 현재 카운트 가져오기
def get_count():
    connection = get_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT count FROM counter LIMIT 1")
            result = cursor.fetchone()
            if result is None:
                cursor.execute("INSERT INTO counter (count) VALUES (0)")
                connection.commit()
                return {"count": 0}
            return {"count": result["count"]}
    finally:
        connection.close()

# 카운트 증가
def increase_count():
    connection = get_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("UPDATE counter SET count = count + 1")
            connection.commit()
            cursor.execute("SELECT count FROM counter LIMIT 1")
            result = cursor.fetchone()
            return {"count": result["count"]}
    finally:
        connection.close()

# 카운트 감소
def decrease_count():
    connection = get_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("UPDATE counter SET count = count - 1")
            connection.commit()
            cursor.execute("SELECT count FROM counter LIMIT 1")
            result = cursor.fetchone()
            return {"count": result["count"]}
    finally:
        connection.close()
