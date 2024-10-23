package example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TemplateClassRepository repository = new TemplateClassRepository();
        List<TemplateClass> templateClasses = repository.selectNative();
        templateClasses.forEach(templateClass -> {
            System.out.print(templateClass.getId() + " " + templateClass.getName() + " ");
            System.out.println(templateClass.getVersion());
        });
        String templateClassName = repository.selectNameWithNativeById(1);
        System.out.println(templateClassName);
    }

}
