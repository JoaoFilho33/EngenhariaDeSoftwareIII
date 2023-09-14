package Atividade02.q04;

import java.util.Random;
import java.util.Arrays;

public class Ordenacao {

    public void ordenar(int[] vetor) {
        Arrays.sort(vetor);
    }

    public void embaralhar(int[] vetor) {
        Random random = new Random();

        for (int i = vetor.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); //gerar um indice aletório

            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
        }
    }
}