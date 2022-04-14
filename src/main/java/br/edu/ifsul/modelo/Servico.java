/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MASTER
 */
@Entity
@Table(name="servico")
public class Servico implements Serializable{

    @Id
    @SequenceGenerator(name= "seq_servico", sequenceName = "seq_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message="O nome não pode ser em branco. ")
    @Length(max = 50, message = "O nome não pode ter mais que {max}  caracteres. ")
    @Column(name = "nome", nullable = false, length = 100) 
    private String nome;
    @Column(name = "valor", nullable=false, columnDefinition="numeric(5,2)")
    private double valor;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produtos", 
            joinColumns = 
                @JoinColumn(name = "nome_servico", referencedColumnName = "nome",
                    nullable = false),
            inverseJoinColumns =
                     @JoinColumn(name = "nome_produto", referencedColumnName = "nome",nullable = false))

    Set<Produto> produtos = new HashSet<>();


    public Servico(){
    
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    
    
    
}
