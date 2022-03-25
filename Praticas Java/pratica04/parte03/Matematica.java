// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Matematica) Parte 03 - Prática 04 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 08/02/2021

package parte03;

public class Matematica {
    public static int absolute (int value) {
        return (value < 0) ? -value : value;
    }

    public static int min (int a, int b) {
        return (a < b) ? a : b;
    }
}