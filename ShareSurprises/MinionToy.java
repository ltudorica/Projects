package ShareSurprises;

import java.util.ArrayList;

public class MinionToy implements ISurprise {

    private String name;
    private static final ArrayList<String> minions = Lists_Random.addMinions();
    private static int counter = 0;

    private MinionToy(String name) {
        this.name = name;
    }

    @Override
    public void enjoy() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "You received a minion. His name is " + this.name + "!";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        MinionToy minion = (MinionToy) obj;
        return this.name.equals(minion.name);
    }

    @Override
    public int hashCode() {
        return ((this.name == null) ? 0 : this.name.hashCode());
    }

    public static ISurprise generate() {
        if (counter == 8) {
            counter = 0;
        }
        MinionToy.counter++;
        return new MinionToy(minions.get(MinionToy.counter - 1));
    }
}
