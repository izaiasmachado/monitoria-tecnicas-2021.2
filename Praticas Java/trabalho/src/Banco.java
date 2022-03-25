// Disciplina      : ECO0015 - Técnicas de Programação
// Professor       : Wendley Souza da Silva
// Descrição       : (Classe Banco) - Trabalho - Java
// Autor(a)        : Izaias Machado Pessoa Neto
// Data de Entrega : 12/03/2021

package trabalho;

/**
 * Essa classe foi devido ao método transferir, que não poderia ser implementado dentro de Contas, como foi especificado
 * no roteiro.
 */

public class Banco {
    /**
     * Essa função basicamente faz a busca de uma conta com um número específico. Se não for achada, 
     * retorna uma conta vazia.
     */
    public Contas getContaByNumero(int numero) {
        Contas contas[] = Principal.contas;
        
        for (Contas conta : contas) {
            if (conta.getNumero() == numero) return conta;
        }

        return new Contas();
    }   

    public boolean transferir(Contas remetente, Contas destinatario, double valor) {
        boolean resultadoSaque = remetente.sacar(valor);
        if (resultadoSaque == false) return false;

        destinatario.depositar(valor);
        return true;
    }
}