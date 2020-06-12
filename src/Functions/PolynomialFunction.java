package Functions;

import java.lang.Math;

public class PolynomialFunction extends Functions {

    double returnedValue;

    public double solve(double x) {

        returnedValue = Math.pow(x, 2);

        return returnedValue;

    }
}
