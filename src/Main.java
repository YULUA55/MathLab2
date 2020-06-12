import java.lang.Math.*;

import Input.*;
import Method.*;

public class Main {

    public static void main(String[] args) {

        Input input = new Input();
        input.input();
        Method method = new Method();
        Double solution = method.calculate(input.getStartPoint(), input.getEndPoint(), input.getAccuracy(), input.getSelectedFunction());
        if (input.isChangeOfSign())
            System.out.println("Ответ: -" + solution);
        else System.out.println("Ответ: " + solution);

    }

}
