     
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastro;




public class CadastroController {
    private Cadastro view;  
    
    public CadastroController(Cadastro view){
     this.view =view;   
    }
    
    public void salvaUsuario (){
        
        
                
        String user = view.getTxt_nome().getText();
        String senha = view.getPassword_senha().getText();
        String tc = view.getTxt_conta().getText();
        String valor = view.getTxt_valor_conta().getText();
        String cpf = view.getTxt_cpf().getText();
        cpf = cpf.replaceAll("[^0-9]", "");
        
        Usuario usuario = new Usuario (user, senha, tc, valor, cpf);
       
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao =  new UsuarioDAO(conexao);
            usuarioDao.insert(usuario);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso !");
            
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }
}    
 
