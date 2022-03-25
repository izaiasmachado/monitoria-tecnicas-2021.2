// Disciplina  : ECO0015 - Técnicas de Programação
// Professor   : Wendley Souza da Silva
// Descrição   : (Classe Carros) Parte 02 - Prática 02 - Java
// Autor(a)    : Izaias Machado Pessoa Neto
// Data atual  : 26/01/2021

package parte02;

public class Carros {
    String marca;
    String modelo;
    int ano;
    int portas;
    double preco;

    public String getMarca () {
        return this.marca;
    }

    public String getModelo () {
        return this.modelo;
    }

    public int getAno () {
        return this.ano;
    }

    public int getPortas () {
        return this.portas;
    }

    public double getPreco () {
        return this.preco;
    }
    
    public void setMarca (String marca) {
        this.marca = marca;
    }
    
    public void setModelo (String modelo) {
        this.modelo = modelo;
    }
    
    public void setAno (int ano) {
        this.ano = ano;
    }
    
    public void setPortas (int portas) {
        this.portas = portas;
    }
    
    public void setPreco (double preco) {
        this.preco = preco;
    }

    public double verDesconto (int desconto) {
        return (desconto > 0) ? (this.preco * ((100.0 - desconto) / 100)) : -1;
    }
}
