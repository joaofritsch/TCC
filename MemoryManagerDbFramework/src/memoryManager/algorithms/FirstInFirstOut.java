package memoryManager.algorithms;

import logs.Log;
import memoryManager.MemoryManager;

public class FirstInFirstOut extends MemoryManager {
    
    public FirstInFirstOut(Integer bufferSize, Boolean countFirstAccesses) {
        super("First In First Out (FIFO)", bufferSize, countFirstAccesses);
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
                this.buffer.remove(0);
            }

            this.buffer.add(id);
        }

        Log.show(this.buffer);
        Log.show();
    }
}
