package memoryManager.algorithms;

import java.util.ArrayList;
import java.util.HashSet;

import logs.Log;
import memoryManager.MemoryManager;

public class Optimal extends MemoryManager {
    
    private ArrayList<Integer> futureAccesses;
    
    public Optimal(Integer bufferSize) {
        super("Optimal", bufferSize);
    }

    public void setFutureAccesses(ArrayList<Integer> futureAccesses) {
        futureAccesses = new ArrayList<>(futureAccesses);
        getNext();
    }

    private void getNext() {
        if(!futureAccesses.isEmpty()) futureAccesses.remove(0);
    }
    
    @Override
    protected void remove() {
        var futureSet = new HashSet<Integer>(futureAccesses);
        Integer pageToRemove = null;
        
        for(Integer page : buffer) {
            if(!futureSet.contains(page)) {
                pageToRemove = page;
                break;
            }
        }
        
        if(pageToRemove == null) {
            int lastUsedIndex = -1;

            for(Integer page : buffer) {
                int index = futureAccesses.indexOf(page);

                if(index > lastUsedIndex) {
                    lastUsedIndex = index;
                    pageToRemove = page;
                }
            }
        }

        if(pageToRemove != null) buffer.remove(pageToRemove);
    }

    @Override
    protected void add(Integer id) {
        buffer.add(id);
        getNext();
    }

    @Override
    protected void reorder(Integer id) {
        getNext();
    }

    @Override
    protected void show() {
        Log.show(buffer);
        Log.show();
    }
}
