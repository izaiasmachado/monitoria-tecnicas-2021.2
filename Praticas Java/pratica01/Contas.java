// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Contas) Prática 01 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 18/01/2021

package pratica01;

public class Contas {
    int numero;
    String nome;
    double saldo;
    
    public void depositar (double valor) {
        this.saldo += valor;
    }

    public boolean sacar (double valor) {
        if (this.saldo < valor) return false;

        this.saldo -= valor;
        return true;
    }

    public double getSaldo () {
        return this.saldo;
    }

    public int getNumero () {
        return this.numero;
    }

    public String getNome () {
        return this.nome;
    }
}