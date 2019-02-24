package secondsubtask;

public class SecondSubTask {
    public static void main(String[] args) {
        //System.out.println(factorial(1 << 15)); //StackOverflowError, fix: "-Xss4m" in VM options
        heapDown(); //OutOfMemoryError, fix: "-Xmx1g"
    }

    private static void heapDown() {
        ObjectMrBigSize objectMrBigSize = new ObjectMrBigSize();
    }

    private static long factorial(int n) {
        return n < 2 ? 1: n * factorial(n - 1);
    }
}
