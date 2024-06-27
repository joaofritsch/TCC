package comparator;

import java.util.ArrayList;

import factories.AlgorithmFactory;
import factories.TestFactory;
import memoryManager.MemoryManager;
import test.Test;

public class Comparator {
    
    private ArrayList<MemoryManager> algorithms;
    private ArrayList<Test> tests;
    private Integer bufferSize;

    public Comparator(Integer bufferSize) {
        this.bufferSize = bufferSize;
        algorithms = new AlgorithmFactory(bufferSize).generate();
        tests = new TestFactory(algorithms).generate();
    }

    public void start() {
        for(Test test : tests) test.start();
    }

    public void summary() {
        System.out.println("------------------------------ RESULTS ------------------------------");
        System.out.println("---------- GENERAL INFORMATION ----------");
        System.out.println("Buffer Size: " + bufferSize);
        System.out.println();
        System.out.println("Tested Algorithms: ");
        for(MemoryManager algorithm : algorithms) System.out.println(algorithm.getName());
        System.out.println("-----------------------------------------");
        System.out.println();
        for(Test test : tests) test.summary();
        System.out.println("-----------------------------------------------------------------------");
    }
}
