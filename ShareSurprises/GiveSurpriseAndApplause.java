package ShareSurprises;

public class GiveSurpriseAndApplause extends GiveSurprise {

    public GiveSurpriseAndApplause(String string, int waitTime) {
        super(string, waitTime);
    }

    public void giveWithPassion() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Loud applause to you… For it is in giving that we receive.";
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return super.equals(obj);
    }

}
