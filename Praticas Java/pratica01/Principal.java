// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Principal) Prática 01 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 18/01/2021

package pratica01;

public class Principal {
    public static void main (String[] args) {
        Contas c1 = new Contas();
        Contas c2 = new Contas();

        c1.numero = 100;
        c1.nome = "Fulano 1";

        c1.depositar(100);
        
        System.out.println("Numero: " + c1.numero);
        System.out.println("Nome: " + c1.nome);
        System.out.println("Saldo: " + c1.saldo);

        System.out.println("========================================");

        c2.numero = 150;
        c2.nome = "Fulano 2";
        c2.saldo = 500;

        System.out.println("Numero: " + c2.getNumero());
        System.out.println("Nome: " + c2.getNome());
        System.out.println("Saldo inicial: " + c2.getSaldo());

        c2.depositar(200);
        System.out.println("Saldo após depósito: " + c2.getSaldo());
        
        boolean saqueFoiProcessado = c2.sacar(100);
        String mensagemDeSaque = (saqueFoiProcessado) ? 
            "Saldo após saque: " + c2.getSaldo() : 
            "[ERRO]: Sem fundos suficientes para saque";
        
        System.out.println(mensagemDeSaque); 
    }
}
