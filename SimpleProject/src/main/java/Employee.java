public class Employee {

    public String name;
    private int salary;
    private int numBuyers;
    private int numSuppliers;
    private boolean isTeamManager; //팀장, 팀원

    //급여 조회
    public int getSalary() {
        return this.salary;
    }

    //급여값 변경
    public void setSalary(int salary) {
        this.salary = salary;
    }

    //담당 거래처 갯수 조회
    public int getNumOfBuyers() {
        return this.numBuyers;
    }

    //담당 거래처 갯수 변경
    public void setNumOfBuyers(int num) {
        this.numBuyers = num;
    }

    public int getNumOfSuppliers() {
        return this.numSuppliers;
    }

    public void setNumOfSuppliers(int num) {
        this.numSuppliers = num;
    }
    //담당 구매처 갯수 조회

    //담당 구매처 갯수 변경
}
