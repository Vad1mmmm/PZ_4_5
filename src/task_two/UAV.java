package task_two;

public class UAV {
    private String id;
    private UAVType type;
    private boolean operational;
    private int missionsCompleted;
    private int hoursFlown;

    public UAV(String id, UAVType type, int missionsCompleted, int hoursFlown, boolean operational){
        this.id = id;
        this.type = type;
        this.missionsCompleted = missionsCompleted;
        this.hoursFlown = hoursFlown;
        this.operational = operational;
    }

    public UAVType getType() {
        return type;
    }

    public boolean isOperational() {
        return operational;
    }

    public int getMissionsCompleted() {
        return missionsCompleted;
    }

    public int getHoursFlown() {
        return hoursFlown;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id " + id + " type " + type + " operational " + operational + " missions competed " + missionsCompleted + " hours flown " + hoursFlown;
    }

}
