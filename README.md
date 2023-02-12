# patientSys

# 환경Set
- Java8
- JUnit4
- Spring Boot
- Mysql
- Mybatis

# DB
![image](https://user-images.githubusercontent.com/90138366/218314222-000e04f0-e9bd-4ea9-9d4e-66b118cb2aa3.png)
: 2단계 데이터 등록에 맞춰, 처음엔 image 테이블과 patient 테이블을 patient_code라는 참조키로 나누어 설계하였으나 같은 환자 정보로 묶는 것이 맞다 판단하여 한 테이블로 다시 설계하였습니다.

# 요구 사항
1. 환자 데이터 저장
- @Transactional 을 사용하여 트랜잭션을 진행하였습니다.
- 외부 서버에 이미지를 저장하는 습관을 가지고 있어 프로젝트 내부에 저장하고 브라우저에서 조회하는 방법을 찾아보았습니다.
- 이미지는 Files 라이브러리를 사용하여 ContentType를 확인하여 jpg, png 외에는 로직이 돌지 않게 하였습니다.

2. 상세 조회
- 사실 환자 이름 "김수진"을 검색하였을 경우, 동명이인의 경우를 생각하여 상세 조회 시 동명 이인을 다 보여주기로 하였습니다.
- 그러나, 이미지 조회는 프론트 단에서 pk값인 id를 던져 동명이인의 경우에도 한 명을 선택하여 한 이미지 url만 던지게 id를 조건으로 설정하였습니다.
- 삭제 또한 마찬가지로 id를 parameter로 설정하였습니다.
