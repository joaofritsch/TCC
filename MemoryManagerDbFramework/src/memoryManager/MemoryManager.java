package memoryManager;
import java.util.ArrayList;

import logs.Log;

public abstract class MemoryManager {
    
    protected String name;
    protected Integer bufferSize;
    protected ArrayList<Integer> buffer;
    private Integer pageMisses;

    public MemoryManager(String name, Integer bufferSize) {
        this.name = name;
        this.bufferSize = bufferSize;
        buffer = new ArrayList<Integer>();
        pageMisses = 0;
    }

    protected abstract void remove();
    protected abstract void add(Integer id);
    protected abstract void reorder(Integer id);
    protected abstract void show();

    public void lookup(Integer id) {
        Log.show("Id: " + id);

        if(buffer.contains(id)) {
            reorder(id);
        } else {
            Log.show("miss");
            pageMisses++;
            if(isBufferFull()) remove();
            add(id);
        }

        show();
    }

    private Boolean isBufferFull() {
        return bufferSize.equals(buffer.size());
    }

    public String getName() {
        return name;
    }

    public Integer getBufferSize() {
        return bufferSize;
    }

    public Integer getPageMisses() {
        return pageMisses;
    }

    public void clear() {
        buffer.clear();
        pageMisses = 0;
    }
}
