
package model;


public class Gerente {
    
    private String gerente, senha_gerente;

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getSenha_gerente() {
        return senha_gerente;
    }

    public void setSenha_gerente(String senha_gerente) {
        this.senha_gerente = senha_gerente;
    }

    public Gerente(String gerente, String senha_gerente) {
        this.gerente = gerente;
        this.senha_gerente = senha_gerente;
    }

  
    
    
}
