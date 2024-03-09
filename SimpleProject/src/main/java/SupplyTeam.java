public class SupplyTeam {
    private boolean isTeamLeader;

    SupplyTeam(boolean isTeamLeader) {
        this.isTeamLeader = isTeamLeader;
    }

    public int getNumOfSuppliers(Employee employee) {
        return employee.getNumOfSuppliers();
    }

    public void setNumOfSuppliers(Employee employee, int num) throws IllegalAccessException {
        if(!isTeamLeader) throw new IllegalAccessException("Only TeamManager can Access");
        employee.setNumOfSuppliers(num);
    }
}
