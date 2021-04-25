package ShareSurprises;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ISurprise candies = Candies.generate();
        ISurprise candies2 = Candies.generate();
        ISurprise candies3 = Candies.generate();
        ISurprise fortuneCookie = FortuneCookie.generate();
        ISurprise fortuneCookie2 = FortuneCookie.generate();
        ISurprise fortuneCookie3 = FortuneCookie.generate();
        ISurprise fortuneCookie4 = FortuneCookie.generate();
        ISurprise minion = MinionToy.generate();
        ISurprise minion2 = MinionToy.generate();
        ISurprise minion3 = MinionToy.generate();
        ISurprise minion4 = MinionToy.generate();

        ArrayList<ISurprise> surprises1 = new ArrayList<>();
        surprises1.add(candies);
        surprises1.add(fortuneCookie);
        surprises1.add(minion);

        ArrayList<ISurprise> surprises2 = new ArrayList<>();
        surprises2.add(candies2);
        surprises2.add(fortuneCookie2);
        surprises2.add(minion2);

        ArrayList<ISurprise> surprises3 = new ArrayList<>();
        surprises3.add(candies3);
        surprises3.add(fortuneCookie3);
        surprises3.add(minion3);

        for (ISurprise surprise : surprises1) {
            surprise.enjoy();
        }
        System.out.println();

        for (ISurprise surprise2 : surprises2) {
            surprise2.enjoy();
        }
        System.out.println();

        for (ISurprise surprise3 : surprises3) {
            surprise3.enjoy();
        }
        System.out.println();

        // creating a new bag with the param type ISurprise
        IBag bag1 = new BagFIFO(surprises1);
        IBag bag2 = new BagLIFO(surprises2);
        IBag bag3 = new BagRandom(surprises3);

        ArrayList<IBag> bags = new ArrayList<>();
        bags.add(bag1);
        bags.add(bag2);
        bags.add(bag3);

        for (IBag bag : bags) {
            System.out.println(bag);
        }

        System.out.println();

        for (IBag bag : bags) {
            bag.takeOut();
        }

        for (IBag bag : bags) {
            System.out.println(bag);
        }

        System.out.println();

        // checking method put(IBag) in Bags
        bag1.put(bag2);
        System.out.println(bag2.isEmpty());

        // adding a new surprise
        bag1.put(fortuneCookie4);
        System.out.println("bag1 details: " + bag1);
        System.out.println();

        // creating a new bag with random method from Gather
        bag2 = new BagLIFO("gather");
        System.out.println("bag2 details: " + bag2);
        System.out.println(bag2.size());
        System.out.println();


        GiveSurprise give1 = new GiveSurpriseAndApplause("FIFO", 2);
        GiveSurprise give2 = new GiveSurpriseAndHug("LIFO", 3);
        GiveSurprise give3 = new GiveSurpriseAndSing("RANDOM", 1);

        // adding a bag in another one - checking method put(IBag) in GiveSurprises
        give1.put(bag2);
        give1.giveAll();
        System.out.println();

        //checking if bag is empty after giving all surprises
        System.out.println(bag2.isEmpty());
        System.out.println();

        //checking if the elements on surprises2 were deleted
        bag2 = new BagFIFO(surprises2);
        System.out.println(bag2);
        System.out.println();

        // recreating bag2 with the random method
        bag2 = new BagFIFO("gather");
        System.out.println(bag2);
        System.out.println();

        // checking method put(ISurprise) in GiveSurprise
        give1.put(minion4);

        give1.put(bag2);
        give2.put(bag1);
        give3.put(bag3);

        // give only one surprise
        give2.give();
        System.out.println();

        // give all surprises
        give3.giveAll();



    }
}
