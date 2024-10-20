package example;

import example.entity.TemplateClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

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

}
