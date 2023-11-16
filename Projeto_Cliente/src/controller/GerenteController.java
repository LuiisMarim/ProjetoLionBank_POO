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
import view.CriarNovasContas;
import view.MenuPrincipalGerente;
import view.DeletarUsuario;
import view.ExibirClientes;
import view.SaldoGerente;



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
    
    public void exibeClientes(){
    
        ExibirClientes viewExibe = new ExibirClientes();
        viewExibe.setVisible(true);
    }
    
    public void exibeCriaContas(){
        CriarNovasContas viewContas = new CriarNovasContas();
        viewContas.setVisible(true);
    }
    
    public void exibeSaldoGerente(){
        SaldoGerente viewSaldo = new SaldoGerente();
        viewSaldo.setVisible(true);
    }
}
