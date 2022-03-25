// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Contas) Prática 03 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 03/02/2021

package pratica03;

/**
 *
 * @author Wendley
 * Para aula pratica
 */

 public class Contas {
    private double saldo;
    public int numero;

    public Contas() {
        this.saldo = 0;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            double novoSaldo = saldo - valor;
            this.saldo = novoSaldo;
            System.out.println("Saque efetuado com sucesso");
        }

        else System.out.println("Saldo insuficiente");
    }

    public void tipoConta(){
        System.out.println("Tipo de conta: comum");
    }

    public double getSaldo() {
        return saldo;
    }
}