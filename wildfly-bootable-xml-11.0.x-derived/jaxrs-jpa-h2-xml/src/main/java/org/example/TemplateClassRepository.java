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

    public List<TemplateClass> selectAll() {
        TypedQuery<TemplateClass> result = entityManager.createQuery("select t from TemplateClass t", TemplateClass.class);
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
        entityManager.remove(entityManager.find(TemplateClass.class, id));
    }

}
