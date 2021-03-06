# IntroductionToProxy
- LogTrackerExample에서 좀 더 발전된 프로젝트

<h3>기존 요구사항</h3>
* 모든 Public 메서드의 호출과 응답 정보를 로그로 출력

* 애플리케이션의 흐름 변경 X
  * 로그를 남김에 따라 비즈니스 로직의 동작에 영향 주면 안됨
  
* 메서드 호출에 걸린 시간 측정

* 정상 흐름과 예외 흐름 구분
  * Exception 발생 시 Exception 정보 남겨야함
  
* 메서드 호출의 깊이 표현 (몇 번째 호출되었는지 표시)

* HTTP 요청 구분
  * HTTP 요청 단위로 특정 ID를 남겨서 어떤 HTTP 요청에서 시작된 것인지 명확하게 구분 가능해야함
  * 트랜잭션 ID 남김 (UUID)
  
<h3>요구사항 추가</h3>
* 원본 코드를 전혀 수정하지 않고 proxy를 통해 로그 추적기 적용

* 특정 메서드는 보안상 로그 출력 X

* 아래와 같이 다양한 케이스로 요구사항 충족시켜보자
  * version1 - 인터페이스가 있는 구현 클래스에 적용
  * version2 - 인터페이스가 없는 구체 클래스에 적용
  * version3 - Component Scan 대상에 기능 적용
  
From 스프링 핵심 원리 - 고급편 (김영한 강사님)
---
프록시 패턴과 데코레이터 패턴 정리: https://jaimemin.tistory.com/2016

JDK 동적 프록시와 CGLIB 정리: https://jaimemin.tistory.com/2025

ProxyFactory 정리: https://jaimemin.tistory.com/2026

BeanPostProcessor 정리: https://jaimemin.tistory.com/2028

@Aspect 정리: https://jaimemin.tistory.com/2028
