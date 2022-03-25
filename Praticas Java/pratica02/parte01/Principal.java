// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Principal) Parte 01 - Prática 02 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 26/01/2021

package parte01;

import java.util.Scanner;

public class Principal {
    public static void main (String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Scanner read = new Scanner(System.in);
        String text = "", message = "";
        
        System.out.print("Digite a posição final da sequencia: ");
        
        int position = read.nextInt();
        double[] values = fibonacci.getSequenceUntil(position);

        for (int i = 0; i < values.length; i++) {
            String spacing = (i == (values.length - 1)) ? "\n" : " ";
            text += values[i] + spacing;
        }
        
        String quantifier = (values.length > 1) ? "são" : "é";

        message = (position >= 1) ? 
            "Os elementos até a posição " + position + " " + quantifier + ": " + text :
            "[ERROR] Digite um elemento (inteiro entre 1 e 90)";

        System.out.println(message);
    }
}
