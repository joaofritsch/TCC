package factories;

import java.util.ArrayList;

import memoryManager.MemoryManager;
import request.Request;
import request.types.CustomRequest;
import request.types.SequentialRequest;
import test.Test;

public class TestFactory {

    private ArrayList<MemoryManager> algorithms;

    public TestFactory(ArrayList<MemoryManager> algorithms) {
        this.algorithms = algorithms;
    }
    
    private Test sequencialAccess() {
        SequentialRequest sequentialRequest = new SequentialRequest(10, 1, 5);

        ArrayList<Request> requests = new ArrayList<Request>();
        requests.add(sequentialRequest);

        Test test = new Test(algorithms, requests);

        return test;
    }


    private Test customAccess() {
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(7);
        r.add(0);
        r.add(1);
        r.add(2);
        r.add(0);
        r.add(3);
        r.add(0);
        r.add(4);
        r.add(2);
        r.add(3);
        r.add(0);
        r.add(3);
        r.add(2);
        r.add(1);
        r.add(2);

        CustomRequest customRequest = new CustomRequest(r);
        
        ArrayList<Request> requests = new ArrayList<Request>();
        requests.add(customRequest);

        Test test = new Test(algorithms, requests);

        return test;
    }

    public ArrayList<Test> generate() {
        ArrayList<Test> tests = new ArrayList<Test>();

        tests.add(sequencialAccess());
        tests.add(customAccess());

        return tests;
    }
}
