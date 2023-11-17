/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;
import view.SaldoGerente;

/**
 *
 * @author Pichau
 */
public class SaldoGerenteController {
    private SaldoGerente view;

    public SaldoGerenteController(SaldoGerente view) {
        this.view = view;
    }
    
       public void exibeTudo() throws SQLException{
        Usuario usuario;
        usuario = new Usuario ();
        
        
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        ArrayList<Usuario> usuarios = usuarioDao.selectAll();
        StringBuilder sb = new StringBuilder();
        for ( Usuario usuario1 : usuarios){
             sb.append(usuario1.getUsuario()).append(" -  CPF: ").append(usuario1.getCpf()).append(" - Tipos de conta (CORRENTE, SALÁRIO, POUPANÇA) - ").append(usuario1.getTipo_de_conta()).append(" - ").append(usuario1.getTipoSala()).append(" - ").append(usuario1.getTipoPoupa()).append("\n\n");
        }
            view.getPainel_Clientes().setText(sb.toString());
           
    }
       public void exibeSaldos() throws SQLException{
           
       String cpf_t = view.getTxt_cpf().getText();
       int cpf = Integer.parseInt(cpf_t);
       Usuario usuario = new Usuario (cpf);
       Connection conexao =  new Conexao().getConnection();  
       UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
       Usuario usuarioSelecionado = usuarioDao.selectPorCpfValores(usuario);
       StringBuilder sb = new StringBuilder();
       if (usuarioSelecionado != null) {
        sb.append("Saldos de conta (CORRENTE, SALÁRIO, POUPANÇA): ")
            .append(usuarioSelecionado.getValorCorre()).append(" - ")
            .append(usuarioSelecionado.getValorSala()).append(" - ")
            .append(usuarioSelecionado.getValorPoupa());
        view.getPainel_Saldo().setText(sb.toString());
        } else {
        view.getPainel_Saldo().setText("Usuário não encontrado");
        }
       
       
       
       
       
}
}