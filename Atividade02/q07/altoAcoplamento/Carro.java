package Atividade02.q07.altoAcoplamento;

public class Carro {
    private String marca;
    private String modelo;

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void ligar() {
        System.out.println("O carro " + marca + " " + modelo + " está ligado.");
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
