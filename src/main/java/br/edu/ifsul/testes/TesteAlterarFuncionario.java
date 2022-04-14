/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteAlterarFuncionario {
    
    public static void main (String[] args){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Funcionario fu = em.find(Funcionario.class, "Rubia");
        fu.setSenha("12345");
        fu.setAtivo(false);
        em.getTransaction().begin();
        em.merge(fu);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    
    
    
}
