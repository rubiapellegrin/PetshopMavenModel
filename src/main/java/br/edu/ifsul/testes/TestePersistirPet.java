/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
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
public class TestePersistirPet {
    
    public static void main (String[] args) throws ParseException{
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Pet pe = new Pet();
        pe.setNome("guri");
        pe.setEspecie("vira-lata");
        String datanasc = "23/11/2015";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data1 =(Date)formato.parse(datanasc);
        Calendar cal = Calendar.getInstance();
        cal.setTime(data1);
        pe.setNascimento(cal);
        Raca ra = em.find(Raca.class, 1);
        pe.setRaca(ra);
        em.getTransaction().begin();
        em.persist(pe);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    
    
    
}
