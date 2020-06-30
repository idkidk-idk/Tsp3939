package sa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SimulatedAnneallingAlgorithm {



    // Calculate the acceptance probability
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {


        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        try {

            // Create and add our cities
            try {
                Scanner scanner = new Scanner(new File("/Users/RiaNarang/Desktop/Tsp3939/src/file42"));
                //looping through
                while (scanner.hasNextLine()) {
                    City c = new City();


                    if (scanner.hasNext()) {
                        //insert data into object
                      c.setCity_id(Integer.parseInt(scanner.next()));

                        c.setX(Integer.parseInt(scanner.next()));
                        c.setY(Integer.parseInt(scanner.next()));


                        //Adding to array list

                      TourManager.addCity(c);

                        System.out.print(c.city_id);


                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.getMessage();
            }

            System.out.println("ouuuuu");
            // Set initial temp
            double temp = 10000;

            // Cooling rate
            double coolingRate = 0.003;

            // Initialize intial solution
            Tour currentSolution = new Tour();
            currentSolution.generateIndividual();

            System.out.println("Initial solution distance: " + currentSolution.getDistance());

            // Set as current best
            Tour best = new Tour(currentSolution.getTour());

            // Loop until system has cooled
            while (temp > 1) {
                // Create new neighbour tour
                Tour newSolution = new Tour(currentSolution.getTour());

                // Get random positions in the tour
                int tourPos1 = Utility.randomInt(0, newSolution.tourSize());
                int tourPos2 = Utility.randomInt(0, newSolution.tourSize());

                //to make sure that tourPos1 and tourPos2 are different
                while (tourPos1 == tourPos2) {
                    tourPos2 = Utility.randomInt(0, newSolution.tourSize());
                }

                // Get the cities at selected positions in the tour
                City citySwap1 = newSolution.getCity(tourPos1);
                City citySwap2 = newSolution.getCity(tourPos2);

                // Swap them
                newSolution.setCity(tourPos2, citySwap1);
                newSolution.setCity(tourPos1, citySwap2);

                // Get energy of solutions
                int currentEnergy = currentSolution.getDistance();
                int neighbourEnergy = newSolution.getDistance();

                // Decide if we should accept the neighbour
                double rand = Utility.randomDouble();
                if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > rand) {
                    currentSolution = new Tour(newSolution.getTour());
                }

                // Keep track of the best solution found
                if (currentSolution.getDistance() < best.getDistance()) {
                    best = new Tour(currentSolution.getTour());
                }

                // Cool system
                temp *= 1 - coolingRate;
            }

            System.out.println("Final solution distance: " + best.getDistance());
            System.out.println("Tour: " + best);


        }catch (Exception e){
            e.getMessage();
        }
    }
}