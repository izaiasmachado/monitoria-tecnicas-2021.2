// Disciplina      : ECO0015 - Técnicas de Programação
// Professor       : Wendley Souza da Silva
// Descrição       : (Classe de Contas) - Trabalho - Java
// Autor(a)        : Izaias Machado Pessoa Neto
// Data de Entrega : 12/03/2021

package trabalho;

public class Contas {
    private int numero;
    private double saldo;
    private String tipoConta;
    private String nome;

    public Contas() {
        this.saldo = 0;
        this.tipoConta = "Conta-Comum";
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNumero(int novoNumero) {
        this.numero = novoNumero;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > saldo) return false;
        double novoSaldo = saldo - valor;
        this.saldo = novoSaldo;

        return true;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }
}