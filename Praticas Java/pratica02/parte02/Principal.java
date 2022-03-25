// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Principal) Parte 02 - Prática 02 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 26/01/2021

package parte02;

import java.util.Scanner;

public class Principal {
    public static void main (String[] args) {
        String text = "";
        Carros obj1 = new Carros();
        Carros obj2 = new Carros();

        System.out.println("Digite informações do veículo 1: ");
        scanCarro(obj1);

        System.out.println("Digite informações do veículo 2: ");
        scanCarro(obj2);

        System.out.println("Essas são as informações gravadas do veículo 1: ");
        printCarro(obj1);

        System.out.println("Essas são as informações gravadas do veículo 2: ");
        printCarro(obj2);

        askAndPrintDiscount(obj1);

        askAndPrintDiscount(obj2);
    }

    public static void printCarro (Carros carro) {
        String text = "";
        text += "Marca: " + carro.getMarca() + "\n";
        text += "Modelo: " + carro.getModelo() + "\n";
        text += "Ano de Fabricação: " + carro.getAno() + "\n";
        text += "Quantidade de portas: " + carro.getPortas() + "\n";
        text += "Preço: " + carro.getPreco() + "\n";
        System.out.println(text);
    }

    public static void scanCarro (Carros carro) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a marca: ");
        carro.setMarca(input.next());

        System.out.print("Digite o modelo: ");
        carro.setModelo(input.next());

        System.out.print("Digite o ano de fabricação: ");
        carro.setAno(input.nextInt());

        System.out.print("Digite a quantidade de portas: ");
        carro.setPortas(input.nextInt());

        System.out.print("Digite o preço: ");
        carro.setPreco(Double.parseDouble(input.next()));

        System.out.println("");
    }

    public static void askAndPrintDiscount (Carros carro) {
        Scanner input = new Scanner(System.in);
        String text = "";

        text += "Digite a porcentagem de desconto qua você deseja ";
        text += "para o veículo de marca: " + carro.getMarca() + " ";
        text += "e modelo: " + carro.getModelo() + "\n";
        text += "Desconto (Inteiro de 0 a 100): ";
        System.out.print(text);

        double priceAfterDiscount = carro.verDesconto(input.nextInt());

        System.out.println("O preço após o deconto é de " + priceAfterDiscount + " reais.\n");
    }
}
