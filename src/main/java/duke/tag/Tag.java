package duke.tag;

public class Tag {
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public String getTagName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("#%s", name);
    }
}
