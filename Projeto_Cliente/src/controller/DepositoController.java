
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Deposito;


public class DepositoController {
    
    private Deposito view;

    public DepositoController(Deposito view) {
        this.view = view;
    }
    public void exibeSaldos() throws SQLException{
           
        String cpf_t = view.getTxt_cpf1().getText();
        int cpf = Integer.parseInt(cpf_t);
        Usuario usuario = new Usuario (cpf);
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        Usuario usuarioSelecionado = usuarioDao.selectPorCpfValores(usuario);
        StringBuilder sb = new StringBuilder();
        if (usuarioSelecionado != null) {
         sb.append("Saldos de conta (CORRENTE, SALÁRIO, POUPANÇA): ")
             .append(usuarioSelecionado.getValorCorre()).append(" , ")
             .append(usuarioSelecionado.getValorSala()).append(" , ")
             .append(usuarioSelecionado.getValorPoupa());
             view.getPainel_saldo().setText(sb.toString());
         } else {
             view.getPainel_saldo().setText("Usuário não encontrado");
         }
    
    }
    
    
    
    public void entradaDeDinheiroCorrente() throws SQLException{
    
        String cpf_t = view.getTxt_cpf().getText();
        int cpf = Integer.parseInt(cpf_t);
        Usuario usuario = new Usuario (cpf);
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        Usuario usuarioSelecionado = usuarioDao.selectPorCpfValores(usuario);   
        if (usuarioSelecionado != null){
            if (usuarioSelecionado.getValorCorre() != 0.0){
                double saldo = usuarioSelecionado.getValorCorre();
                String entrada = view.getTxt_valor().getText();
                double entradaDouble = Double.parseDouble(entrada);
                double conta = (saldo+entradaDouble);
                String corre = "corrente";
                Usuario usuarioDepositado = new Usuario (conta,corre,cpf);
                usuarioDao.updateNovaContaCorrente(usuarioDepositado);
                view.getPainel_saldo().setText("");
                JOptionPane.showMessageDialog(null, "FEITO !");
            
            }else{
                view.getPainel_saldo().setText("Conta não existe! Entre em contato com o seu Gerente para abrir uma nova conta LION CORRENTE");
        }
        
        }else {
            view.getPainel_saldo().setText("Usuário não encontrado");
        }
    }
    
        public void entradaDeDinheiroSalario() throws SQLException{
    
        String cpf_t = view.getTxt_cpf().getText();
        int cpf = Integer.parseInt(cpf_t);
        Usuario usuario = new Usuario (cpf);
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        Usuario usuarioSelecionado = usuarioDao.selectPorCpfValores(usuario);   
        if (usuarioSelecionado != null){
            if(usuarioSelecionado.getValorSala() != 0.0){
                double saldo = usuarioSelecionado.getValorSala();
                String entrada = view.getTxt_valor().getText();
                double entradaDouble = Double.parseDouble(entrada);
                double conta = (saldo+entradaDouble);
                String corre = "salário";
                Usuario usuarioDepositado = new Usuario (conta,corre,cpf);
                usuarioDao.updateNovaContaSalario(usuarioDepositado);
                view.getPainel_saldo().setText("");
                JOptionPane.showMessageDialog(null, "FEITO !");
            
            }else{
                view.getPainel_saldo().setText("Conta não existe! Entre em contato com o seu Gerente para abrir uma nova conta LION SALÁRIO");
            }
        
        }else {
            view.getPainel_saldo().setText("Usuário não encontrado");
        }
    }
        
        public void entradaDeDinheiroPoupanca() throws SQLException{
    
        String cpf_t = view.getTxt_cpf().getText();
        int cpf = Integer.parseInt(cpf_t);
        Usuario usuario = new Usuario (cpf);
        Connection conexao =  new Conexao().getConnection();  
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        Usuario usuarioSelecionado = usuarioDao.selectPorCpfValores(usuario);   
        if (usuarioSelecionado != null){
            if(usuarioSelecionado.getValorPoupa() != 0.0  ){
                double saldo = usuarioSelecionado.getValorPoupa();
                String entrada = view.getTxt_valor().getText();
                double entradaDouble = Double.parseDouble(entrada);
                double conta = (saldo+entradaDouble);
                String corre = "poupanca";
                Usuario usuarioDepositado = new Usuario (conta,corre,cpf);
                usuarioDao.updateNovaContaPoupanca(usuarioDepositado);
                view.getPainel_saldo().setText("");
                JOptionPane.showMessageDialog(null, "FEITO !");
            
            }else{
                view.getPainel_saldo().setText("Conta não existe! Entre em contato com o seu Gerente para abrir uma nova conta LION POUPANÇA");
            }
        
        }else {
            view.getPainel_saldo().setText("Usuário não encontrado");
        }
    }
    
    
    
}
