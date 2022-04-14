/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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

/**
 *
 * @author MASTER
 */
@Entity
@Table(name="itemServico")
public class ItemServico implements Serializable{
    @Id
    @SequenceGenerator(name= "seq_itemservico", sequenceName = "seq_itemservico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_itemservico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "quantidade")
    private double quantidade;
    @Column(name = "valorUnitario")
    private double valorUnitario;
    @Column(name = "valorTotal")
    private double valorTotal;
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable= false)
    private Servico ser;

    
    public ItemServico(){
    
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public Servico getSer() {
        return ser;
    }

    public void setSer(Servico ser) {
        this.ser = ser;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final ItemServico other = (ItemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
