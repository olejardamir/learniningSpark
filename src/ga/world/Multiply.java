package ga.world;

import java.util.ArrayList;
import java.util.Random;

public class Multiply {

    private final Random rnd = new Random();

    public ArrayList<String> multiply(String[] best, int popSize) {
        ArrayList<String> newPopulation = new ArrayList<>();
        for (int t = 0; t < popSize; t++) {
            newPopulation.add(crossBreed(best));
        }
        return newPopulation;
    }

    private String crossBreed(String[] best) {
        String parentA = selectParent(best);
        String parentB = selectParent(best);
        String offspring = crossBreedAB(parentA, parentB);
        return offspring;
    }

    private String selectParent(String[] best) {
        return best[rnd.nextInt(best.length)];
    }

    private String crossBreedAB(String A, String B) {
        String offspring = "";
        for (int t = 0; t < A.length(); t++) {
            if (rnd.nextInt(2) == 0) {
                offspring = offspring + A.charAt(t);
            } else {
                offspring = offspring + B.charAt(t);
            }
        }
        return offspring;
    }

}
