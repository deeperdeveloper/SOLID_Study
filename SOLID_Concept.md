내용의 대부분은 아래의 출처를 참고해서 작성함.

* https://www.youtube.com/watch?v=HIWJ8sF8lO8&list=PLeQ0NTYUDTmMM71Jn1scbEYdLFHz5ZqFA&index=14



### SOLID Foundation

* 소프트웨어 공학의 결과물은 "소스 코드" 가 아닌 "바이너리 코드" 라고 보아야 한다.

  => 소스코드는 document라고 보아야 한다.

  (건물 설계도 = document, 건물 = document를 컴파일, 빌드한 결과물)

* 소프트웨어의 설계/결과물과 건물의 설계/결과물의 차이

  * 건물의 경우, 설계의 작성은 비용이 낮지만 결과물의 구축 비용은 비쌈

    => 소프트웨어의 경우에는 반대로, 설계(소스코드 작성) 비용이 높고 결과물의 구축 비용은 낮다고 할 수 있다. 

  * 최근에는 릴리즈 주기가 점점 빨라지는 추세. 이는 사용자의 니즈를 충족시키기 위함.

* 그렇다면, 코드 작성 시 잘못 되었음을 느낄 수 있는 징후는?

  => 크게 3가지 요인이 있다

  * Rigidity

    * 정의 : 시스템의 의존성으로 인해 변경하기 어려워진다.

      => 전체 코드의 조그마한 부분만 변경해도, 전체 코드를 리빌드하게 될 수 있다. 

    * 해결책

      * 위의 정의에서 보았듯, 리빌드와 테스트 시간을 줄이는 것이 궁극적인 해결 방법이다.
      * SOLID 원칙을 지키는 것이 주요한 해결책

  * Fragility

    * 정의 : 모듈의 자그마한 부분을 수정해도, 다른 모듈에 영향을 주는 경우

    * 해결책 : 모듈의 의존성을 제거해야 함

      => 런타임의 의존성은 불가피하지만, 소스 코드에서의 의존성은 제거가 충분히 가능하다. (인터페이스 도입)

  * Immobility

    * 정의 : 모듈이 쉽게 추출되지 않고 재사용도 안 되는 경우

      => 즉, 모듈이 특정 시스템의 요소와 강하게 결합되어 있는 경우가 해당된다.

    * 해결책 : 모듈의 특정 요소(DB,UI, Framework 등) 결합도를 낮추자

  * 그 외의 징후

    * Viscosity(점성)
      * 필수 오퍼레이션(빌드,컴파일 등)의 수행 시간이 오래 걸린다면, "역겹다" 라고 표현
      * 개발자가 향후 발생할 문제점을 예상함에도, 덮어놓고 코드를 짜는 경우

  * 테스트 코드를 짜기 어렵다면? => 잘못된 코드를 짜고 있을 가능성이 높다.  (테스트 코드 먼저 작성하고, 실제 코드를 작성하면 이러한 난항은 발생하지 않을 가능성이 높다.)



Needless Complexity

* 아키텍처나 디자인을 처음부터 명확하게 짜고 하기보다는, 계속 리팩토링하거나 코드를 수정해나가다 보니 좋은 아키텍처가 생긴다는 관점

  => 즉, 미래의 issue를 미리 생각하면서 아키텍처를 설계하면 굉장히 복잡해진다. 

  => 앞으로의 확장을 고려하면서 설계하는 것에 치우치면, 개발자는 현재를 제어할 수 없게 된다.

  => 현재 요구 사항에 집중하는 것이 최선. 이렇게 하면, 변경 사항이 나와도 빠르게 대처가 가능하다.



객체지향(OO)의 핵심

* (소스코드 레벨에서) 상위 레벨의 모듈이 하위 레벨의 모듈의 detail에 의존하지 않는 것

  * 런타임 때에는 당연히 상위 레벨의 모듈이 하위 레벨의 디테일에 의존한다
  * 그러나, 소스코드 단계에서는, 상위 레벨의 모듈은 인터페이스에만 의존하고, 디테일(구현체)에 의존하지 않는다.

* 제어의 역전(IOC) 개념이 바로 그러하다. 실행하는 비즈니스 로직(상위개념)은 개발자가 담당하지만, 로직 내부의 세부 구현체(하위개념 디테일)의 결정은 프레임워크가 하게 된다.

  => 개발자는 로직에만 집중하면 된다.

* 객체지향의 설계(OOD)에서 가장 핵심은, Dependency Management라고 할 수 있으며 5가지 원칙(SOLID)가 있다.



객체지향 코드 예시

```
```





### SOLID 첫번째 원칙 - SRP

* Responsibility

  * "변경의 근원" 을 유발하는 Actor에 따라서 Responsibility 를 분류한다.

    => 단순히 클래스 내부의 함수 갯수에 따라서, Responsbility의 갯수가 결정되는 것이 아니고, 해당 함수를 사용하는 주체(Actor)가 누군지에 따라 Responsibility를 grouping 할 수 있다는 의미

    * 예) EmployeeImpl의 내부 메서드가 아래의 4가지가 구현되어 있다고 하자.

      => calculatePay(), save(), findById(), describeEmployee()

      => 이 때 Policy는 calculatePay()를, Architect는 save(), findById()를, Operations는 describeEmployee() 를 활용한다

      => 즉, Employee의 클래스를 변경을 요구하는 사용자들은 3가지 부류라고 볼 수 있다. (3가지의 Actor가 있다.)

      => Employee 클래스는 3가지 책임을 담당한다고 할 수 있다.

  * Actor의 요구사항이 변경이 되면, Actor가 사용하는 메서드의 집합이 변경이 된다. 

  * 따라서, Responsibilty는 아래와 같이 정의할 수 있다.

    * 정의 : 특정한 Actor의 요구사항을 만족시키기 위한 일련의 함수 집합



그러나 위의 예시에서는 아래의 문제점이 발생한다.

* Primary Value의 저하

  * 즉, 현재의 SW가 "지속적으로 변화하는" 요구사항을 수용하지 못한다.

    => 현재의 요구사항만 만족시킬 뿐, EmployeeImpl에서 3개의 Actor가 요구사항 변경을 요구하면 동일한 모듈이 3번의 변경이 이루어져야 한다는 것을 의미

    => EmployeeImpl 모듈은 예상치 못한 충돌을 만날 수 있다.

  * 따라서, SW의 궁극적인 가치인 "Primary Value"를 만족시킬 수 없다.

* Fan Out

  * EmployeeImpl은 너무 많은 책임을 가지고 있어서 변경에 굉장히 민감하다.

* 특정 Actor가 새로운 기능의 추가를 요구할 때, 다른 Actor는 특이한 변경점이 없더라도 영향을 받는다
  * 즉, EmployeeImpl이 너무 많은 책임(3가지 책임)을 지고 있기 때문에, 1가지 책임만 바뀌어도 3가지 전체 책임에 대해서 재컴파일되고 재배포 되어야 한다는 것을 의미한다.



따라서, 하나의 모듈은 ""반드시 하나의 변경사유(Actor)"를 가져야 한다고 결론을 내릴 수 있다.

=> SRP의 정의이다.

* 즉, EmployeeImpl의 경우에는, 3가지 모듈로 나뉘어야 하며 각각의 모듈은 각각의 Actor(Policy, Architect, Operations)로 나뉘어야 한다고 할 수 있다.

  * 여러가지 해결책이 존재하지만, 완벽한 정답은 없다.

    * 해결책1. Employee 인터페이스를 따로 두어, 의존성 역전 만들기

      * EmployeeImpl을 Employee 인터페이스에 의존하게 하고, Policy, Architect, Operations 역시 Employee 인터페이스에 의존하게 하기

      * 3가지 Actor는 클래스에서는 분리되었지만, 하나의 인터페이스에 couple되어있고 하나의 구현 클래스에도 couple 되어 있다. (문제점)

        => 그리고 어느 1가지 Actor의 인터페이스에 대한 요구사항이 변경이 되어도 해당 인터페이스 전체가 영향을 받는다는 문제점 발생

    * 해결책 1-1. 하나의 Employee 클래스를 3가지 클래스로 분리

    * 해결책 1-2. EmployeeFacade 클래스를 하나 만든 후, 각 기능을 3가지 구현체에 대입하는 것

    * 해결책 1-3. 각각의 Actor가 각각의 인터페이스에 의존하도록 한 후, 3가지 인터페이스를 1가지 클래스로 구현되게끔 하기

  * SRP를 준수한 아키텍처의 예시

    * 게임을 설계할 때 아래와 같이 설계할 것이다.
      * 가장 중요한 Actor인 Customer가 어플리케이션의 중앙(GamePlay)에 오게 한다.
      * GamePlay에는 GameInterface와 StrategyInterface가 플러그인 되어 있다.
      * 각 GameInterface와 StrategyInterface는 각각 GameDesigner와 Strategist 의 Actor가 책임을 담당한다. 
      * 결국, 각 패키지의 중요한 클래스가 하나의 책임만을 담당하게끔 작성하는 것이 핵심이다.

  * 이러한 설계는, 맨 처음부터 완벽하게 이루어지지 않고 맨 마지막에 완성이 된다.

    * 리팩토링 하고 테스트 코드를 짜면서 Actor가 누구인지 윤곽이 드러나게 된다.



### SOLID - OCP(Open and Closed Principle)

확장에 대해 열려있고, 변경에 대해 닫혀있다는 의미 (소스 코드의 수정 없이!)

* 확장의 의미
  * "타입"을 추가함으로서 기능을 추가하는 방법.
  * OOP가 추구하는 바. 
  * ** OOP에서 타입은 추가가 안되는데 기능을 추가한다면, function을 추가하는 것이므로 굉장한 변경을 수반하는 행위임.
* 변경의 의미
  * 상위 클래스의 소스 코드 변경이 이루어지지 않으면서, 하위 구현 클래스의 변경이 가능하다는 의미
* 즉, 확장이 필요하다면, 상위 클래스에서는, 확장이 필요한 부분에 대해서 추상화로서 구현하면 된다.



예시) 결제 포스기를 구현할 때, 결제 방법을 추상화하여 결제 모듈 자체는 수정을 하지 않고 결제 방법(현금, 신용카드 등)을 추가할 수 있음

* 그러나, 현실적으로 이를 미리 예상해야만 OCP를 준수해야 한다는 nonsense가 발생

  => 클라이언트는, 전혀 예상치 못한 기능의 추가/변경을 요구한다. (CrystalBall Problem)



이러한 문제를 해결하기 위해 아래의 생각을 알 수 있다.

* (BDUF)고객의 요구사항을 되도록 많이 예상해서 추상화를 미리 적용할까? (결론 : 안 된다.)

  * 추상화가 많이 되면 코드 이해가 직관적으로 하기가 어려워진다

  * 고객이 전혀 예상치 못한 것을 요구하면, 추상화 시켜놓은 것이 무쓸모해진다. 

    => 굉장히 무겁고 복잡하기만 한 설계가 된다

* Agile Design (적합한 결론)

  * 미리 예상해서 설계하지 말고, 그 때 그 때 변화를 경험하여 반응을 하는 것!
  * 지금 고객의 요구한 것을 최대한 빨리 끌어낼 수 있는 가장 단순한 일을 한다.
    * 고객이 요구사항 변경을 요구하면, 그 때서야 비로소 어떤 변경이 요구되는지 알 수 있다.
  * 고객이 변경을 요구하면, Agile Designer는 코드를 리팩토링하여 Abstraction 을 추가한다.

* 그러면, BDUF는 나쁘고 Agile Design은 완전 좋은 것?
  * 그렇지 않다. No DUF를 피해야 한다. 
  * 기본 모양을 수립은 꼭 해야 하지만, detail까지 모두 수립하지 않는 것이 핵심



결론

* 프로젝트가 진행될 수록 Abstraction이 높아진다
* OCP를 완벽하게 준수하는 것은 불가능. 고객은 언제나 예상치 못한 변경을 요구할 수 있고, 이는 시스템의 대대적인 변경을 야기할 수 있다.
  * 그럼에도, 변경을 최소화하는 것이 개발자의 궁극적인 목표이다.



### SOLID - LSP

* LSP는 다운캐스팅을 막기 위한 것이 강함. (타입에 의존하는 것은 대단히 강한 의존이다.)

  * 즉, 상위 타입의 변수에 하위 타입의 변수를 대입해도, 클라이언트 코드(실행 코드)의 수정이 이루어지지 않아야 한다.

* 하지만, 주의해야 할 부분이, 일상생활에서 IS-A 관계라고 해서, SW에서도 IS-A 관계가 성립하지 않는다는 것이다.

  * 예) 일반적으로, 정사각형은 사각형의 여러 타입 중 하나이다. (IS-A 관계)

    * 그러나, 이를 SW로 투영한다면 우스꽝스런 논리가 발생한다.

      ```java
      public class Rectangle {
      
          private int width;
          private int height;
      
          public void setWidth(int width) {
              this.width = width;
          }
      
          public void setHeight(int height) {
              this.height = height;
          }
      }
      
      class Square extends Rectangle {
          @Override
          public void setWidth(int width) {
              super.setWidth(width);
              super.setHeight(width);
          }
      
          @Override
          public void setHeight(int height) {
              super.setHeight(height);
              super.setWidth(height);
          }
          
          //정사각형이라서, setSide(int length) 함수를 별도로 선언할 수도 있으나, 이는 다운캐스팅을 유발한다. 
      }
      
      public class Main {
          
          //사각형의 가로 길이가 더 길다면, 세로 길이 = 가로길이 + 10 으로 만드는 코드 
          public static void increaseHeight(Rectangle rec) {
              if(rec.getHeight() <= rec.getWidth()) {
                  rec.setHeight(rec.getWidth() + 10);
              }
          }
          
          public static void main(String[] args) {
              Rectangle rec1 = new Rectangle();
              Rectangle rec2 = new Square();
              
              rec1.setWidth(7);
              rec1.setHeight(5);
              
              rec2.setWidth(9);
              rec2.setHeight(9);
              
              increaseHeight(rec1);
              //increaseHeight(rec2); //rec2 객체가 정사각형이 안 되므로 안 된다.
          }
      }
      ```

    * LSP 원칙을 준수하기 위해서는, 위와 같이 setWidth()와 setHeight()를 override하여 사용하여야 한다. 

    * 그리고, increaseHeight() 메서드의 매개변수로는 "정사각형" 이 들어갈 수가 없으므로, Rectangle 의 특정 하위 타입만 받도록 따로 로직을 짜야 한다.

      => LSP 위반



### SOLID - ISP

* 1개의 인터페이스는 특정 클라이언트만 의존하게끔 짜야 한다.
  * 그렇지 않고 1개의 인터페이스를 불필요한 클라이언트가 의존하게 짜면, 인터페이스의 변경이 있을 경우 해당 클라이언트는 불필요한 빌드/배포가 진행이 된다.
  * 즉, 인터페이스는 클라이언트와 같은 패키지에 포함되어야 함을 알 수 있다.
    * 인터페이스의 naming 역시, 클라이언트와 관계되게 짓는 것이 좋다. (구현체와 관계되지 않는다.) 

* 1가지 클래스는 1가지 책임만을 담당해야 한다는 SRP랑 의미가 유사하다.
* 여러가지 기능을 하는 1개의 class가 있다면, 기능에 따라 다수의 interface를 생성하고, 각 클라이언트는 해당하는 인터페이스를 바라보게 하면 된다.
  * 이로 인해 특정 interface가 변경된다고 해서, 해당하는 클라이언트 외에 다른 클라이언트가 영향이 가지 않는다. 



### SOLID - DIP

* Dependency Inversion Principle

  * 상위 레벨의 모듈이 하위 레벨의 detail에 의존하지 않아야 한다.

    => 상위 레벨의 모듈은, 하위 레벨 모듈의 추상화된 인터페이스에 의존해야 한다. (소스코드 레벨에서)



* 아키텍처 관점에서는, Web과 Database가 Application 방향으로 의존한다. 거꾸로는 의존하지 않는다. (이해가 대략적으로 됨)
  * 즉, Web과 Database는 Application에 구현체를 제공한다.



