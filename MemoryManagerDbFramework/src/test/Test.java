package test;

import java.util.ArrayList;

import execution.Execution;
import memoryManager.MemoryManager;
import request.Request;

public class Test {
    
    private static Integer ID = 1;
    private ArrayList<Execution> executions;
    private ArrayList<Request> requests;
    private ArrayList<MemoryManager> algorithms;
    private Integer id;
    
    public Test(ArrayList<MemoryManager> algorithms, ArrayList<Request> requests) {
        this.algorithms = algorithms;
        this.requests = requests;
        executions = new ArrayList<Execution>();
        id = ID;
        ID += 1;
    }

    public void start() {
        for(MemoryManager algorithm : algorithms) {
            Execution execution = new Execution(requests, algorithm);
            execution.start();
            executions.add(execution);
            algorithm.clear();
        }
    }

    public void summary() {
        System.out.println("----- TEST " + id + " -----");
        System.out.println();

        Integer i = 1;
        for(Request request : requests) {
            System.out.println("Request " + i + ":");
            System.out.println("Type: " + request.getName());
            System.out.println("Quantity: " + request.getQuantity());
            System.out.println("Access: " + request.getRequests());
            System.out.println();
            i++;
        }

        for(Execution execution : executions) {
            System.out.println("Algorithm: " + execution.getAlgorithm().getName());
            System.out.println("Page Misses: " + execution.getPageMisses());
        }
        System.out.println("-------------------");
    }
}
