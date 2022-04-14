/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Raca;
import br.edu.ifsul.modelo.Servico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersistirServico {
    
    public static void main (String[] args) throws ParseException{
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Servico ser = em.find(Servico.class, 1);
        Produto produto1 = em.find(Produto.class, 1);
        Produto produto2 = em.find(Produto.class, 2);
        ser.getProdutos().add(produto1);                                        //add adiciona e remove remove
        ser.getProdutos().add(produto2);

        em.getTransaction().begin();
        em.persist(ser);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    
    
    
}
