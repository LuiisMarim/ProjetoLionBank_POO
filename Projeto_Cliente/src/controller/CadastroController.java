     
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
     this.view = view;   
    }
    
      
     
    public void salvaUsuario (){
        
        
                
        String user = view.getTxt_nome().getText();
        String senha = view.getPassword_senha().getText();
        String tc = view.getTxt_conta().getText();
        String valor_c = view.getTxt_valor_conta().getText();
        String cpf_t = view.getTxt_cpf().getText();
        cpf_t = cpf_t.replaceAll("[^0-9]", "").replaceAll("[.,]", "");
        
        
        double valor = Double.parseDouble(valor_c);
        int cpf = Integer.parseInt(cpf_t);
        String corrente = "corrente";
        String poupanca = "poupanca";
        String salario = "salario";
        
        Usuario usuario = new Usuario (user, senha, tc, valor, cpf);
       
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao =  new UsuarioDAO(conexao);
            if (tc.equals(corrente)){
                
                usuarioDao.insertCorrente(usuario);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso !");
                
            }else if(tc.equals(poupanca)){
                
                usuarioDao.insertPoupanca(usuario);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso !");
                
            }else if(tc.equals(salario)){
                usuarioDao.insertSalario(usuario);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso !");      
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }
    
    
}    
 
