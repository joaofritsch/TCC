package factories;

import java.util.ArrayList;

import memoryManager.MemoryManager;
import memoryManager.algorithms.FirstInFirstOut;
import memoryManager.algorithms.LeastRecentlyUsed;

public class AlgorithmFactory {

    private Integer bufferSize;
    
    public AlgorithmFactory(Integer bufferSize) {
        this.bufferSize = bufferSize;
    }

    public ArrayList<MemoryManager> generate() {
        return new ArrayList<MemoryManager>() {{
            add(new FirstInFirstOut(bufferSize));
            add(new LeastRecentlyUsed(bufferSize));
        }};
    }
}