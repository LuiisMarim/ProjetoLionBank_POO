/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pichau
 */
public class Usuario {
    
    private String usuario, senha, tipo_de_conta, valor_conta,cpf;
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo_de_conta() {
        return tipo_de_conta;
    }

    public void setTipo_de_conta(String tipo_de_conta) {
        this.tipo_de_conta = tipo_de_conta;
    }

    public String getValor_conta() {
        return valor_conta;
    }

    public void setValor_conta(String valor_conta) {
        this.valor_conta = valor_conta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuario(String usuario, String senha, String tipo_de_conta, String valor_conta, String cpf) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo_de_conta = tipo_de_conta;
        this.valor_conta = valor_conta;
        this.cpf = cpf;
    }
    
    
}

 