package example.entity;

public class TemplateSubClassDetail {

    private int id;
    private String note1;
    private String note2;
    private TemplateSubClass subClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public TemplateSubClass getSubClass() {
        return subClass;
    }

    public void setSubClass(TemplateSubClass subClass) {
        this.subClass = subClass;
    }

}
