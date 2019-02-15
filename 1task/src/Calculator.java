class Calculator {

    public String operation(int a, int b, String sign) {
        switch (sign) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                return String.valueOf(a / b);
            default:
                return "Error";
        }
    }
}
