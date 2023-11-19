/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import view.Extrato;

/**
 *
 * @author Pichau
 */
public class ExtratoController {
    Extrato view;

    public ExtratoController(Extrato view) {
        this.view = view;
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
             .append(usuarioSelecionado.getValorCorre()).append(" , ")
             .append(usuarioSelecionado.getValorSala()).append(" , ")
             .append(usuarioSelecionado.getValorPoupa());
             view.getPainel_saldo().setText(sb.toString());
         } else {
             view.getPainel_saldo().setText("Usuário não encontrado");
         }
    
    }
    
  
 
}
