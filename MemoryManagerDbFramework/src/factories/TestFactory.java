package factories;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    private Test testSequencialAccess() {
        return new Test(
            algorithms, 
            new ArrayList<Request>() {{ 
                add(new SequentialRequest(10, 1, 5)); 
            }}
        );
    }

    private Test testCustomAccess2() {
        return new Test(
            algorithms, 
            new ArrayList<Request>() {{
                add(new CustomRequest(new ArrayList<>(Arrays.asList(2, 1, 2, 2, 1, 4, 4, 5, 6, 7))));
            }}
        );
    }

    private Test testCustomAccess() {
        return new Test(
            algorithms, 
            new ArrayList<Request>() {{
                add(new CustomRequest(new ArrayList<>(Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2))));
            }}
        );
    }

    public ArrayList<Test> generate() {
        return new ArrayList<Test>() {{
            add(testCustomAccess());
        }};
    }
}
