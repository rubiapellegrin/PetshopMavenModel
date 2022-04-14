/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteAlterarRaca {
    
    public static void main (String[] args){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Raca raca = em.find(Raca.class, 1);
        raca.setNome("chow chow");
        em.getTransaction().begin();
        em.merge(raca);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    
    
    
}
