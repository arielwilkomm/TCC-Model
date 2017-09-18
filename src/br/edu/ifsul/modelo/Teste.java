/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory emf;
    EntityManager em;
            emf = Persistence.createEntityManagerFactory("TCC-2017-2PU");
        em = emf.createEntityManager();
    }
    
    
}
