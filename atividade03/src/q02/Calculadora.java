package q02;

import java.util.List;
import java.util.ArrayList;

public class Calculadora {
    private final double a;
    private final double b;

    public Calculadora(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public List<Double> calcular(List<Operacao> operacoes) {
        List<Double> resultados = new ArrayList<>();
        for (Operacao operacao : operacoes) {
            double resultado = operacao.executar(this.a, this.b);
            resultados.add(resultado);
        }
        return resultados;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(10, 5);
        List<Operacao> operacoes = new ArrayList<>();
        operacoes.add(new Soma());
        operacoes.add(new Subtracao());
        operacoes.add(new Multiplicacao());

        List<Double> resultados = calculadora.calcular(operacoes);
        System.out.println("Resultados: " + resultados);
    }
}
