/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MASTER
 */

@Entity
@Table(name = "pet")
public class Pet implements Serializable {
    
    @Id
    @SequenceGenerator(name= "seq_pet", sequenceName = "seq_pet_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pet", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message="O nome não pode ser em branco. ")
    @Length(max = 50, message = "O nome não pode ter mais que {max}  caracteres. ")
    @Column(name = "nome", nullable = false, length = 100) 
    private String nome;
    @NotBlank(message="A data de nascimento não pode ser em branco. ")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false) 
    private Calendar nascimento;
    @Column(name = "peso") 
    private double peso;
    @NotBlank(message="A especie não pode ser em branco. ")
    @Length(max = 50, message = "A especie não pode ter mais que {max}  caracteres. ")
    @Column(name = "especie", nullable = false, length = 100)
    private String especie;
    @NotNull(message = "A pet deve ser informado. ")
    @ManyToOne
    @JoinColumn(name = "raca", referencedColumnName = "id", nullable= false)
    private Raca raca;

    public Pet(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pet other = (Pet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
