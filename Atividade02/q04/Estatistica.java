package Atividade02.q04;

public class Estatistica {
    private double[] numeros;

    public Estatistica(double[] numeros) {
        this.numeros = numeros;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }
        return soma / numeros.length;
    }

    public double calcularDesvioPadrao() {
        double media = calcularMedia();
        double somaDosQuadrados = 0;
        for (double numero : numeros) {
            somaDosQuadrados += Math.pow(numero - media, 2);
        }
        double variancia = somaDosQuadrados / numeros.length;
        return Math.sqrt(variancia);
    }
}