package factories;

import java.util.ArrayList;

import memoryManager.MemoryManager;
import memoryManager.algorithms.FirstInFirstOut;
import memoryManager.algorithms.LeastFrequentlyUsed;
import memoryManager.algorithms.LeastRecentlyUsed;
import memoryManager.algorithms.SecondChance;

public class AlgorithmFactory {

    private Integer bufferSize;
    private Boolean countFirstAccess;
    
    public AlgorithmFactory(Integer bufferSize, Boolean countFirstAccess) {
        this.bufferSize = bufferSize;
        this.countFirstAccess = countFirstAccess;
    }

    public ArrayList<MemoryManager> generate() {
        ArrayList<MemoryManager> algorithms = new ArrayList<MemoryManager>();

        // algorithms.add(new LeastRecentlyUsed(bufferSize, countFirstAccess));
        // algorithms.add(new FirstInFirstOut(bufferSize, countFirstAccess));
        // algorithms.add(new LeastFrequentlyUsed(bufferSize, countFirstAccess));
        algorithms.add(new SecondChance(bufferSize, countFirstAccess));

        return algorithms;
    }
}
