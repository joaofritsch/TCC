package request.types;

import java.util.Random;

import request.Request;

public class RandomRequest extends Request {

    public RandomRequest(Integer quantity, Integer start, Integer end) {
        super("Random Request", quantity, start, end);
    }

    @Override
    public void fillRequests() {
        Random random = new Random();

        for (int i = 0; i < this.quantity; i++) {
            int randomNumber = random.nextInt(this.end - this.start + 1) + this.start;
            this.requests.add(randomNumber);
        }
    }
}
