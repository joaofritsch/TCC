package memoryManager.algorithms;

import java.util.HashMap;
import java.util.LinkedList;

import logs.Log;
import memoryManager.MemoryManager;

public class SecondChance extends MemoryManager {

    private LinkedList<Integer> bufferOrder;
    private HashMap<Integer, Boolean> secondChanceFlags;
    
    public SecondChance(Integer bufferSize, Boolean countFirstAccesses) {
        super("Second Chance", bufferSize, countFirstAccesses);

        this.bufferOrder = new LinkedList<Integer>();
        this.secondChanceFlags = new HashMap<Integer, Boolean>();
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
                removeSecondChance();
            }

            this.buffer.add(id);
            this.bufferOrder.addLast(id);
            this.secondChanceFlags.put(id, false);
        } else {
            this.secondChanceFlags.put(id, true);
        }

        Log.show(this.buffer);
        Log.show("Buffer Order: " + this.bufferOrder);
        Log.show("Flags: " + this.secondChanceFlags);
        Log.show();
    }
    
    private void removeSecondChance() {
        while(true) {
            Integer id = this.bufferOrder.peekFirst();

            if(this.secondChanceFlags.get(id)) {
                this.bufferOrder.removeFirst();
                this.bufferOrder.addLast(id);
                this.secondChanceFlags.put(id, false);
            } else {
                this.bufferOrder.removeFirst();
                this.buffer.remove(id);
                this.secondChanceFlags.remove(id);
                break;
            }
        }
    }
}
