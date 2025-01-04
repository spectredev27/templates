package example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        TemplateClassRepository templateClassRepository = new TemplateClassRepository();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> templateClassRepository.updateTemplateVersion(1, "1.1.0"));
        executor.submit(() -> templateClassRepository.updateTemplateVersion(1, "1.2.0"));

        executor.shutdown();

        List<TemplateClass> templateClasses = templateClassRepository.selectAll();
        for (TemplateClass t : templateClasses) {
            System.out.println(t.getTemplateVersion());
            System.out.println(t.getVersion());
        }
    }

}
