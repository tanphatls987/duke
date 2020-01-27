public class ToDo extends Task{
    public ToDo(String name) {
        super(name);
    }
    @Override
    public String getDisplayName() {
        return getName();
    }
    @Override
    public String getType() {
        return "T";
    }
}
