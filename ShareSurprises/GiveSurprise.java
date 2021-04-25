package ShareSurprises;

import java.util.concurrent.TimeUnit;

public abstract class GiveSurprise {
    private IBag bag;
    private int waitTime;

    public GiveSurprise(String type, int waitTime) {
        this.bag = new Factory().makeBag(type);
        this.waitTime = waitTime;
    }

    public void put(ISurprise surprise) {
        this.bag.put(surprise);
    }

    public void put(IBag bag) {
        this.bag.put(bag);

    }

    public void give() {
        System.out.println(this.bag.takeOut());
        this.giveWithPassion();
    }

    public void giveAll() {
        while (!this.bag.isEmpty()) {
            System.out.println(this.bag.takeOut());
            try {
                TimeUnit.SECONDS.sleep(this.waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.giveWithPassion();
    }

    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    public int size() {
        return this.bag.size();
    }

    protected abstract void giveWithPassion();

    @Override
    public String toString() {
        return "Random giving";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return false;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        GiveSurprise give = (GiveSurprise) obj;
        return this.bag.equals(give.bag) && this.waitTime == give.waitTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.bag.hashCode();
        result = prime * result + this.waitTime;
        return result;
    }
}
