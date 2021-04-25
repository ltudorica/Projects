package ShareSurprises;

public class Factory implements IBagFactory {

    public IBag makeBag(String type) {
        switch (type) {
            case "RANDOM":
                return new BagRandom();
            case "FIFO":
                return new BagFIFO();
            case "LIFO":
                return new BagLIFO();
            default:
                throw new NullPointerException();
        }
    }
}
