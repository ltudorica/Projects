package ShareSurprises;

public class GiveSurpriseAndHug extends GiveSurprise {

    public GiveSurpriseAndHug(String string, int waitTime) {
        super(string, waitTime);
    }

    public void giveWithPassion() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Warm wishes and a big hug!";
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return super.equals(obj);
    }

}
