package example.repository;

import example.Factory;
import example.entity.Device;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DeviceRepository {

    private final EntityManagerFactory factory = Factory.object;
    private final Class<Device> deviceClass = Device.class;

    public void insertDevice(Device device) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(device);

        manager.getTransaction().commit();
        manager.close();
    }

    public List<Device> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        TypedQuery<Device> query = manager.createQuery("SELECT d FROM Device d", deviceClass);
        List<Device> devices = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return devices;
    }

}
