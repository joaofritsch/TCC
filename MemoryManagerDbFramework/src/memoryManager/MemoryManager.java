package memoryManager;
import java.util.ArrayList;

public abstract class MemoryManager {
    
    protected String name;
    protected Integer bufferSize;
    protected ArrayList<Integer> buffer;
    protected Integer pageMisses;
    protected Boolean countFirstAccesses;

    public MemoryManager(String name, Integer bufferSize, Boolean countFirstAccesses) {
        this.name = name;
        this.bufferSize = bufferSize;
        this.buffer = new ArrayList<Integer>();
        this.pageMisses = 0;
        this.countFirstAccesses = countFirstAccesses;
    }

    public abstract void lookup(Integer id);

    public String getName() {
        return this.name;
    }

    public Integer getBufferSize() {
        return this.bufferSize;
    }

    public Integer getPageMisses() {
        return this.pageMisses;
    }

    public void clear() {
        this.buffer.clear();
        this.pageMisses = 0;
    }
}
