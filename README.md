# java-calculator-precourse

## 문제 설명
입력한 문자열에서 숫자를 추출하여 더하는 계산기이다.    
입력한 문자열을 나누는 구분자가 존재한다.(이때 구분자는 기본 구분자가 될 수도 있고 커스텀 구분자가 될 수도 있다.)    
커스텀 구분자는 "//"와 "\n" 사이에 위치한다.

### 실행 결과 예시

    덧셈할 문자열을 입력해 주세요.
    1,2:3
    결과 : 6

## 구현 기능 목록
- [x] 사용자 입력받기
- [x] 입력값 검증하기
  - **예외 상황**
    - [x] 입력 값이 공백일 경우
    - [x] 입력 값에 숫자만 존재할 경우
    - [x] 커스텀 구분자를 사용하기 위한 형식이 아닐 경우
    - [x] 커스텀 구분자 사용 시 구분자로 사용될 수 없는 경우
- [x] 구분자 찾기 (기본 구분자, 커스텀 구분자)
- [x] 숫자 추출하기
    - [x] 구분자로 나누었을 때 숫자가 아닌 다른 문자열이 들어있는 경우
    - [x] 음수가 입력되었을 경우
- [x] 덧셈 계산하기
- [x] 결과 출력하기