package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TemplateSubClassRepository {

    private final EntityManagerFactory factory = Factory.object;

    public void insert(TemplateSubClass templateSubClass) {

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(templateSubClass);

        manager.getTransaction().commit();
        manager.close();
    }

    public List<TemplateSubClass> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        TypedQuery<TemplateSubClass> query = manager.createQuery("select s from TemplateSubClass s", TemplateSubClass.class);
        List<TemplateSubClass> templateClasses = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return templateClasses;
    }

}
