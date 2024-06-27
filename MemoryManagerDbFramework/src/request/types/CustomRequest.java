package request.types;

import java.util.ArrayList;

import request.Request;

public class CustomRequest extends Request {
    
    public CustomRequest(ArrayList<Integer> requests) {
        super("Custom Request", requests.size(), null, null);
        this.requests = requests;
    }

    @Override
    public void fillRequests() {}
}
