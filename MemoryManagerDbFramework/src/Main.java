import comparator.Comparator;

public class Main {

    private static final Integer BUFFER_SIZE = 3;

    public static void main(String[] args) {
        Comparator comparator = new Comparator(BUFFER_SIZE);
        comparator.start();
        comparator.summary();
    }
}
