/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersistirProduto {
    
    public static void main (String[] args){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Produto pro = new Produto();
        pro.setNome("arroz");
        pro.setValor(24.1);
        em.getTransaction().begin();
        em.persist(pro);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
