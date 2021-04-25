package ShareSurprises;

import java.util.ArrayList;


public abstract class Bags implements IBag {
    private ArrayList<ISurprise> bag;

    public Bags() {
        this.bag = new ArrayList<>();
    }

    public Bags(ArrayList<ISurprise> bag) {
        this.bag = bag;
    }

    public Bags(String gather) {
        if (gather.equals("gather")) {
            this.bag = GatherSurprises.gather(Lists_Random.getRandom().nextInt(9) + 1);
        }
    }

    public ArrayList<ISurprise> getBag() {
        return this.bag;
    }

    @Override
    public void put(ISurprise newSurprise) {
        if (this.bag.contains(newSurprise)) {
            System.out.println("The bag contains this surprise already, add it to another bag");
        } else {
            this.bag.add(newSurprise);
        }
    }

    @Override
    public void put(IBag bagOfSurprise) {
        while (!bagOfSurprise.isEmpty()) {
            this.bag.add(bagOfSurprise.takeOut());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    @Override
    public int size() {
        return this.bag.size();
    }

    @Override
    public String toString() {
        if (this.bag.isEmpty()) {
            return "The bag is empty!";
        }
        return "The bag contains the following surprises " + this.bag +
                "\nEnjoy!";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return false;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Bags bags = (Bags) obj;
        return this.bag.equals(bags.bag);
    }

    @Override
    public int hashCode() {
        return (this.bag.isEmpty() ? 0 : this.bag.hashCode());
    }
}
