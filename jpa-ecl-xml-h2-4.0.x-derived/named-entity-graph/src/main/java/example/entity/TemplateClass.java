package example.entity;

import java.util.List;

public class TemplateClass {

    private int id;
    private String name;
    private String version;
    private List<TemplateSubClass> subClasses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<TemplateSubClass> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<TemplateSubClass> subClasses) {
        this.subClasses = subClasses;
    }

}
