/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class ContaSalario {
    public void criaContaSalario(double valor, int cpf) throws SQLException{
        String corre = "salário";
        
        Usuario usuario = new Usuario (valor,corre,cpf);
        Usuario usuarioCPF = new Usuario(cpf);
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        Usuario usuarioSelecionado = usuarioDao.selectPorCpf(usuarioCPF);
        if (usuarioSelecionado != null){
            usuarioDao.updateNovaContaSalario(usuario);
            JOptionPane.showMessageDialog(null, "Conta Salário Criada Com Sucesso !");
        }else{
            JOptionPane.showMessageDialog(null, "Conta Salário não pode ser criada !");
        }    
    }
}
