package memoryManager.algorithms;
import logs.Log;
import memoryManager.MemoryManager;

public class LeastRecentlyUsed extends MemoryManager {

    public LeastRecentlyUsed(Integer bufferSize) {
        super("Least Recently Used (LRU)", bufferSize);
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
    protected void reorder(Integer id) {
        buffer.remove(id);
        buffer.add(id);
    }

    @Override
    protected void show() {
        Log.show(buffer);
        Log.show();
    }
}
