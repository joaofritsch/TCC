package logs;

public class Log {
    
    public static final Boolean LOG_SHOW_EXECUTION = true;

    public static void show(Object message) {
        if(LOG_SHOW_EXECUTION) {
            System.out.println(message);
        }
    }

    public static void show() {
        if(LOG_SHOW_EXECUTION) {
            System.out.println();
        }
    }
}
