/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteListarPet {
    
    public static void main (String[] args){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        List<Pet> lista = em.createQuery("from Pet order by id").getResultList();
        for(Pet e : lista){
            System.out.println(" Id: " + e .getId() + " | Nome: " + e .getNome() + " | Peso: "
             + e.getPeso() + " | Especie: " + e.getEspecie() + " | Raça: " + e.getRaca().getNome());
        }
        em.close();
        emf.close();
        
    }
    
    
    
    
}
