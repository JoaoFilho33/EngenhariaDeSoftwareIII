package Atividade02.q03;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private Conta conta;

    public Cliente(int id, String nome, String endereco, Conta conta) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.conta = conta;
    }

    public void exibirInformacoes() {
    }

    public void realizarCompra(Compra compra) {
    }
}
