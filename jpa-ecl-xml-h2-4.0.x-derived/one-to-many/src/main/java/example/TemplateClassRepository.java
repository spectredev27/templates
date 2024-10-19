package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TemplateClassRepository {

    private final EntityManagerFactory factory = Factory.object;

    public void insert(TemplateClass templateClass) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(templateClass);

        if (!templateClass.getSubClasses().isEmpty()) {
            templateClass.getSubClasses().forEach(manager::persist);
        }

        manager.getTransaction().commit();
        manager.close();
    }

    public List<TemplateClass> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        TypedQuery<TemplateClass> query = manager.createQuery("select t from TemplateClass t", TemplateClass.class);
        List<TemplateClass> templateClasses = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return templateClasses;
    }

    public void update() {

    }

    public void delete(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        TemplateClass templateClassToDelete = manager.find(TemplateClass.class, id);

        if (templateClassToDelete != null) {
            if (!templateClassToDelete.getSubClasses().isEmpty()) {
                templateClassToDelete.getSubClasses().forEach(s -> {
                    TemplateSubClass subClass = manager.find(TemplateSubClass.class, s.getId());
                    subClass.setTemplateClass(null);
                    manager.persist(subClass);
                });
            }

            manager.remove(templateClassToDelete);
        }

        manager.getTransaction().commit();
        manager.close();
    }

}
