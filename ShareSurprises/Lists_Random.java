package ShareSurprises;

import java.util.ArrayList;
import java.util.Random;

public class Lists_Random {
    private static Random random = new Random();

    public static Random getRandom() {
        return random;
    }

    public static ArrayList<String> addFortuneCookie() {
        ArrayList<String> mySayings = new ArrayList<>(20);
        mySayings.add("The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela");
        mySayings.add("The way to get started is to quit talking and begin doing. -Walt Disney");
        mySayings.add("Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. -Steve Jobs");
        mySayings.add("If life were predictable it would cease to be life, and be without flavor. -Eleanor Roosevelt");
        mySayings.add("If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough. -Oprah Winfrey");
        mySayings.add("If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. -James Cameron");
        mySayings.add("Life is what happens when you're busy making other plans. -John Lennon");
        mySayings.add("Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa");
        mySayings.add("When you reach the end of your rope, tie a knot in it and hang on. -Franklin D. Roosevelt");
        mySayings.add("Always remember that you are absolutely unique. Just like everyone else. -Margaret Mead");
        mySayings.add("Don't judge each day by the harvest you reap but by the seeds that you plant. -Robert Louis Stevenson");
        mySayings.add("The future belongs to those who believe in the beauty of their dreams. -Eleanor Roosevelt");
        mySayings.add("Tell me and I forget. Teach me and I remember. Involve me and I learn. -Benjamin Franklin");
        mySayings.add("The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart. -Helen Keller");
        mySayings.add("It is during our darkest moments that we must focus to see the light. -Aristotle");
        mySayings.add("Whoever is happy will make others happy too. -Anne Frank");
        mySayings.add("Do not go where the path may lead, go instead where there is no path and leave a trail. -Ralph Waldo Emerson");
        mySayings.add("You will face many defeats in life, but never let yourself be defeated. -Maya Angelou");
        mySayings.add("In the end, it's not the years in your life that count. It's the life in your years. -Abraham Lincoln");
        mySayings.add("Never let the fear of striking out keep you from playing the game. -Babe Ruth");
        return mySayings;
    }

    public static ArrayList<String> addCandies() {
        ArrayList<String> myCandies = new ArrayList<>(7);
        myCandies.add("chocolate");
        myCandies.add("mint");
        myCandies.add("strawberry");
        myCandies.add("lemon");
        myCandies.add("orange");
        myCandies.add("coffee");
        myCandies.add("vanilla");
        return myCandies;
    }

    public static ArrayList<String> addMinions() {
        ArrayList<String> myMinions = new ArrayList<>(8);
        myMinions.add("Stuart");
        myMinions.add("Kevin");
        myMinions.add("Bob");
        myMinions.add("Dave");
        myMinions.add("Phil");
        myMinions.add("Tim");
        myMinions.add("Carl");
        myMinions.add("Jorge");
        return myMinions;
    }

    @Override
    public String toString() {
        return "The random number is: " + Lists_Random.random;
    }

}
