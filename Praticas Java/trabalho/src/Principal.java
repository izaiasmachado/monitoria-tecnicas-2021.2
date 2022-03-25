// Disciplina      : ECO0015 - Técnicas de Programação
// Professor       : Wendley Souza da Silva
// Descrição       : (Classe Principal) - Trabalho - Java
// Autor(a)        : Izaias Machado Pessoa Neto
// Data de Entrega : 12/03/2021

package trabalho;

/**
 * Primeiro instanciamos as três diferentes contas. Como estamos estendendo as subclasses ContaPoupanca e ContaEspecial
 * utilizando herança, podemos trabalhar elas como uma classe Contas. Portanto, instanciamos um array de Contas,
 * para podemos buscar as contas em ums estrutura de dados unificada.
 * 
 * Ex: Se quisermos realizar o saque, basta realizar uma busca na estrutura contas a partir do número da conta. Se
 * chamarmos o método saque na função ContaEspecial ela deve sobrepor o método saque original de Contas. 
 * 
 * Além disso, se for necessário mostrar uma mensagem específica, mesmo chamando como Contas, 
 * existe um método tipoConta que retorna para qualquer extensão da classe Contas o tipo da conta, 
 * seja Poupança ou Especial e assim podemos ter alguma diferença gráfica ou de lógica.
 * 
 * Ideia de arquitetura, a ideia principal é deixar a classe Principal de fácil compreensão, mostrando apenas os passos
 * requisitados, sem qualquer validação específica. As regras de negócio estão todas dentro das classes das contas e do banco.
 * A classe Telas cuida apenas da interface gráfica e validação do input do usuário.
 */

public class Principal {
    public static Contas contaComum = new Contas();
    public static ContaPoupanca contaPoupanca = new ContaPoupanca();
    public static ContaEspecial contaEspecial = new ContaEspecial();
    public static Contas contas[] = { contaComum, contaPoupanca, contaEspecial };
    
    public static void main(String args[]) {
        Telas telas = new Telas();
        telas.mostrarMensagemDeBoasVindas();
        telas.pergutarInformacoes(contaComum);
        telas.pergutarInformacoes(contaPoupanca);
        telas.pergutarInformacoes(contaEspecial);
        telas.mostrarMenu();
    }
}