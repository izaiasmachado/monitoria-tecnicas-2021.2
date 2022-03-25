// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : Parte 01 - Prática 04 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 08/02/2021

package parte01;

public class Matematica {
    public static void main(String[] args) {
        int num = 81;
        double x = Math.sqrt(num);

        System.out.println("A raíz quadrada de " + num + " é " + x);
        System.out.println("Valor absoluto: " + Math.abs(-81.4));
        System.out.println("Seno: " + Math.sin(90.0));
        System.out.println("Seno: " + Math.sin(Math.toRadians(90)));
        System.out.println("Max: " + Math.max(85, 20));

        String nome = "Fulano";
        String frase = "Meu nome é";
        String completa = frase + nome;
    }
}