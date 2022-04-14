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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MASTER
 */
@Entity
@Table(name="funcionario")

public class Funcionario extends Pessoa implements Serializable{
    
  
   //@SequencyGenerator(name= "seq_estado", sequenceName = "seq_estado_id", allocationSize = 1)
   //@GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
    @NotBlank(message="O nome não pode ser em branco. ")
    @Length(max = 50, message = "O nome não pode ter mais que {max}  caracteres. ")
    @Column(name = "nome", nullable = false, length = 50) 
    private String nomeUsuario;
    @NotBlank(message="A senha não pode ser em branco. ")
    @Length(max = 50, message = "A senha não pode ter mais que {max}  caracteres. ")
    @Column(name = "senha", nullable = false, length = 50)
    private String senha;
    @NotNull(message = "O modo não pode ser em branco. ")
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    
    
    public Funcionario(){

    }

    public String getNomeusuario() {
        return nomeUsuario;
    }

    public void setNomeusuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


}
