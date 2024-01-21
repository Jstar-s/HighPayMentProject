package com.jstar;

import com.jstar.pojo.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/8/20 16:19
 */
public class JpaTest{

    private EntityManagerFactory factory;

    @Before
    public void before() {
         factory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    @Test
    public void TestCreate() {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Customer customer = new Customer();
        customer.setCustName("jpa");
        entityManager.persist(customer);
        transaction.commit();
    }

    @Test
    public void Testds() {


    }




}
