package Atividade02.q05.coesaoCoincidental;

public class ModuleWithLowCohesion {
    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public void sortIntArray(int[] array) {
        // Lógica de ordenação
    }

    public String intToString(int number) {
        return String.valueOf(number);
    }

        public boolean validateEmail(String email) {
        // Lógica de validação
        return true;
    }
}
