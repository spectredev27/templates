package example.repository;

import example.Factory;
import example.entity.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SubscriptionRepository {

    private final EntityManagerFactory factory = Factory.object;
    private final Class<Subscription> subscriptionClass = Subscription.class;

    public void insertSubscription(Subscription subscription) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(subscription);

        manager.getTransaction().commit();
        manager.close();
    }

    public List<Subscription> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        TypedQuery<Subscription> query = manager.createQuery("SELECT s FROM Subscription s", subscriptionClass);
        List<Subscription> subscriptions = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return subscriptions;
    }

}
