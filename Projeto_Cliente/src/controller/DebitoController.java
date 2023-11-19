
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Debito;

public class DebitoController {
    private Debito view;

    public DebitoController(Debito view) {
        this.view = view;
    }
    
    public void exibeSaldos() throws SQLException{
           
        String cpf_t = view.getTxt_cpf().getText();
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
    
 public void saidaDeDinheiroCorrente() throws SQLException{
    
    String cpf_t = view.getTxt_cpf().getText();
    int cpf = Integer.parseInt(cpf_t);
    String senha = view.getTxt_senha().getText();
    Usuario usuario = new Usuario (cpf, senha);
    Usuario usuarioSenha = new Usuario(senha);    
        
    Connection conexao =  new Conexao().getConnection();  
    UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
    Usuario usuarioSelecionado = usuarioDao.existeNoBancoPorCPFESenha(usuario);
    boolean existe = usuarioDao.existeNoBancoPorSenha(usuarioSenha);
    if(existe){
        if (usuarioSelecionado.getValorCorre() != 0.0) {
            
            String valorDebitado = view.getTxt_valor().getText();
            double valorDouble = Double.parseDouble(valorDebitado);
            double saldoAtual = usuarioSelecionado.getValorCorre();
            double limiteContaCorrente = -1000.00;
            double taxa = 0.01;
            double novoSaldo =  saldoAtual - valorDouble - (valorDouble * taxa);
            
            if(novoSaldo >= limiteContaCorrente){
                
                JOptionPane.showMessageDialog(null, "Seu novo saldo para conta corrente é: "+ novoSaldo);
                String corre = "corrente";
                Usuario usuarioDebitado = new Usuario (novoSaldo,corre,cpf);
                usuarioDao.updateNovaContaCorrente(usuarioDebitado);
                view.getPainel_saldo().setText("");
   
                
            }else{
                JOptionPane.showMessageDialog(null, "Limite da conta corrente atingido ou conta inexistente, entre em contado com seu gerente");
            }
        }
        }else{
          JOptionPane.showMessageDialog(view, "Senha invalida, tente de novo.");
        }
 }
 
 
 public void saidaDeDinheiroSalario() throws SQLException{
    
    String cpf_t = view.getTxt_cpf().getText();
    int cpf = Integer.parseInt(cpf_t);
    String senha = view.getTxt_senha().getText();
    Usuario usuario = new Usuario (cpf, senha);
    Usuario usuarioSenha = new Usuario(senha);    
    
    
    Connection conexao =  new Conexao().getConnection();  
    UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
    Usuario usuarioSelecionado = usuarioDao.existeNoBancoPorCPFESenha(usuario);
    boolean existe = usuarioDao.existeNoBancoPorSenha(usuarioSenha);
    if(existe){
        if (usuarioSelecionado.getValorSala() != 0.0) {
            
            String valorDebitado = view.getTxt_valor().getText();
            double valorDouble = Double.parseDouble(valorDebitado);
            double saldoAtual = usuarioSelecionado.getValorSala();
            double limiteContaSalario = 0;
            double taxa = 0.05;
            double novoSaldo =  saldoAtual - valorDouble - (valorDouble * taxa);
            
                if(novoSaldo >= limiteContaSalario){

                    JOptionPane.showMessageDialog(null, "Seu novo saldo para conta salário é: "+ novoSaldo);
                    String corre = "salário";
                    Usuario usuarioDebitado = new Usuario (novoSaldo,corre,cpf);
                    usuarioDao.updateNovaContaSalario(usuarioDebitado);
                    view.getPainel_saldo().setText("");



                }else{
                    JOptionPane.showMessageDialog(null, "Limite da conta corrente atingido ou conta inexistente, entre em contado com seu gerente");
                }
        }
 }  else{
          JOptionPane.showMessageDialog(view, "Senha invalida, tente de novo.");
        }
    
    
    
 }
 
  public void saidaDeDinheiroPoupanca() throws SQLException{
    
    String cpf_t = view.getTxt_cpf().getText();
    int cpf = Integer.parseInt(cpf_t);
    String senha = view.getTxt_senha().getText();
    Usuario usuario = new Usuario (cpf, senha);
    Usuario usuarioSenha = new Usuario(senha);
        
    Connection conexao =  new Conexao().getConnection();  
    UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
    Usuario usuarioSelecionado = usuarioDao.existeNoBancoPorCPFESenha(usuario);    
    boolean existe = usuarioDao.existeNoBancoPorSenha(usuarioSenha);
    
        if(existe) {
            if(usuarioSelecionado.getValorPoupa() != 0.0){
            String valorDebitado = view.getTxt_valor().getText();
            double valorDouble = Double.parseDouble(valorDebitado);
            double saldoAtual = usuarioSelecionado.getValorPoupa();
            double limiteContaSalario = 0;
            double novoSaldo =  saldoAtual - valorDouble;
            
                if(novoSaldo >= limiteContaSalario){

                    JOptionPane.showMessageDialog(null, "Seu novo saldo para conta poupança é: "+ novoSaldo);
                    String corre = "poupanca";
                    Usuario usuarioDebitado = new Usuario (novoSaldo,corre,cpf);
                    usuarioDao.updateNovaContaPoupanca(usuarioDebitado);
                    view.getPainel_saldo().setText("");



                }else{
                    JOptionPane.showMessageDialog(view, "Limite da conta corrente atingido ou conta inexistente, entre em contado com seu gerente");
                }
            }
        }else{
          JOptionPane.showMessageDialog(view, "Senha invalida, tente de novo.");
        }
}

















}
    

