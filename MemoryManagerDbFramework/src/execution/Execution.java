package execution;

import java.util.ArrayList;

import logs.Log;
import memoryManager.MemoryManager;
import request.Request;

public class Execution {

    private ArrayList<Request> requests;
    private MemoryManager memoryManager;
    private Integer pageMisses;

    public Execution(ArrayList<Request> requests, MemoryManager memoryManager) {
        this.requests = requests;
        this.memoryManager = memoryManager;
        this.pageMisses = 0;
    }

    public void start() {
        Log.show("Comecando a executar o algoritmo: " + memoryManager.getName());

        for(Request request : this.requests) {
            while(!request.hasFinished()) {
                Integer id = request.getNext();                
                this.memoryManager.lookup(id);
            }
            
            request.clear();
        }

        this.pageMisses = memoryManager.getPageMisses();
    }

    public MemoryManager getAlgorithm() {
        return this.memoryManager;
    }

    public Integer getPageMisses() {
        return this.pageMisses;
    }
}
