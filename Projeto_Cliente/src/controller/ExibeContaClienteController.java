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
import view.ExibeContas;

/**
 *
 * @author Pichau
 */
public class ExibeContaClienteController {
    
    private ExibeContas view;

    public ExibeContaClienteController(ExibeContas view) {
        this.view = view;
    }
    
    public void exibeContaClientePorCpf() throws SQLException{
        
         String cpf_t = view.getTxt_cpf().getText();
       int cpf = Integer.parseInt(cpf_t);
       Usuario usuario = new Usuario (cpf);
       Connection conexao =  new Conexao().getConnection();  
       UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
       Usuario usuarioSelecionado = usuarioDao.selectPorCpfContas(usuario);
       StringBuilder sb = new StringBuilder();
       if (usuarioSelecionado != null) {
        sb.append("Suas contas: ")
            .append(usuarioSelecionado.getTipoCorre()).append(" - ")
            .append(usuarioSelecionado.getTipoSala()).append(" - ")
            .append(usuarioSelecionado.getTipoPoupa());
            view.getPainel_Clientes().setText(sb.toString());
        } else {
            view.getPainel_Clientes().setText("Usuário não encontrado");
        }
       
    
    }
    
    
}
