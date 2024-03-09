public class SalesTeam {

    private boolean isTeamLeader;

    SalesTeam(boolean isTeamLeader) {
        this.isTeamLeader = isTeamLeader;
    }

    public int getNumOfBuyers(Employee employee) {
        return employee.getNumOfBuyers();
    }

    public void setNumOfBuyers(Employee employee, int num) throws IllegalAccessException {
        if(!isTeamLeader) throw new IllegalAccessException("Only TeamManager can Access");
        employee.setNumOfBuyers(num);
    }
}
