public class HRteam {

    private boolean isTeamLeader;

    HRteam(boolean isTeamLeader) {
        this.isTeamLeader = isTeamLeader;
    }

    public int getSalary(Employee employee) {
        return employee.getSalary();
    }

    public void setSalary(Employee employee, int salary) {
        employee.setSalary(salary);
    }

}
