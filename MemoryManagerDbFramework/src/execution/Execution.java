package execution;

import java.util.ArrayList;

import logs.Log;
import memoryManager.MemoryManager;
import memoryManager.algorithms.Optimal;
import request.Request;

public class Execution {

    private ArrayList<Request> requests;
    private MemoryManager memoryManager;
    private Integer pageMisses;

    public Execution(ArrayList<Request> requests, MemoryManager memoryManager) {
        this.requests = requests;
        this.memoryManager = memoryManager;
        pageMisses = 0;
    }

    public void start() {
        Log.show("Comecando a executar o algoritmo: " + memoryManager.getName());

        for(Request request : requests) {
            if(memoryManager instanceof Optimal) {
                Optimal optimal = (Optimal)memoryManager;
                optimal.setFutureAccesses(request.getRequests());
            }

            while(!request.hasFinished()) {
                Integer id = request.getNext();                
                memoryManager.lookup(id);
            }
            
            request.clear();
        }

        pageMisses = memoryManager.getPageMisses();
    }

    public MemoryManager getAlgorithm() {
        return memoryManager;
    }

    public Integer getPageMisses() {
        return pageMisses;
    }
}
