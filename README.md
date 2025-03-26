# 📄일정 관리 API 명세서

## ✅ 일정 생성 (Create)

- **URL:** `/schedules`
- **Method:** `POST`
- **Request Body:**
    
    ```json
    {
      "title": "과제 제출",
      "author": "정이슬",
      "password": "1234"
    }
    ```
    
- **Response:**
    
    ```json
    {
      "id": 1,
      "title": "과제 제출",
      "author": "정이슬",
      "createdAt": "2025-03-26T12:00:00",
      "updatedAt": "2025-03-26T12:00:00"
    }
    ```
    

## ✅ 전체 일정 조회 (Read All)

- **URL:** `/schedules`
- **Method:** `GET`
- **Query Params:**
    - `date` (optional): 조회할 날짜 (YYYY-MM-DD)
    - `author` (optional): 작성자명
- **Response:**
    
    ```json
    [
      {
        "id": 1,
        "title": "과제 제출",
        "author": "정이슬",
        "updatedAt": "2025-03-26T12:00:00"
      }
    ]
    ```
    

## ✅ 단일 일정 조회 (Read One)

- **URL:** `/schedules/{id}`
- **Method:** `GET`
- **Response:**
    
    ```json
    {
      "id": 1,
      "title": "과제 제출",
      "author": "정이슬",
      "createdAt": "2025-03-25T12:00:00",
      "updatedAt": "2025-03-25T12:00:00"
    }
    ```
    

## ✅ 일정 수정 (Update)

- **URL:** `/schedules/{id}`
- **Method:** `PUT`
- **Request Body:**
    
    ```json
    {
      "title": "과제 제출",
      "author": "정이슬",
      "password": "1234"
    }
    ```
    
- **Response:**
    
    ```json
    {
      "id": 1,
      "title": "과제 제출",
      "author": "정이슬",
      "updatedAt": "2025-03-26T14:00:00" // 시간 변경
    }
    ```
    

## ✅ 일정 삭제 (Delete)

- **URL:** `/schedules/{id}`
- **Method:** `DELETE`
- **Request Body:**
    
    ```json
    {
      "password": "1234"
    }
    ```
    
- **Response:**
    
    ```json
    {
      "message": "일정이 삭제되었습니다."
    }
    ```
    

# ERD

### ✅ **테이블 개요**

📌 **Schedule (일정 테이블)**

- `id` (BIGINT, PK, AUTO_INCREMENT) - 일정 고유 ID
- `title` (VARCHAR) - 일정 제목
- `author` (VARCHAR) - 작성자명
- `password` (VARCHAR) - 일정 수정/삭제를 위한 비밀번호
- `created_at` (DATETIME) - 일정 작성일
- `updated_at` (DATETIME) - 일정 수정일

```sql
CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```
