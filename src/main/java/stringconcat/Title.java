package stringconcat;

public enum Title {
    MR("Mr."), MRS("Mrs."), DR("Dr."), MS("Ms.");

    private final String name;

    Title(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
