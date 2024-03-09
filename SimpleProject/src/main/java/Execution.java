public class Execution {

    public static void main(String[] args) throws IllegalAccessException {

        //영업팀장이 활용
        EmployeeFacade ef =
                new EmployeeFacade(new HRteam(false), new SalesTeam(true), new SupplyTeam(true));
        //영업팀원
        Employee salesEmployee = new Employee();

        //인사팀이 영업팀원 급여 설정하고 조회
        ef.setSalary(salesEmployee, 100);
        ef.getSalary(salesEmployee);

        //영업팀장이 영업팀원의 담당 바이어 갯수를 설정하고 조회
        ef.setNumOfBuyers(salesEmployee, 15);
        ef.getNumOfBuyers(salesEmployee);

    }
}
