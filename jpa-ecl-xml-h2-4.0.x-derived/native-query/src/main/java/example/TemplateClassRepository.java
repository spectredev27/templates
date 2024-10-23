package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<TemplateClass> selectNative() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Query nativeQuery = manager.createNativeQuery("select * from templateclass");
        List<?> result = nativeQuery.getResultList();

        List<TemplateClass> templateClasses = new ArrayList<>();

        for (Object row : result) {
            Object[] fields = (Object[]) row;
            TemplateClass templateClass = new TemplateClass();
            templateClass.setId((int) fields[0]);
            templateClass.setName(fields[1].toString());
            templateClass.setVersion(fields[2].toString());
            templateClasses.add(templateClass);
        }

        manager.getTransaction().commit();
        manager.close();

        return templateClasses;
    }

    public String selectNameWithNativeById(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Query nativeQuery = manager.createNativeQuery("select t.name from templateclass t where t.id = ?");
        nativeQuery.setParameter(1, id);
        Object result = nativeQuery.getSingleResult();

        manager.getTransaction().commit();
        manager.close();

        return (String) result;
    }

}
