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
    
    private String usuario, senha, tipo_de_conta, tipoSala, tipoPoupa, tipoCorre;
    private int  cpf;
    private double valor_conta, valorCorre, valorPoupa, ValorSala;

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public String getTipoPoupa() {
        return tipoPoupa;
    }

    public void setTipoPoupa(String tipoPoupa) {
        this.tipoPoupa = tipoPoupa;
    }

    public String getTipoCorre() {
        return tipoCorre;
    }

    public void setTipoCorre(String tipoCorre) {
        this.tipoCorre = tipoCorre;
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

    public double getValorCorre() {
        return valorCorre;
    }

    public void setValorCorre(double valorCorre) {
        this.valorCorre = valorCorre;
    }

    public double getValorPoupa() {
        return valorPoupa;
    }

    public void setValorPoupa(double valorPoupa) {
        this.valorPoupa = valorPoupa;
    }

    public double getValorSala() {
        return ValorSala;
    }

    public void setValorSala(double ValorSala) {
        this.ValorSala = ValorSala;
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

    public Usuario(int cpf) {
        this.cpf = cpf;
    }

    public Usuario() {
    }

    public Usuario(String usuario, String senha, String tipo_de_conta, String tipoSala, String tipoPoupa, int cpf, double valor_conta) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo_de_conta = tipo_de_conta;
        this.tipoSala = tipoSala;
        this.tipoPoupa = tipoPoupa;
        this.cpf = cpf;
        this.valor_conta = valor_conta;
    }

    public Usuario( double valor_conta , String tipo_de_conta, int cpf) {
        this.tipo_de_conta = tipo_de_conta;
        this.valor_conta = valor_conta;
        this.cpf = cpf;
    }

    public Usuario(double valor_conta) {
        this.valor_conta = valor_conta;
    }

    public Usuario(double valor_conta,String tipo_de_conta) {
        this.tipo_de_conta = tipo_de_conta;
        this.valor_conta = valor_conta;
    }
    
    
    


 

  
 
    
    
    
}

 