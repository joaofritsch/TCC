package execution;

import java.util.ArrayList;

import memoryManager.MemoryManager;
import request.Request;

public class Execution {

    private ArrayList<Request> requests;
    private MemoryManager memoryManager;

    public Execution(ArrayList<Request> requests, MemoryManager memoryManager) {
        this.requests = requests;
        this.memoryManager = memoryManager;
    }

    public void start() {
        for(Request request : this.requests) {
            while(!request.hasFinished()) {
                Integer id = request.getNext();
    
                this.memoryManager.lookup(id);
            }
        }
    }

    public void summary() {
        System.out.println("----- SUMMARY -----");
        System.out.println();
        System.out.println("Algorithm: " + memoryManager.getName());
        System.out.println("Buffer Size: " + memoryManager.getBufferSize());
        System.out.println("Page Misses: " + memoryManager.getPageMisses());
        System.out.println();
        System.out.println("Requests");

        Integer i = 1;
        for(Request request : this.requests) {
            System.out.println("R" + i + ":");
            System.out.println("Type: " + request.getName());
            System.out.println("Quantity: " + request.getQuantity());
            System.out.println("Requests: " + request.getRequests());
            System.out.println();
            i++;
        }
    }
}
