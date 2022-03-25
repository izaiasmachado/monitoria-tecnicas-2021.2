// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Fibonacci) Parte 01 - Prática 02 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 26/01/2021

package parte01;

public class Fibonacci {
    public static double[] getSequenceUntil (int position) {
        double values[] = new double[position]; 
        
        for (int i = 0; i < position; i++) {
            values[i] = (i == 0 || i == 1) ? 1 :  values[i - 1] + values[i - 2];
        }

        return values;
    }
}
