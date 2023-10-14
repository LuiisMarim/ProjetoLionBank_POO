
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Usuario usuario) throws SQLException{
        
        try (connection) {
            String sql = "insert into usuario(usuario,cpf,senha,valor_conta,tipo_de_conta) values('"+usuario.getUsuario()+"', '"+usuario.getCpf()+"', '"+usuario.getSenha()+"', '"+usuario.getValor_conta()+"', '"+usuario.getTipo_de_conta()+"'); ";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.execute();
        }
 
    }
    
}
