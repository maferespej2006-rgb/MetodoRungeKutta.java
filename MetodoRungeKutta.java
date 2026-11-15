public class MetodoRungeKutta {
    
    // Función derivada: f(x, y) = x + y
    public static double evaluarFuncion(double x, double y) {
        return x + y;
    }

    // Solución analítica exacta para comparar
    public static double solucionExacta(double x) {
        return -x - 1 + 2 * Math.exp(x);
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        double xFinal = 0.3;

        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("===== MÉTODO RUNGE-KUTTA 4TO ORDEN =====");
        System.out.println("Tamaño de paso h = " + h);
        System.out.println("n\t x_n\t y_RK4\t\t y_Exacta\t Error Absoluto");
        System.out.println("--------------------------------------------------------");

        // Valor inicial
        double yEx = solucionExacta(x);
        double error = Math.abs(yEx - y);
        System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.8f\n", 0, x, y, yEx, error);

        // Ciclo de cálculo
        for (int i = 0; i < nPasos; i++) {
            // Cálculo de las 4 pendientes
            double k1 = evaluarFuncion(x, y);
            double k2 = evaluarFuncion(x + h/2, y + (h/2)*k1);
            double k3 = evaluarFuncion(x + h/2, y + (h/2)*k2);
            double k4 = evaluarFuncion(x + h,   y + h*k3);

            // Actualización de y
            y = y + (h/6) * (k1 + 2*k2 + 2*k3 + k4);
            x = x + h;

            yEx = solucionExacta(x);
            error = Math.abs(yEx - y);
            System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.8f\n",
                              i + 1, x, y, yEx, error);
        }
    }
}
