package example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final TemplateClassRepository repository = new TemplateClassRepository();

    public static void insert() {
        TemplateClass templateClass1 = new TemplateClass();
        templateClass1.setName("JPA");
        templateClass1.setVersion("1.0.0");
        templateClass1.setSubClasses(new ArrayList<>());

        TemplateSubClass subClass1 = new TemplateSubClass();
        subClass1.setSerial(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmssSSS")));

        templateClass1.getSubClasses().add(subClass1);
        subClass1.setTemplateClass(templateClass1);

        TemplateSubClass subClass2 = new TemplateSubClass();
        subClass2.setSerial(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmssSSS")));

        templateClass1.getSubClasses().add(subClass2);
        subClass2.setTemplateClass(templateClass1);

        repository.insert(templateClass1);
    }

    public static void main(String[] args) {
        List<TemplateClass> result = repository.selectAll();
        result.forEach(t -> {
            System.out.println(t.getId() + " " + t.getName() + " " + t.getVersion());
            if (!t.getSubClasses().isEmpty()) {
                t.getSubClasses().forEach(s -> System.out.println(s.getId() + " " + s.getSerial()));
            }
        });

        repository.delete(1);

        TemplateSubClassRepository subClassRepository = new TemplateSubClassRepository();
        List<TemplateSubClass> subClasses = subClassRepository.selectAll();
        subClasses.forEach(s -> {
            System.out.print(s.getId() + " " + s.getSerial() + " ");
            if (s.getTemplateClass() != null) {
                System.out.print(s.getTemplateClass().getId());
            }
            System.out.println();
        });
    }

}
