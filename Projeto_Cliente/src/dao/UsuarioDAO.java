
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Usuario usuario) throws SQLException{
        
        try (connection) {
            String sql = "insert into usuario(usuario,cpf,senha,valor_conta,tipo_de_conta) values(?,?,?,?,?); ";
       
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getUsuario());
            statement.setInt(2, usuario.getCpf());
            statement.setString(3, usuario.getSenha());
            statement.setDouble(4, usuario.getValor_conta());
            statement.setString(5, usuario.getTipo_de_conta());
            statement.execute();
            
        }
 
    }
    
    public void update(Usuario usuario) throws SQLException{
        
        String sql = "update into usuario set usuario = ?, senha = ? where cpf = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.setInt(3, usuario.getCpf()); 
        statement.execute();
        
    }  
    
    public void insertOrUpdade(Usuario usuario) throws SQLException{
        
        if(usuario.getCpf() > 0){
            update(usuario);
        }else{
            insert(usuario);
        }
    
    }
    
    public void delete (Usuario usuario) throws SQLException{
        String sql = "delete from usuario where cpf = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getCpf()); 
        statement.execute();
    }
    
    public ArrayList<Usuario> selectAll() throws SQLException{
        String sql = "select * from usuario  ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            String usuario = resultSet.getString("usuario"); 
            String senha  =  resultSet.getString("senha");
            String tipo_de_conta =  resultSet.getString("tipo_de_conta");            
            int  cpf = resultSet.getInt("cpf");
            double valor_conta = resultSet.getDouble("valor_conta");
            
            Usuario usarioComDadosDoBanco = new Usuario(usuario,senha,tipo_de_conta, valor_conta,cpf);
            usuarios.add(usarioComDadosDoBanco);
            
        }
        
        
        return usuarios;
    }
    
    public Usuario selectPorCpf(Usuario usuario) throws SQLException{
        
        String sql = "select * from usuario where cpf = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getCpf());
        
        return pesquisa(statement).get(0);
       
        
        
        
    }
    
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        //DA P MOSTRAR AS COISAS COM ISSO AQUI (verificar usuarioDao)
        String sql = "select * from usuario where usuario = ? and senha = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        //JOptionPane.showMessageDialog(null, usuario.getUsuario());
        
       return resultSet.next();
    }

    
    
}
