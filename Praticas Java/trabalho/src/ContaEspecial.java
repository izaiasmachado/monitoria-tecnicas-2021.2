// Disciplina      : ECO0015 - Técnicas de Programação
// Professor       : Wendley Souza da Silva
// Descrição       : (Subclasse Conta Especial) - Trabalho - Java
// Autor(a)        : Izaias Machado Pessoa Neto
// Data de Entrega : 12/03/2021

package trabalho;

public class ContaEspecial extends Contas {
    private int limite;
    private double multa;
    private String tipoConta = "Conta-Especial";

    public boolean sacar(double valor) {
        double valorLimite = limite;
        if (valor > (this.getSaldo() + valorLimite)) return false;        
        double novoSaldo = this.getSaldo() - valor; 
        this.setSaldo(novoSaldo);
        this.descontar();
        return true;
    }

    public boolean descontar() {
        if (this.getSaldo() >= 0) return false;
        double saldo = this.getSaldo(); 
        double valorMulta = this.getSaldo() * (multa / 100.00) * -1;
        this.setSaldo(saldo - valorMulta);
        return true;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

    public void setLimite(int novoLimite) {
        this.limite = novoLimite;
    }

    public int getLimite() {
        return this.limite;
    }

    public void setMulta(double novaMulta) {
        this.multa = novaMulta;
    }

    public double getMulta() {
        return this.multa;
    }
}