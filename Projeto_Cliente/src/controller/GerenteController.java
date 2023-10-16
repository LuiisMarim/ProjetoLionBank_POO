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
import view.Cadastro;
import view.MenuPrincipalGerente;
import view.DeletarUsuario;



public class GerenteController {
 
    private MenuPrincipalGerente view;
    
    

    public GerenteController(MenuPrincipalGerente view) {
        this.view = view;
    }

    

    
    
    
    
    
    
    public void exibeCadastro(){
       Cadastro viewCada = new Cadastro();
       viewCada.setVisible(true);
    }
    
    public void exibeDelete() throws SQLException{
        
        DeletarUsuario viewDelete = new DeletarUsuario ();
        viewDelete.setVisible(true);
    
    }
    
}
