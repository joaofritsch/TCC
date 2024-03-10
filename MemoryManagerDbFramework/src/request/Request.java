package request;
import java.util.ArrayList;

public abstract class Request {

    protected String name;
    protected Integer quantity;
    protected Integer start;
    protected Integer end;
    protected Integer index;
    protected ArrayList<Integer> requests;

    public Request(String name, Integer quantity, Integer start, Integer end) {
        this.name = name;
        this.quantity = quantity;
        this.start = start;
        this.end = end;
        this.index = 0;

        this.requests = new ArrayList<Integer>();
        this.fillRequests();
    }

    public abstract void fillRequests();

    public Boolean hasFinished() {
        return this.requests.size() == this.index;
    }

    public Integer getNext() {
        Integer request = this.requests.get(index);
        this.index++;

        return request;
    }

    public String getName() {
        return this.name;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getStart() {
        return this.start;
    }

    public Integer getEnd() {
        return this.end;
    }

    public ArrayList<Integer> getRequests() {
        return this.requests;
    }

    public void clear() {
        this.index = 0;
    }
}
