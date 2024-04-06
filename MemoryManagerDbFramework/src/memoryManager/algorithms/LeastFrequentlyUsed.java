package memoryManager.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logs.Log;
import memoryManager.MemoryManager;

public class LeastFrequentlyUsed extends MemoryManager {

    private HashMap<Integer, Integer> frequencies;
    
    public LeastFrequentlyUsed(Integer bufferSize, Boolean countFirstAccesses) {
        super("Least Frequently Used (LFU)", bufferSize, countFirstAccesses);

        this.frequencies = new HashMap<Integer, Integer>();
    }

    @Override
    public void lookup(Integer id) {
        Log.show("Id: " + id);

        if(!this.buffer.contains(id)) {
            if(this.countFirstAccesses || (this.buffer.size() == this.bufferSize)) {
                this.pageMisses++;
                Log.show("miss");
            }

            if(this.buffer.size() == this.bufferSize) {
                removeLeastFrequentlyUsed();
            }

            this.buffer.add(id);
            this.frequencies.put(id, 1);
        } else {
            this.frequencies.put(id, this.frequencies.get(id) + 1);
        }

        Log.show(this.buffer);
        Log.show("Frequency: " + this.frequencies);
        Log.show();
    }

    private void removeLeastFrequentlyUsed() {
        if(this.buffer.isEmpty()) {
            return;
        }

        Integer minFrequency = Collections.min(this.frequencies.values());
        List<Integer> leastFrequentlyUsedIds = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry : this.frequencies.entrySet()) {
            if(entry.getValue().equals(minFrequency)) {
                leastFrequentlyUsedIds.add(entry.getKey());
            }
        }

        Integer idToRemove;
        if(leastFrequentlyUsedIds.size() > 1) {
            idToRemove = this.buffer.stream()
                                    .filter(leastFrequentlyUsedIds::contains)
                                    .findFirst()
                                    .orElse(null);
        } else {
            idToRemove = leastFrequentlyUsedIds.get(0);
        }

        if(idToRemove != null) {
            this.buffer.remove(idToRemove);
            this.frequencies.remove(idToRemove);
        }
    }
}
