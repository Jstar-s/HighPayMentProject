package com.jstar;

import com.jstar.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Jayson
 * @version 1.0
 * @date 2023/8/20 14:58
 */
public class HibernateTest {


    private SessionFactory sessionFactory;


    @Before
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    @Test
    public void TestInsert() {
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustName("zhang");
            session.save(customer);
            transaction.commit();
        }
    }

}
