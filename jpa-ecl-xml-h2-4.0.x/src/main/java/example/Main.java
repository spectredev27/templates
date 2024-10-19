package example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TemplateClass templateClass1 = new TemplateClass();
        templateClass1.setName("JPA");
        templateClass1.setVersion("1.0.0");

        TemplateClass templateClass2 = new TemplateClass();
        templateClass2.setName("JPA");
        templateClass2.setVersion("1.0.0");

        TemplateClassRepository repository = new TemplateClassRepository();
        repository.insertScope(templateClass1);
        repository.insertScope(templateClass2);

        List<TemplateClass> result = repository.selectAll();
        result.forEach(t -> System.out.println(t.getId() + " " + t.getName() + " " + t.getVersion()));
    }

}
