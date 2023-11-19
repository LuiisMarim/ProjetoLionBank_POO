/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Debito;
import view.Deposito;
import view.ExibeContas;
import view.Extrato;
import view.MenuPrincipal;

/**
 *
 * @author Pichau
 */
public class MenuPrincipalController {
    private MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    public void showContas(){
    
        ExibeContas exibeContas = new ExibeContas();
        exibeContas.setVisible(true);
    
    }
    
    public void showDeposito(){
        Deposito exibeDeposito = new Deposito();
        exibeDeposito.setVisible(true);
    
    }
    
    public void showDebito(){
        Debito exibeDebito = new Debito();
        exibeDebito.setVisible(true);
        
    }
    public void showExtrato(){
        Extrato exibeExtrato = new Extrato();
        exibeExtrato.setVisible(true);
    }
    
}
