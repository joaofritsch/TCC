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

    public Comparator(Integer bufferSize, Boolean countFirstAccess) {
        this.bufferSize = bufferSize;
        this.algorithms = new AlgorithmFactory(bufferSize, countFirstAccess).generate();
        this.tests = new TestFactory(this.algorithms).generate();
    }

    public void start() {
        for(Test test : this.tests) {
            test.start();
        }
    }

    public void summary() {
        System.out.println("------------------------------ RESULTS ------------------------------");
        System.out.println("---------- GENERAL INFORMATION ----------");
        System.out.println("Buffer Size: " + this.bufferSize);
        System.out.println();

        System.out.println("Tested Algorithms: ");
        for(MemoryManager algorithm : this.algorithms) {
            System.out.println(algorithm.getName());
        }

        System.out.println("-----------------------------------------");
        System.out.println();

        for(Test test : this.tests) {
            test.summary();
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
