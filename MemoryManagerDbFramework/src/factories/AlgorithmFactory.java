package factories;

import java.util.ArrayList;

import memoryManager.MemoryManager;
import memoryManager.algorithms.FirstInFirstOut;
import memoryManager.algorithms.LeastRecentlyUsed;

public class AlgorithmFactory {

    private Integer bufferSize;
    private Boolean countFirstAccess;
    
    public AlgorithmFactory(Integer bufferSize, Boolean countFirstAccess) {
        this.bufferSize = bufferSize;
        this.countFirstAccess = countFirstAccess;
    }

    public ArrayList<MemoryManager> generate() {
        ArrayList<MemoryManager> algorithms = new ArrayList<MemoryManager>();

        algorithms.add(new LeastRecentlyUsed(bufferSize, countFirstAccess));
        algorithms.add(new FirstInFirstOut(bufferSize, countFirstAccess));

        return algorithms;
    }
}
