/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteExcluirPet {
    
    public static void main (String[] args){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Pet pe = em.find(Pet.class, 9);

        em.getTransaction().begin();
        em.remove(pe);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    
    
    
}
