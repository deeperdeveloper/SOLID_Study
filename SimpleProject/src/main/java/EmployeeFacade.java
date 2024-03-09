public class EmployeeFacade {

    private final HRteam hrTeam;
    private final SalesTeam salesTeam;
    private final SupplyTeam supplyTeam;

    EmployeeFacade(HRteam hrTeam, SalesTeam salesTeam, SupplyTeam supplyTeam) {
        this.hrTeam = hrTeam;
        this.salesTeam = salesTeam;
        this.supplyTeam = supplyTeam;
    }

    public int getSalary(Employee employee) {
        return hrTeam.getSalary(employee);
    }

    public void setSalary(Employee employee, int salary) {
        hrTeam.setSalary(employee, salary);
    }

    public int getNumOfBuyers(Employee employee) {
        return salesTeam.getNumOfBuyers(employee);
    }

    public void setNumOfBuyers(Employee employee, int number) throws IllegalAccessException {
        salesTeam.setNumOfBuyers(employee, number);
    }

    public int getNumOfSuppliers(Employee employee) {
        return supplyTeam.getNumOfSuppliers(employee);
    }

    public void setNumOfSuppliers(Employee employee, int number) throws IllegalAccessException {
        supplyTeam.setNumOfSuppliers(employee, number);
    }
}
