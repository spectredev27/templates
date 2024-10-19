package example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {

    private static final String unitName = "default";
    public static final EntityManagerFactory object = Persistence.createEntityManagerFactory(unitName);

}
