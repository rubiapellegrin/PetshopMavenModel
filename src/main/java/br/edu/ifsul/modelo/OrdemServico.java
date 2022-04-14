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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MASTER
 */
@Entity
@Table(name="OrdemServico")
public class OrdemServico implements Serializable {
    
    @Id
    @SequenceGenerator(name= "seq_ordemServico", sequenceName = "seq_ordemServico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordemServico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message="A descricao não pode ser em branco. ")
    @Length(max = 50, message = "A descricao não pode ter mais que {max}  caracteres. ")
    @Column(name = "descricao", nullable = false, length = 100) 
    private String descricao;
    @Column(name = "data") 
    private Calendar data;
    @Column(name = "valorTotal", nullable = false, columnDefinition="numeric(5,2)")
    private double valorTotal;
    @NotNull(message = "O Funcionario deve ser informado. ")
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "nome", nullable= false)
    private Funcionario func;
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable= false)
    private Pet pe;
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable= false)
    private Pessoa ser;

    public OrdemServico(){
    
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }
   

    
     public Pet getPet() {
        return pe;
    }

    public void setPet(Pet pe) {
        this.pe = pe;
    }

    public Pessoa getPessoa() {
        return ser;
    }

    public void setPessoa(Pessoa ser) {
        this.ser = ser;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
