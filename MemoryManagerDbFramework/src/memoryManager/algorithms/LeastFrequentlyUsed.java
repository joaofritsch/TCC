package memoryManager.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import logs.Log;
import memoryManager.MemoryManager;

public class LeastFrequentlyUsed extends MemoryManager {

    private HashMap<Integer, Integer> frequencies;
    
    public LeastFrequentlyUsed(Integer bufferSize) {
        super("Least Frequently Used (LFU)", bufferSize);
        frequencies = new HashMap<Integer, Integer>();
    }

    @Override
    protected void remove() {
        if(buffer.isEmpty()) return;

        var leastFrequentlyUsedIds = new ArrayList<Integer>();
        Integer idToRemove;
        if(leastFrequentlyUsedIds.size() > 1) idToRemove = buffer.stream().filter(leastFrequentlyUsedIds::contains).findFirst().orElse(null);
        else idToRemove = leastFrequentlyUsedIds.get(0);

        if(idToRemove != null) {
            buffer.remove(idToRemove);
            frequencies.remove(idToRemove);
        }
    }

    @Override
    protected void add(Integer id) {
        buffer.add(id);
        frequencies.put(id, 1);
    }

    @Override
    protected void reorder(Integer id) {
        frequencies.put(id, frequencies.get(id) + 1);
    }

    @Override
    protected void show() {
        Log.show(buffer);
        Log.show("Frequency: " + frequencies);
        Log.show();
    }
}
