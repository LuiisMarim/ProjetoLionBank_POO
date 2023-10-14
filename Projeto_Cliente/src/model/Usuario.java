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
    private float cpf, valor_conta;
    private String usuario, senha;

    public Usuario(float cpf, float valor_conta, String usuario, String senha) {
        this.cpf = cpf;
        this.valor_conta = valor_conta;
        this.usuario = usuario;
        this.senha = senha;
    }

    
    
    
    
    
    public float getCpf() {
        return cpf;
    }

    public void setCpf(float cpf) {
        this.cpf = cpf;
    }

    public float getValor_conta() {
        return valor_conta;
    }

    public void setValor_conta(float valor_conta) {
        this.valor_conta = valor_conta;
    }

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
    
    
}
