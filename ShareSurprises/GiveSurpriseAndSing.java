package ShareSurprises;

public class GiveSurpriseAndSing extends GiveSurprise {

    public GiveSurpriseAndSing(String string, int waitTime) {
        super(string, waitTime);
    }

    public void giveWithPassion() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Singing a nice song, full of joy and genuine excitement…";
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return super.equals(obj);
    }

}
