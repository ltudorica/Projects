package ShareSurprises;

import java.util.ArrayList;

public class BagLIFO extends Bags {

    public BagLIFO() {
        super();
    }

    public BagLIFO(ArrayList<ISurprise> bag) {
        super(bag);
    }

    public BagLIFO(String gather) {
        super(gather);
    }

    @Override
    public ISurprise takeOut() {
        if (super.getBag().isEmpty()) {
            throw new NullPointerException();
        }

        ISurprise surprise = super.getBag().get(super.size() - 1);
        super.getBag().remove(super.size() - 1);
        return surprise;
    }

    @Override
    public String toString() {
        return "This is a LIFO bag.\n" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return super.equals(obj);
    }

}
