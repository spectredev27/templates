package example;

import example.entity.TemplateSubClass;
import example.entity.TemplateSubClassDetail;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TemplateSubClassRepository templateSubClassRepository = new TemplateSubClassRepository();
        List<TemplateSubClass> subClasses = templateSubClassRepository.selectWithEntityGraph();
        for (TemplateSubClass subClass : subClasses) {
            System.out.println(subClass.getId() + " " + subClass.getSerial());
            if (subClass.getTemplateClass() != null) {
                System.out.println("Template: " + subClass.getTemplateClass().getName());
            }
            if (!subClass.getDetails().isEmpty()) {
                for (TemplateSubClassDetail detail : subClass.getDetails()) {
                    System.out.println("Detail: " + detail.getId() + " " + detail.getNote1());
                }
            }
        }
    }

}
