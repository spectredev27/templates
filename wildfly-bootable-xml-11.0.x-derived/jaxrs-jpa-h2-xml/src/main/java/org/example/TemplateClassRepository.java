package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TemplateClassRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<TemplateClass> templateClass = TemplateClass.class;

    public List<TemplateClass> selectAll() {
        String query = "SELECT t FROM TemplateClass t";
        TypedQuery<TemplateClass> result = entityManager.createQuery(query, templateClass);
        return result.getResultList();
    }

    @Transactional
    public void insert(TemplateClass templateClass) {
        entityManager.persist(templateClass);
    }

    @Transactional
    public void update(TemplateClass templateClass) {
        entityManager.merge(templateClass);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(templateClass, id));
    }

}
