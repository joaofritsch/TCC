package request;

public class SequentialRequest extends Request {

    public SequentialRequest(Integer quantity, Integer start, Integer end) {
        super("Sequential Request", quantity, start, end);
    }

    @Override
    public void fillRequests() {        
        int length = this.end - this.start + 1;
        
        for (int i = 0; i < this.quantity; i++) {
            this.requests.add(this.start + (i % length));
        }
    }
}
