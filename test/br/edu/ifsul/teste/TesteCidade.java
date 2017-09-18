/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class TesteCidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteCidade() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TCC-2017-2PU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

   @Test
    public void teste(){
        boolean exception = false;
        try {
            Cidade c = new Cidade();
            c.setNome("Tuparendi");
            c.setEstado(em.find(Estado.class, 3));
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
