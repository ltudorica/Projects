package ShareSurprises;

import java.util.ArrayList;

public class BagRandom extends Bags {

    public BagRandom() {
        super();
    }

    public BagRandom(ArrayList<ISurprise> bag) {
        super(bag);
    }

    public BagRandom(String gather) {
        super(gather);
    }

    @Override
    public ISurprise takeOut() {
        if (super.getBag().isEmpty()) {
            throw new NullPointerException();
        }
        int index = Lists_Random.getRandom().nextInt(super.getBag().size());
        ISurprise surprise = super.getBag().get(index);
        super.getBag().remove(index);
        return surprise;
    }

    @Override
    public String toString() {
        return "This is a Random bag.\n" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return super.equals(obj);
    }

}
