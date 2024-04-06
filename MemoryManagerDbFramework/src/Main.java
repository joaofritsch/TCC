import comparator.Comparator;

public class Main {

    private static final Integer BUFFER_SIZE = 3;
    private static final Boolean COUNT_FIRST_ACCESS = true;

    public static void main(String[] args) {
        Comparator comparator = new Comparator(BUFFER_SIZE, COUNT_FIRST_ACCESS);
        comparator.start();
        comparator.summary();
    }
}
