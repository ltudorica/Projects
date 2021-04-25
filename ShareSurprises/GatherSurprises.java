package ShareSurprises;

import java.util.ArrayList;

public final class GatherSurprises {

    private GatherSurprises() {
    }

    public static ArrayList<ISurprise> gather(int n) {
        ArrayList<ISurprise> surprises = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            surprises.add(gather());
        }

        return surprises;
    }

    public static ISurprise gather() {
        int no = Lists_Random.getRandom().nextInt(3);
        if (no == 0) {
            return FortuneCookie.generate();
        }
        if (no == 1) {
            return Candies.generate();
        }
        return MinionToy.generate();
    }

}
