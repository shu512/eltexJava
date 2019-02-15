import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int a = 0;
        int b = 0;
        String sign;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number");
        if (in.hasNextInt()) {
            a = in.nextInt();
        }
        System.out.println("Enter operation(+, -, * or /)");
        sign = in.next();
        System.out.println("Enter number");
        if (in.hasNextInt()) {
            b = in.nextInt();
        }
        System.out.print(a + sign + b + " = ");
        System.out.println(calc.operation(a, b, sign));
    }
}
