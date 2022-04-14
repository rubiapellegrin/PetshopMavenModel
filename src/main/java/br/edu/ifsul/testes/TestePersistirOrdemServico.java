/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Pet;
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
public class TestePersistirOrdemServico {
    
    public static void main (String[] args) throws ParseException{
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetshopMavenModelPU");
        EntityManager em = emf.createEntityManager();
        OrdemServico ord = new OrdemServico();
        ord.setDescricao("limpar");
        String dataAux = "23/11/2015";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data1 =(Date)formato.parse(dataAux);
        Calendar cal = Calendar.getInstance();
        cal.setTime(data1);
        ord.setData(cal);
        Funcionario fu = em.find(Funcionario.class, "rubia");
        Pet pe = em.find(Pet.class, 4);
        Pessoa ser = em.find(Pessoa.class, 1);
        ord.setPet(pe);
        ord.setFunc(fu);
        ord.setPessoa(ser);
        em.getTransaction().begin();
        em.persist(ord);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    
    
    
}
