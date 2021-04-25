package ShareSurprises;

import java.util.ArrayList;

public class Candies implements ISurprise {

    private int noCandies;
    private static final ArrayList<String> candies = Lists_Random.addCandies();
    private String type;

    private Candies(int noCandies, String type) {
        this.noCandies = noCandies;
        this.type = type;
    }

    @Override
    public void enjoy() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "You received " + this.noCandies + " " + this.type + " candies!";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Candies candies = (Candies) obj;
        return this.noCandies == candies.noCandies && this.type.equals(candies.type);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        result = prime * result + this.noCandies;
        return result;
    }

    public static ISurprise generate() {
        int no = Lists_Random.getRandom().nextInt(9) + 1;
        int typeCandies = Lists_Random.getRandom().nextInt(7);
        return new Candies(no, candies.get(typeCandies));
    }
}
