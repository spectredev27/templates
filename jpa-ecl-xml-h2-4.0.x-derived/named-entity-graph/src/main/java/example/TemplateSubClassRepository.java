package example;

import example.entity.TemplateSubClass;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class TemplateSubClassRepository {

    private final EntityManagerFactory factory = Factory.object;

    public List<TemplateSubClass> selectWithEntityGraph() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        EntityGraph<?> entityGraph = manager.getEntityGraph("subClassEntityGraph");
        List<TemplateSubClass> subClasses = manager.createQuery("SELECT s FROM TemplateSubClass s", TemplateSubClass.class)
            .setHint("jakarta.persistence.fetchgraph", entityGraph)
            .getResultList();

        manager.getTransaction().commit();
        manager.close();

        return subClasses;
    }

}
