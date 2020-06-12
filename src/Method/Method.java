package Method;

import Functions.*;

public class Method {
    double integral;
    double nextIntegral;
    double inaccuracy;

    public double calculate(double startPoint, double endPoint, double accuracy, Functions func) {
        int n = 1;
        integral = solve(startPoint, endPoint, func, n);
        do {
            n *= 2;
            nextIntegral = solve(startPoint, endPoint, func, n);
            inaccuracy = (Math.abs(nextIntegral - integral))/3;
            integral = nextIntegral;
        }

        while (accuracy < inaccuracy);

        System.out.println("Кол-во разбиений: " + n);
        System.out.println("Полученная погрешность: " + inaccuracy);

        return nextIntegral;
    }

    public double solve(double startPoint, double endPoint, Functions func, int n) {
        double h = ((endPoint - startPoint) / n);
        double i = 1;
        double x = startPoint;
        double solution = h * (func.solve(startPoint) + func.solve(endPoint)) / 2;
        while (i < n) {
            x += h;
            solution += h * func.solve(x);
            i++;
        }
        return solution;
    }

}
