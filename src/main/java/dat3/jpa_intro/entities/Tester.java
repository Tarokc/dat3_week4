/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3.jpa_intro.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mathias
 */
public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        Person p1 = new Person("Morten", 1963);
        Person p2 = new Person("Peter", 1959);
        
        Address a1 = new Address("Store Torv 1", 2323, "Nr. Snede");
        Address a2 = new Address("Langgade 34", 1212, "Valby");
        
        p1.setAddress(a1);
        p2.setAddress(a2);
        
        em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            //em.persist(a1);
            //em.persist(a2);
        em.getTransaction().commit();
        
        System.out.println("p1: " + p1.getP_id());
        System.out.println("p2: " + p2.getP_id());
        
        System.out.println("Mortens gade: " + p1.getAddress().getStreet());
        
        System.out.println(a1.getPerson().getName());
    }
}