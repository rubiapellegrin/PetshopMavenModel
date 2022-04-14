/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteListarFuncionario {
    
    public static void main (String[] args){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        List<Funcionario> lista = em.createQuery("from Funcionario order by nome").getResultList();
        for(Funcionario e : lista){
            System.out.println(" Nome: " + e .getNome() + " | Senha: " + e .getSenha() + " | Situação: " + e .isAtivo() );
        }
        em.close();
        emf.close();
        
    }
    
    
    
    
}
