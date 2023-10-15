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
    
    private String usuario, senha, tipo_de_conta;
    private int  cpf;
    private double valor_conta;
    

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

    public double getValor_conta() {
        return valor_conta;
    }

    public void setValor_conta(double valor_conta) {
        this.valor_conta = valor_conta;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Usuario(String usuario, String senha, String tipo_de_conta, double valor_conta, int cpf) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo_de_conta = tipo_de_conta;
        this.valor_conta = valor_conta;
        this.cpf = cpf;
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    
    
}

 