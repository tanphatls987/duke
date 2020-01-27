public class Event extends Task{
    private String time;
    public Event(String name, String time) {
        super(name);
        this.time = time;
    }
    public String getTime() {
        return this.time;
    }
    @Override
    public String getDisplayName() {
        return getName() + "(at: " + time + ")";
    }
    @Override
    public String getType() {
        return "E";
    }

}
