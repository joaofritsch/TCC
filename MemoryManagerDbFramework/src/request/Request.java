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
        index = 0;
        requests = new ArrayList<Integer>();
        fillRequests();
    }

    public abstract void fillRequests();

    public Boolean hasFinished() {
        return index.equals(requests.size());
    }

    public Integer getNext() {
        Integer request = requests.get(index);
        index++;
        return request;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public ArrayList<Integer> getRequests() {
        return requests;
    }

    public void clear() {
        index = 0;
    }
}
