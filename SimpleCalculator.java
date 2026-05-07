package lab_7;

import java.util.Scanner;

class AddZeroException extends Exception {
    public AddZeroException() {
        super("AddZeroException");
    }
}

class SubtractZeroException extends Exception {
    public SubtractZeroException() {
        super("SubtractZeroException");
    }
}

class OutOfRangeException extends Exception {
    public OutOfRangeException() {
        super("OutOfRangeException");
    }
}

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            int result = calculate(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    public static int calculate(String input)
            throws AddZeroException, SubtractZeroException, OutOfRangeException {

        char operator;

        if (input.contains("+")) {
            operator = '+';
        } else {
            operator = '-';
        }

        String[] parts = input.split("[+-]");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        if (operator == '+' && (num1 == 0 || num2 == 0)) {
            throw new AddZeroException();
        }

        if (operator == '-' && (num1 == 0 || num2 == 0)) {
            throw new SubtractZeroException();
        }

        if (num1 < 0 || num1 > 1000 || num2 < 0 || num2 > 1000) {
            throw new OutOfRangeException();
        }

        int result;

        if (operator == '+') {
            result = num1 + num2;
        } else {
            result = num1 - num2;
        }

        if (result < 0 || result > 1000) {
            throw new OutOfRangeException();
        }

        return result;
    }
}