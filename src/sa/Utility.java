
 /*
  A Utility class with several methods
 */
package sa;

import java.util.Random;

public class Utility {


    /**
     * Computes and returns the Euclidean distance between two cities
     * @param city1 the first city
     * @param city2 the second city
     * @return distance the dist between city1 and city2
     */
    public static double distance(City city1, City city2){
        int xDistance = Math.abs(city1.getX() - city2.getX());
        int yDistance = Math.abs(city1.getY() - city2.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

        return distance;
    }

    /**
     * Calculates the acceptance probability
     */
//    public static double acceptanceProbability(int currentDistance, int newDistance, double temperature) {
//        // If the new solution is better, accept it
//        if (newDistance < currentDistance) {
//            return 1.0;
//        }
//        // If the new solution is worse, calculate an acceptance probability
//        return Math.exp((currentDistance - newDistance) / temperature);
//    }

    /**
     * this method returns a random number      */
    static double randomDouble()
    {
        Random r = new Random();
        return r.nextInt(1000) / 1000.0;
    }

    /**
     * returns a random int value within a given range

     */
    public static int randomInt(int min , int max) {
        Random r = new Random();
        double d = min + r.nextDouble() * (max - min);
        return (int)d;
    }
}
