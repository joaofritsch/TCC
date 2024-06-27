package request.types;

import request.Request;

public class SequentialRequest extends Request {

    public SequentialRequest(Integer quantity, Integer start, Integer end) {
        super("Sequential Request", quantity, start, end);
    }

    @Override
    public void fillRequests() {        
        int length = end - start + 1;
        for (int i = 0; i < quantity; i++) requests.add(start + (i % length));
    }
}
