package memoryManager.algorithms;
import logs.Log;
import memoryManager.MemoryManager;

public class LeastRecentlyUsed extends MemoryManager {

    public LeastRecentlyUsed(Integer bufferSize, Boolean countFirstAccesses) {
        super("Least Recently Used (LRU)", bufferSize, countFirstAccesses);
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
        } else {
            this.buffer.remove(id);
        }

        this.buffer.add(id);

        Log.show(this.buffer);
        Log.show();
    }
}
