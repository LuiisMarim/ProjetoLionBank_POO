/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import java.sql.SQLException;
import view.DeletarUsuario;
import java.sql.Connection;
import dao.UsuarioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import model.Usuario;


public class DeletarController {
    
    private DeletarUsuario view;

    public DeletarController(DeletarUsuario view) {
        this.view = view;
    }
    
    public void delete() throws SQLException{
    
        String cpf_d = view.getTextoCpf().getText();
        int cpf = Integer.parseInt(cpf_d);
        
        Usuario usuario = new Usuario (cpf);
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        Usuario usuarioSelecionado = usuarioDao.selectPorCpf(usuario);
        usuarioDao.delete(usuarioSelecionado);
        JOptionPane.showMessageDialog(null, "Usuario Apagado com Sucesso !");
        view.getTextoClientes().setText("");
          
              
    }
    
    public void show() throws SQLException{
    
        Usuario usuario;
        usuario = new Usuario ();
        
        
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        ArrayList<Usuario> usuarios = usuarioDao.selectAll();
        StringBuilder sb = new StringBuilder();
        for ( Usuario usuariousuario : usuarios){
             sb.append(usuariousuario.getUsuario()).append(" -  CPF: ").append(usuariousuario.getCpf()).append("\n");
        }
        //JOptionPane.showMessageDialog(view.getTextoClientes(), sb.toString());
            view.getTextoClientes().setText(sb.toString());
           // System.out.println(usuariousuario.getUsuario());
    }
    
}
