package Input;

import java.util.Scanner;

import Functions.*;

public class Input {

    Functions selectedFunction;
    Scanner scanner = new Scanner(System.in);
    double accuracy;
    double startPoint;
    double endPoint;
    boolean changeOfSign = false;

    public Functions getSelectedFunction() {
        return selectedFunction;
    }

    public boolean isChangeOfSign() {
        return changeOfSign;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getStartPoint() {
        return startPoint;
    }

    public double getEndPoint() {
        return endPoint;
    }

    public void input() {
        int choice = 0;
        while (choice < 1 || choice > 4) {
            System.out.println("Выберете функцию, для которой хотели бы вычислить интеграл:\n1 - y = x^2\n2 - y = sin(x)\n3 - y = cos(x) \n4 - y = 5^(x)");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception ignored) {

            }
        }

        switch (choice) {
            case 1:
                selectedFunction = new PolynomialFunction();
                break;
            case 2:
                selectedFunction = new SinFunction();
                break;
            case 3:
                selectedFunction = new CosFunction();
                break;
            case 4:
                selectedFunction = new PowerFunction();
                break;
        }

        readPoints();
        readAccurancy();
    }


    private void readPoints() {
        boolean unsuccesful = true;

        while (unsuccesful) {
            System.out.println("Введите нижний предел интегрирования");
            try {
                startPoint = Double.parseDouble(scanner.nextLine());
                unsuccesful = false;
            } catch (Exception ignored) {
            }
        }

        unsuccesful = true;


        while (unsuccesful) {
            System.out.println("Введите верхний предел интегрирования");
            try {
                endPoint = Double.parseDouble(scanner.nextLine());
                unsuccesful = false;

            } catch (Exception ignored) {
            }
        }

        if (endPoint < startPoint) {
            changeOfSign = true;
            double tmp = endPoint;
            endPoint = startPoint;
            startPoint = tmp;
        }
    }

    private void readAccurancy() {
        boolean unsuccesful = true;
        while (unsuccesful) {

            System.out.println("Введите точность,с которой хотите вычислить интеграл");
            try {
                accuracy = Double.parseDouble(scanner.nextLine());
                unsuccesful = false;
            } catch (Exception ignored) {
                System.out.println("Неверный ввод!")
            }
        }


    }

}



