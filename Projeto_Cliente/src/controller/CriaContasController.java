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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastro;
import view.CriarNovasContas;

/**
 *
 * @author Pichau
 */
public class CriaContasController {
    
    private CriarNovasContas view;

    public CriaContasController(CriarNovasContas view) {
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
     
     public void criaContaCorrente() throws SQLException{
         
        String cpf_t = view.getTxt_cpf().getText();
        String valor_c = view.getTxt_valor().getText();
        double valor = Double.parseDouble(valor_c);
        int cpf = Integer.parseInt(cpf_t);
        String corre = "corrente";
        
        Usuario usuario = new Usuario (valor,corre,cpf);
        Usuario usuarioCPF = new Usuario(cpf);
            Connection conexao =  new Conexao().getConnection(); 
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            Usuario usuarioSelecionado = usuarioDao.selectPorCpf(usuarioCPF);
            if (usuarioSelecionado != null){
                usuarioDao.updateNovaContaCorrente(usuario);
                JOptionPane.showMessageDialog(null, "Conta Corrente Criada Com Sucesso !");
            view.getPainel_Clientes().setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Conta Corrente Criada Com Sucesso !");
            } 
         
        
     }
     
       public void criaContaPoupanca() throws SQLException{
         
        String cpf_t = view.getTxt_cpf().getText();
        String valor_c = view.getTxt_valor().getText();
        double valor = Double.parseDouble(valor_c);
        int cpf = Integer.parseInt(cpf_t);
        String corre = "poupança";
        
        Usuario usuario = new Usuario (valor,corre,cpf);
        Usuario usuarioCPF = new Usuario(cpf);
       
            Connection conexao =  new Conexao().getConnection();  
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            Usuario usuarioSelecionado = usuarioDao.selectPorCpf(usuarioCPF);
            if (usuarioSelecionado != null){
                usuarioDao.updateNovaContaPoupanca(usuario);
                JOptionPane.showMessageDialog(null, "Conta Poupança Criada Com Sucesso !");
                view.getPainel_Clientes().setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Conta Poupança não pode ser criada !");
            }
    
       }
        
       public void criaContaSalario() throws SQLException{
         
        String cpf_t = view.getTxt_cpf().getText();
        String valor_c = view.getTxt_valor().getText();
        double valor = Double.parseDouble(valor_c);
        int cpf = Integer.parseInt(cpf_t);
        String corre = "salário";
        
        Usuario usuario = new Usuario (valor,corre,cpf);
        Usuario usuarioCPF = new Usuario(cpf);
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        Usuario usuarioSelecionado = usuarioDao.selectPorCpf(usuarioCPF);
        if (usuarioSelecionado != null){
            usuarioDao.updateNovaContaSalario(usuario);
            JOptionPane.showMessageDialog(null, "Conta Salário Criada Com Sucesso !");
            view.getPainel_Clientes().setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Conta Salário não pode ser criada !");
        }    
     } 
       
         
}


