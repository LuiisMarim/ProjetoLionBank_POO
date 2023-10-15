
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Gerente;
import view.MenuPrincipal;
import view.MenuPrincipalGerente;
import view.TelaLoginGerente;


public class LoginGerenteController {
    private TelaLoginGerente view; 

    public LoginGerenteController(TelaLoginGerente view) {
        this.view = view;
    }
    
    public void autenticarGerente() throws SQLException {
      // Buscar um User da View  
      String user = view.getTxt_entrarGerente().getText();
      String senha = view.getPassword_gerente().getText();
      
      Gerente gerenteAutenticar = new Gerente(user,senha);
      // Verifica se existe no Banco de Dados
      Connection conexao = new Conexao().getConnection();
      UsuarioDAO usuarioDao =  new UsuarioDAO(conexao);
      
      boolean existe = usuarioDao.existeGerenteNoBancoPorUsuarioESenha(gerenteAutenticar);
       
      
      // Se Existir
      if (existe){
        MenuPrincipalGerente viewPrincipalGerente = new MenuPrincipalGerente();
        viewPrincipalGerente.setVisible(true);
      }else{
          JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos, tente de novo.");
      }
       
    }
    
    
}
