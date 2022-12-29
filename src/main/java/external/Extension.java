package external;

import java.util.List;

public class Extension {

    public String id;
    public String name;
    public String shortName;
    public List<String> keywords;

    @Override
    public String toString() {
        return "{\n" +
                "   id: " + id + ",\n" +
                "   name: " + name + ",\n" +
                "   shortName:" + shortName + "\n" +
                "}";
    }
}