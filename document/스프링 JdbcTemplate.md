# JdbcTemplate 소개와 설정
- spring-jdbc 라이브러리에 포함되어 있다.
- 템플릿 콜백 패턴을 사용해서 JDBC 대부분의 반복 작업을 처리해준다.
- 동적 SQL 해결이 어렵다. -> 할 수는 있지만, 너무 길고 지저분하다. 실수 여지가 그득그득하다.

# JdbcTemplate 적용1 - 기본
- JdbcTemplate을 DI 받기 위해서는 DataSource가 필요하다.
- KeyHolder -> DB에서 생성한 ID를 가지고 올 때 사용하는 라이브러리
  - 코드가 좀 지저분해진다.
  - 코드가 type-safe 하지 않다. (문자열)
  - 데이터가 반영이 되어야 자동 증가된 ID값을 가지고 올 수 있는데, 라이브러리를 통해 DB에 자동 증가 값을 중간에 가져올 수 있다.

# JdbcTemplate 적용2 - 동적 쿼리 문제
- 검색 조건에 따라 동등, 범위, 동일 조건을 동적으로 처리하기 애매하다. 조건이 늘어지는 경우 코드(조건문)도 늘어난다.
  - 각각 쿼리를 생성해야 하는 문제도 발생

# JdbcTemplate 적용3 - 구성과 실행
- JdbcTemplateConfig 클래스 추가
  - Datasource를 주입받아 사용한다.
- JdbcTemplateConfig를 사용하는 곳에서 @Import를 사용하는데, 해당 애노테이션 알아봐야 할 듯.
- application-properties에 데이터베이스 정보를 넣어두면, 스프링부트가 알아서 데이터베이스 관련 라이브러리들을 스프링 빈으로 등록시켜준다.

# JdbcTemplate - 이름 지정 파라미터 1
- JdbcTemplate는 파라미터를 받는대로 순서대로 바인딩한다. 유지보수나 여러 상황에서 파라미터 미일치가 일어날 가능성이 존재한다.
  - 파라미터 순서가 아니라, 네이밍 기반으로 변경해서 하도록 하면 해결 된다. -> 코드가 더 추가되긴 함.
    - MapSqlParameterSource
    - SqlParameterSource
- 개발을 하면서 코드를 줄이는 것 보다, 조금 더 길더라도 명확하게 하는 것이 유지보수 관점에서 매우 중요하다.

# JdbcTemplate - 이름 지정 파라미터 2
- Map처럼 Key / Value 구조로 만들어서 전달 -> Map 자료구조를 쓰면 된다.
- JdbcTemplate의 동적인 파라미터를 넣는 방식은 다양하게 있다. 뭐 하나가 좋다기보단 CRUD를 하면서 애매한 지점들이 존재하는 것 같다.  
- 자바 필드명 규약(카멜 케이스), db 필드명 규약(언더스코어)이 일치하지 않는 부분을, 데이터베이스 별칭을 이용하여 넣거나 가져온다.
  - 특정 라이브러리는 언더스코어를 카멜로 자동 변환해주기도 한다.

# JdbcTemplate - 이름 지정 파라미터 3

# JdbcTemplate - SimpleJdbcInsert
- 라이브러리 추가 -> SimpleJdbcInsert -> datasource를 파라미터로 넣어주고, 테이블명, 자동증가 pk, 칼럼(칼럼은 생략 가능)들을 넣어준다.
  - insert만 조금 더 쉽게 해줄수 있는듯?

# JdbcTemplate 기능 정리
- JdbcTemplate -> 순서 기반 바인딩 
- NamedParameterJdbcTemplate -> 이름 기반 파라미터 바인딩 지원 (권장)
- SimpleInsert -> INSERT SQL 편리하게 이용 가능
- SimpleJdbcCAll -> 스토어드 프로시저 편리하게 호출 가능 
