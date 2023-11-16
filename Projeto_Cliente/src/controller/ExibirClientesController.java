
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;
import view.ExibirClientes;


public class ExibirClientesController {
    
    private ExibirClientes view; 

    public ExibirClientesController(ExibirClientes view) {
        this.view = view;
    }
    
    
    public void exibe() throws SQLException{
        
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
            view.getPainel_Clientes().setText(sb.toString());
           // System.out.println(usuariousuario.getUsuario());
    
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
        //JOptionPane.showMessageDialog(view.getTextoClientes(), sb.toString());
            view.getPainel_Clientes().setText(sb.toString());
           // System.out.println(usuariousuario.getUsuario());
    
    }
    
    
    
    
}
