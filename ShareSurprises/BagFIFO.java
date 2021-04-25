package ShareSurprises;

import java.util.ArrayList;

public class BagFIFO extends Bags {

    public BagFIFO() {
        super();
    }

    public BagFIFO(ArrayList<ISurprise> bag) {
        super(bag);
    }

    public BagFIFO(String gather) {
        super(gather);
    }

    @Override
    public ISurprise takeOut() {
        if (super.getBag().isEmpty()) {
            throw new NullPointerException();
        }

        ISurprise aux = super.getBag().get(0);
        super.getBag().remove(0);
        return aux;
    }

    @Override
    public String toString() {
        return "This is a FIFO bag.\n" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return super.equals(obj);
    }

}
