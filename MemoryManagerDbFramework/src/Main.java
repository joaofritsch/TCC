import java.util.ArrayList;

import execution.Execution;
import memoryManager.algorithms.LeastRecentlyUsed;
import request.RandomRequest;
import request.Request;
import request.SequentialRequest;

public class Main {
    
    static void testSequentialAccess() {
        SequentialRequest s = new SequentialRequest(1000, 1, 7);

        ArrayList<Request> requests = new ArrayList<Request>();
        requests.add(s);

        LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed(4, false);

        Execution e = new Execution(requests, leastRecentlyUsed);     
        
        e.start();
        e.summary();
    }

    static void testRandomAccess() {
        RandomRequest r = new RandomRequest(1000, 1, 25);
        
        ArrayList<Request> requests = new ArrayList<Request>();
        requests.add(r);

        LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed(10, false);

        Execution e = new Execution(requests, leastRecentlyUsed);     
        
        e.start();
        e.summary();
    }

    static void testCustomAccess() {
        SequentialRequest s = new SequentialRequest(1000, 1, 7);
        RandomRequest r = new RandomRequest(1000, 1, 25);
        
        ArrayList<Request> requests = new ArrayList<Request>();
        requests.add(s);
        requests.add(r);

        LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed(10, false);

        Execution e = new Execution(requests, leastRecentlyUsed);     
        
        e.start();
        e.summary();
    }

    public static void main(String[] args) {
        testSequentialAccess();
        // testRandomAccess();
        // testCustomAccess();
    }
}
