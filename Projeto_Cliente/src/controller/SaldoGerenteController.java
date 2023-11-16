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
}
