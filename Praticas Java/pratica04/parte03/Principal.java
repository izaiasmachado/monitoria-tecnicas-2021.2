// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Principal) Parte 03 - Prática 04 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 08/02/2021

package parte03;

public class Principal {
    public static void main (String[] args) {
        Matematica math = new Matematica();
        
        int v = -81;
        int abs = math.absolute(v);

        System.out.println("Valor original: " + v);
        System.out.println("Valor absoluto: " + abs);


        int a = 3;
        int b = 9;
        int minimum = math.min(a, b);

        System.out.println("Entre " + a + " e " + b + ", " + minimum + " é o menor!");
    }
}
