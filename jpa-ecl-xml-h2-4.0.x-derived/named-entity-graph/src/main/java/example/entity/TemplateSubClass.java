package example.entity;

import java.util.List;

public class TemplateSubClass {

    private int id;
    private String serial;
    private TemplateClass templateClass;
    private List<TemplateSubClassDetail> details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public TemplateClass getTemplateClass() {
        return templateClass;
    }

    public void setTemplateClass(TemplateClass templateClass) {
        this.templateClass = templateClass;
    }

    public List<TemplateSubClassDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TemplateSubClassDetail> details) {
        this.details = details;
    }

}
