// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe ContaPoupanca) Prática 03 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 03/02/2021

package pratica03;

public class ContaPoupanca extends Contas {
    public void reajustar (double taxa) {
        double saldoAtual = this.getSaldo();
        double reajuste = saldoAtual * taxa;
        this.depositar(reajuste);
    }

    public void reajustar () {
        double taxa = 0.1;
        double saldoAtual = this.getSaldo();
        double reajuste = saldoAtual * taxa;
        this.depositar(reajuste);
    }

    public void tipoConta(){
        System.out.println("Tipo de conta: Conta Poupança");
    }
}