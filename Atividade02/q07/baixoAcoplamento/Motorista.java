package Atividade02.q07.baixoAcoplamento;

public class Motorista {
    private String nome;

    public Motorista(String nome) {
        this.nome = nome;
    }

    public void dirigir(Veiculo veiculo) {
        System.out.println(nome + " está dirigindo um " + veiculo.getTipo() + " " + veiculo.getMarca() + " " + veiculo.getModelo() + ".");
    }
}
