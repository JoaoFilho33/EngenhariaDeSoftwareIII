package Atividade02.q07.altoAcoplamento;

public class Motorista {
    private String nome;

    public Motorista(String nome) {
        this.nome = nome;
    }

    public void dirigir(Carro carro) {
        System.out.println(nome + " está dirigindo o carro " + carro.getMarca() + " " + carro.getModelo() + ".");
    }
}
