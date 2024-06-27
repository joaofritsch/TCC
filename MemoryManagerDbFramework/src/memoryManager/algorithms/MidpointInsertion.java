package memoryManager.algorithms;

import java.util.ArrayList;

import logs.Log;
import memoryManager.MemoryManager;

public class MidpointInsertion extends MemoryManager {

    private Integer newSublistSize;
    private Integer oldSublistSize;
    private ArrayList<Integer> newSublist;
    private ArrayList<Integer> oldSublist;
    
    public MidpointInsertion(Integer bufferSize) {
        super("Midpoint Insertion", bufferSize);
        newSublistSize = (int)(Math.round((bufferSize * 0.625)));
        oldSublistSize = (int)(Math.round((bufferSize * 0.375)));
        if((newSublistSize + oldSublistSize) != bufferSize) newSublistSize--;
        newSublist = new ArrayList<Integer>();
        oldSublist = new ArrayList<Integer>();
    }

    @Override
    protected void remove() {
        Integer idToChange = oldSublist.get(oldSublistSize - 1);
        oldSublist.remove(idToChange);
        buffer.remove(idToChange);
    }

    @Override
    protected void add(Integer id) {
        buffer.add(id);
        oldSublist.add(0, id);
    }

    @Override
    protected void reorder(Integer id) {
        if(newSublist.contains(id)) {
            newSublist.remove(id);
        } else {
            oldSublist.remove(id);

            if(isNewSublistFull()) {
                Integer idToChange = newSublist.get(newSublistSize - 1);
                newSublist.remove(idToChange);
                oldSublist.add(0, idToChange);
            }
        }

        newSublist.add(0, id);
    }

    @Override
    protected void show() {
        Log.show(buffer);
        Log.show("New Sublist: " + newSublist);
        Log.show("Old Sublist: " + oldSublist);
        Log.show();
    }

    private Boolean isNewSublistFull() {
        return newSublistSize.equals(newSublist.size());
    }
}
