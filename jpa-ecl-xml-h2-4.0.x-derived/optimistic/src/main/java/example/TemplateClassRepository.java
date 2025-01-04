package example;

import jakarta.persistence.*;
import org.eclipse.persistence.exceptions.OptimisticLockException;

import java.util.List;

public class TemplateClassRepository {

    private final EntityManagerFactory factory = Factory.object;

    public void insertScope(TemplateClass templateClass) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(templateClass);

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

    public void updateTemplateVersion(int id, String templateVersion) {
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();

            TemplateClass found = manager.find(TemplateClass.class, id);
            found.setTemplateVersion(templateVersion);

            manager.getTransaction().commit();
        } catch (RollbackException e) {
            System.out.println("WOOHOO!!! OptimisticLockException found!!!");
        }

        manager.close();
    }

}
