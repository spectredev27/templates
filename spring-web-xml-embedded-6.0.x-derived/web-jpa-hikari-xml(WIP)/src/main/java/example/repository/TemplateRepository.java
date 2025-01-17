package example.repository;

import example.entity.TemplateClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TemplateRepository {

    private final EntityManager entityManager;

    public TemplateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<TemplateClass> selectAll() {
        TypedQuery<TemplateClass> typedQuery = entityManager.createQuery("select t from TemplateClass t", TemplateClass.class);
        return typedQuery.getResultList();
    }

}
