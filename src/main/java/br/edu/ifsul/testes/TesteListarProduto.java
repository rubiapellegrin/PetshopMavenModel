/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteListarProduto {
    
    public static void main (String[] args){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        List<Produto> lista = em.createQuery("from Produto order by id").getResultList();
        for(Produto e : lista){
            System.out.println(" Id: " + e .getId() + " | Nome: " + e .getNome() + " | Valor: "
             + e.getValor());
        }
        em.close();
        emf.close();
        
    }
    
    
    
    
}
