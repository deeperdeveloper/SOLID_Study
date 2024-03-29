SOLID 5원칙을 학습하고, 이를 실습하기 위해 간단한 수준의 ERP System을 구현하는 프로젝트까지 작성하는 것이 목표




총 아래의 2가지 폴더로 되어 있다.

### 1. SOLID_Concept.md

- 유튜브를 통해 학습한 SOLID 개념을 정리



### 2. SimpleProject

- 회사 내 ERP 시스템을 아주 간단한 수준으로 구현

- SOLID 5원칙을 준수하는데 프로젝트의 중점을 둠

- **요구사항은 아래와 같다.**

  - 회사 내의 모든 사람은 대표이사와 임직원으로 나뉜다. 

  - 임직원은 직무에 따라 권한이 달라진다. 세부적인 내용은 아래와 같다

    a) 임직원의 직무는 인사팀, 영업팀, 구매팀으로 나뉜다.
    	a)-1 각 팀의 임직원은 팀장과 팀원으로 나뉜다.

    b) "인사팀" 만이 임직원의 급여값 조회 및 급여값 변경이 가능하다.

    c) "영업팀" 만이 "영업팀" 직무 사람의 담당 거래처 갯수 조회가 가능하다. 
    	c)-1 "영업팀장" 만 "영업팀" 직무 사람의 담당 거래처 갯수 변경이 가능하다.

    d) "구매팀" 만이 "구매팀" 직무 사람의 담당 구매처 갯수 조회가 가능하다.
    	d)-1 "구매팀장" 만 "구매팀" 직무 사람의 담당 구매처 갯수 변경이 가능하다.

  3) 대표이사는 2)에 제시된 임직원의 모든 권한을 다 가진다.

- 상기 요구사항에 따라 작성된 class diagram은 아래와 같다


![ClassDiagram_1](https://github.com/deeperdeveloper/SOLID_Study/assets/105505302/177f9b46-f47b-4e94-aaac-2ed9a4d81f10)





240309 프로젝트 작성 시 주요한 고려사항

* 요구사항 작성 시 주요한 사항

  * 인사팀, 영업팀, 구매팀 클래스를 별도로 설정하는 것이 좋다고 느낌 => Facade 패턴 활용의 배경

    => 처음에는, Employee 객체들 중에서 인사팀, 영업팀, 구매팀 인원을 if문을 걸어서 차출하려고 함. 그러나, 객체지향적으로 의미가 있는지 의문이 들었음. 

    => 따라서, Employee 클래스와 다른 별도의 3개의 클래스(인사팀, 영업팀, 구매팀)을 두고, EmployeeFacade클래스 내부에 두었음.

  * (아직 더 생각해보아야 하는 부분) 대표이사도 Employee 객체로 설정할지, 별도의 객체로 설정할지를 정하기.

* Spring을 사용하지 않고, Main method 내부에서 객체를 임의로 생성해서 실행함

  * Facade 패턴을 활용했다는 것에 의의를 둠.

  
