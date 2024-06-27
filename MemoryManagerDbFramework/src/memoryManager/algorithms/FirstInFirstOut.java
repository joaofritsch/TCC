package memoryManager.algorithms;

import logs.Log;
import memoryManager.MemoryManager;

public class FirstInFirstOut extends MemoryManager {
    
    public FirstInFirstOut(Integer bufferSize) {
        super("First In First Out (FIFO)", bufferSize);
    }

    @Override
    protected void remove() {
        buffer.remove(0);
    }

    @Override
    protected void add(Integer id) {
        buffer.add(id);
    }

    @Override
    protected void reorder(Integer id) {}

    @Override
    protected void show() {
        Log.show(buffer);
        Log.show();
    }
}
