package ru.fintech.qa.homework.utils.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.fintech.qa.homework.utils.hibernate.models.Animal;
import ru.fintech.qa.homework.utils.hibernate.models.Place;
import ru.fintech.qa.homework.utils.hibernate.models.Workman;
import ru.fintech.qa.homework.utils.hibernate.models.Zoo;

public class DBClient {
    public static int getQuantity(final String tableName) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        int quantity = session.createNativeQuery("select * from " + tableName + "").getResultList().size();
        session.close();
        return quantity;
    }

    public static int animalIdWhichCanBeInserted() {
        int animalId = 1;
        boolean failure = true;
        do {
            try {
                insertAnimalThenDelete(animalId);
                failure = false;

            } catch (Exception e) {
                System.out.println("One more time");
                animalId++;
            }
        }
        while (failure);
        return animalId;
    }

    public static void insertAnimalThenDelete(final int animalId) {
        Animal animalToInsert = new Animal();
        animalToInsert.setId(animalId);
        animalToInsert.setName("Johny");
        animalToInsert.setAge(1);
        animalToInsert.setType(1);
        animalToInsert.setSex(1);
        animalToInsert.setPlace(1);
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(animalToInsert);
        session.getTransaction().commit();
        session.beginTransaction();
        session.delete(animalToInsert);
        session.getTransaction().commit();
        session.close();
    }

    public static void insertWorkman(final int workmanId) {
        Workman workmanToInsert = new Workman();
        workmanToInsert.setId(workmanId);
        workmanToInsert.setName(null);
        workmanToInsert.setAge(1);
        workmanToInsert.setType(1);
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(workmanToInsert);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Null name can't be inserted");
        }
        session.close();
    }

    public static void insertPlace(final int placeId) {
        Place placeToInsert = new Place();
        placeToInsert.setId(placeId);
        placeToInsert.setRow(1);
        placeToInsert.setName("Place");
        placeToInsert.setPlaceNum(1);
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(placeToInsert);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        session.close();
    }

    public static void deletePlace(final int placeId) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(placeId);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        session.close();
    }

    public static void delPlace(final int placeId) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Place place = session.get(Place.class, placeId);
            session.delete(place);
        } catch (Exception e) {
            System.out.println("Somthing went wrong");
        }
        session.close();
    }

    public static String getZooNameById(final int zooId) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        Zoo zoo = session.createNativeQuery("select * from zoo", Zoo.class).getResultList().get(zooId);
        String zooName = zoo.getName();
        session.close();
        return zooName;
    }
}
