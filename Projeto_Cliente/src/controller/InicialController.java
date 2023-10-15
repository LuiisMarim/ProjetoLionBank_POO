 
package controller;

import view.TelaInicial;
import view.TelaLogin;


public class InicialController {
    private TelaInicial view;

    public InicialController(TelaInicial view) {
        this.view = view;
    }
    
    public void exibe(){
       TelaLogin viewTelaLogin = new TelaLogin();
       viewTelaLogin.setVisible(true);
        
    }
}
