// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : Parte 02 - Prática 04 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 08/02/2021

public class Principal {
    public static void main (String[] args) {
        for (int i = 0; i < 200; i++) {
            int lower = 5;
            int upper = 102;
            int number = getRandomInt(lower, upper);
            System.out.println(number);
        }
    } 
    
    public static int getRandomInt (int lower, int upper ) {
        /** Apenas uma definição simples de limite inferior (Lower Bound)
         *  e limite superior (Upper Bound).
         * 
         * Como o valor da função random nunca chega a 1, definimos uma
         * amplitude suficiente para que possamos encontrar o valor 102. 
         *  */
        double generatedNumber = Math.random() * (upper - lower + 1) + lower;
        int parsedGeneratedNumber = (int) (Math.floor(generatedNumber));

        return parsedGeneratedNumber;
    }
}
