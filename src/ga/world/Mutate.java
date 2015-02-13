
package ga.world;

import java.util.ArrayList;
import java.util.Random;

public class Mutate {
    private final ArrayList<String> population;
    private final String alphabet;
    private final Random rnd = new Random();
    
    
    public Mutate(ArrayList<String> population, String alphabet){
        this.population = population;
        this.alphabet = alphabet;
    }
    
    public ArrayList<String> mutateWorld() {
        for (int t = 0; t < population.size(); t++) {
            String individual = population.get(t);
            if (rnd.nextInt(2) == 0) {
                individual = mutateIndividual(individual);
                this.population.set(t, individual);
            }
        }
        return this.population;
    }

    private String mutateIndividual(String individual) {
        String mutated = "";
        for (int t = 0; t < individual.length(); t++) {
            if (rnd.nextInt(2) == 0) {
                mutated = mutated + getRandomChar();
            } else {
                mutated = mutated + individual.charAt(t);
            }
        }
        return mutated;
    }

    private char getRandomChar() {
        return this.alphabet.charAt(rnd.nextInt(alphabet.length()));
    }
}
