// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Principal) Prática 03 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 03/02/2021

package pratica03;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        Contas c = new Contas();
        ContaPoupanca cp = new ContaPoupanca();

        cp.depositar(1000);
        cp.reajustar(0.2);
        cp.sacar(500);
        System.out.println("Saldo Conta Poupança: " + cp.getSaldo());
        
        System.out.println("====================");
        c.tipoConta();

        System.out.println("====================");
        cp.tipoConta();

        String name = JOptionPane.showInputDialog("Digite seu nome");
        JOptionPane.showMessageDialog(null, "Bem vindo " + name);
    }
    
}
