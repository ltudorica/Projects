package ShareSurprises;

import java.util.ArrayList;

public class FortuneCookie implements ISurprise {

    private String message;
    private static final ArrayList<String> messages = Lists_Random.addFortuneCookie();

    private FortuneCookie(String message) {
        this.message = message;
    }

    @Override
    public void enjoy() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        FortuneCookie fortuneCookie = (FortuneCookie) obj;
        return this.message.equals(fortuneCookie.message);
    }

    @Override
    public int hashCode() {
        return ((this.message == null) ? 0 : this.message.hashCode());
    }

    public static ISurprise generate() {
        int no = Lists_Random.getRandom().nextInt(20);
        return new FortuneCookie(messages.get(no));
    }

}
