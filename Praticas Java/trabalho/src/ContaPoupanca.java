// Disciplina      : ECO0015 - Técnicas de Programação
// Professor       : Wendley Souza da Silva
// Descrição       : (Subclasse Conta Poupança) - Trabalho - Java
// Autor(a)        : Izaias Machado Pessoa Neto
// Data de Entrega : 12/03/2021

package trabalho;

public class ContaPoupanca extends Contas {
    private double taxa = 10;
    private String tipoConta = "Conta-Poupanca";

    public void reajustar() {
        reajustar(taxa);
    }

    public void reajustar(double novaTaxa) {
        double saldoAtual = this.getSaldo();
        double reajuste = saldoAtual * (novaTaxa / 100.00);
        this.depositar(reajuste);
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

    public void setTaxa(double novaTaxa) {
        this.taxa = novaTaxa;
    }

    public double getTaxa() {
        return this.taxa;
    }
}
