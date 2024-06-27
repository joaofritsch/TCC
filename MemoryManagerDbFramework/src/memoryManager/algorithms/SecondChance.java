package memoryManager.algorithms;

import java.util.HashMap;
import java.util.LinkedList;

import logs.Log;
import memoryManager.MemoryManager;

public class SecondChance extends MemoryManager {

    private LinkedList<Integer> bufferOrder;
    private HashMap<Integer, Boolean> secondChanceFlags;
    
    public SecondChance(Integer bufferSize) {
        super("Second Chance", bufferSize);
        bufferOrder = new LinkedList<Integer>();
        secondChanceFlags = new HashMap<Integer, Boolean>();
    }
    
    @Override
    protected void remove() {
        while(true) {
            Integer id = bufferOrder.peekFirst();

            if(secondChanceFlags.get(id)) {
                bufferOrder.removeFirst();
                bufferOrder.addLast(id);
                secondChanceFlags.put(id, false);
            } else {
                bufferOrder.removeFirst();
                buffer.remove(id);
                secondChanceFlags.remove(id);
                break;
            }
        }
    }

    @Override
    protected void add(Integer id) {
        buffer.add(id);
        bufferOrder.addLast(id);
        secondChanceFlags.put(id, false);
    }

    @Override
    protected void reorder(Integer id) {
        secondChanceFlags.put(id, true);
    }

    @Override
    protected void show() {
        Log.show(buffer);
        Log.show("Buffer Order: " + bufferOrder);
        Log.show("Flags: " + secondChanceFlags);
        Log.show();
    }
}
