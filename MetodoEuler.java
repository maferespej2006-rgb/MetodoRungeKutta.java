public class MetodoEuler {
    
    // Función derivada: f(x, y) = x - y
    public static double evaluarFuncion(double x, double y) {
        return x - y;
    }

    // Solución analítica exacta para comparar
    public static double solucionExacta(double x) {
        return x - 1 + 2 * Math.exp(-x);
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;           // Cambia aquí: 0.1, 0.05, 0.01
        double xFinal = 0.3;

        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("===== MÉTODO DE EULER =====");
        System.out.println("Tamaño de paso h = " + h);
        System.out.println("n\t x_n\t y_Euler\t y_Exacta\t Error Absoluto");
        System.out.println("--------------------------------------------------------");

        // Valor inicial
        double yEx = solucionExacta(x);
        double error = Math.abs(yEx - y);
        System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n", 0, x, y, yEx, error);

        // Ciclo de cálculo
        for (int i = 0; i < nPasos; i++) {
            double pendiente = evaluarFuncion(x, y);
            y = y + h * pendiente;   // Actualiza y
            x = x + h;               // Avance en x

            yEx = solucionExacta(x);
            error = Math.abs(yEx - y);
            System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n",
                              i + 1, x, y, yEx, error);
        }
    }
}
