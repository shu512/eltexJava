package firstsubtask;

import javax.swing.text.html.parser.Parser;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FirstSubTask {
    private static final int SIZE = 1000000;
    public static void main(String[] args) {
        Set<Integer> testHashSet = new HashSet<>();
        Set<Integer> testTreeSet = new TreeSet<>();
        List<Integer> testArrayList = new ArrayList<>();
        List<Integer> testLinkedList = new LinkedList<>();

        printElapsedTimeAdd(testHashSet);
        printElapsedTimeRemove(testHashSet);

        printElapsedTimeAdd(testTreeSet);
        printElapsedTimeRemove(testTreeSet);

        printElapsedTimeAdd(testArrayList);
        printElapsedTimeRemove(testArrayList);

        printElapsedTimeAdd(testLinkedList);
        printElapsedTimeRemove(testLinkedList);
    }

    private static void printElapsedTimeAdd(Collection<Integer> collection) {
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            collection.add(i);
        }
        long end = System.nanoTime();
        int countMillisSeconds = (int) TimeUnit.NANOSECONDS.toMillis(end - start);
        String className = collection.getClass().getName();

        String str = String.format("%s: elapsedTime method 'add'= %d", className ,countMillisSeconds);
        System.out.println(str);
    }

    private static void printElapsedTimeRemove(Collection<Integer> collection) {
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            collection.remove(i);
        }
        long end = System.nanoTime();
        int countMillisSeconds = (int) TimeUnit.NANOSECONDS.toMillis(end - start);
        String className = collection.getClass().getName();
        String str = String.format("%s: elapsedTime method 'remove'= %d", className ,countMillisSeconds);
        System.out.println(str);
    }
}
