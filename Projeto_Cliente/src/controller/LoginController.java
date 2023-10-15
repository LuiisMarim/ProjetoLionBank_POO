
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastro;
import view.MenuPrincipal;
import view.TelaLogin;


public class LoginController {
    private TelaLogin view;

    public LoginController(TelaLogin view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
      // Buscar um User da View  
      String user = view.getTxtLogin_usuario().getText();
      String senha = view.getPasswordSenha_login().getText();
      
      Usuario usuarioAutenticar = new Usuario(user,senha);
      // Verifica se existe no Banco de Dados
      Connection conexao = new Conexao().getConnection();
      UsuarioDAO usuarioDao =  new UsuarioDAO(conexao);
      
      boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
       
      
      // Se Existir
      if (existe){
        MenuPrincipal viewPrincipal = new MenuPrincipal();
        viewPrincipal.setVisible(true);
      }else{
          JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos, tente de novo.");
      }
       
    }
    
    public void exibe(){
       Cadastro viewCadastro = new Cadastro();
       viewCadastro.setVisible(true);
    }
    
}
