// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : Parte 02 - Prática 05 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 22/02/2021

package parte02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    /**
     * Esse programa tem três funções, sendo uma principal e duas para escrita e leitura de arquivo.
     */
    public static void main(String args[]) throws IOException {
        String path = "Arquivo.txt";
        write(path);
        read(path);
    }

    /**
     * A função write é a função de escrita. Ela instancia a classe BufferedWriter passando por parâmetro
     * outra classe chamada FileWriter, com o caminho do arquivo também por parâmetro. Após isso temos a 
     * classe Scanner que é chamada para receber informações pelo console.
     * 
     * É pedido para escrever algo, após isto é gravado no arquivo e finalizado os processos das classes instanciadas.
     */
    public static void write(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String row = "";
        Scanner in = new Scanner(System.in);

        System.out.println("Escreva algo: ");
        row = in.nextLine();
        buffWrite.append(row + "\n");
        
        in.close();
        buffWrite.close();
    }

    /**
     * Agora, na função read de leitura é instanciada a classe BufferedReader passando por parâmetro
     * uma instância da classe FileReader, com o caminho do arquivo também por parâmetro.
     * 
     * Então, em um loop são lidas todas as linhas até que se encontre uma linha inválida, ou seja,
     * o fim do arquivo.
     * 
     * Por fim, é finalizado os processos das classes.
     */
    public static void read(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String row = "";

        while (true) {
            if (row != null) {
                System.out.println(row);
            } else break;
            
            row = buffRead.readLine();
        }

        buffRead.close();
    }
}