// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : Parte 01 - Prática 05 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 22/02/2021

package parte01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);
        int number;

        System.out.printf("Informe o número para a tabuada:\n");
        number = read.nextInt();

        String filename = "Tabuada.txt";
        FileWriter file = new FileWriter(filename, true); // Salva no local de execução

        /**
         * O parâmetro true após o nome do arquivo na função construtura da classe
         * FileWrite é chamada de append e tem valor boleano. Como o próprio nome do
         * parâmetro diz, ele define se o FileWriter deve sobrescrever (caso não) ou
         * acrescentar as novas informações ao fim do arquivo (caso sim).
         */

        PrintWriter saveFile = new PrintWriter(file);
        saveFile.printf("+--Resultado--+%n");

        for (int iterator = 1; iterator <= 10; iterator++) {
            saveFile.printf("| %2d X %d = %2d |%n", iterator, number, (iterator * number));
        }

        saveFile.printf("+-------------+%n");
        file.close();
        read.close();

        System.out.printf("\nTabuada do %d foi gravada com sucesso, com nome de %s\n", number, filename);
    }
}