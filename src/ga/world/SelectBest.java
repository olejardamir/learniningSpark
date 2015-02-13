
package ga.world;

import java.util.ArrayList;

public class SelectBest {
    private ArrayList<String> population;
        private final String goal;

    
    
    public SelectBest(ArrayList<String> population, String goal){
    this.population = population;
    this.goal = goal;
    }   
    
    
    
   public String[] selectBest(int best) {
        String[] bucket = sortPopulation();
        String[] bestN = truncateTo(best, bucket);
        return bestN;
    }

    private String[] truncateTo(int best, String[] bucket) {
        String[] bestN = new String[best];
        int counter = 0;
        for (int t = 0; t < bucket.length && counter != best; t++) {
            if (bucket[t] != null) {
                bestN[counter] = bucket[t];
                counter++;
            }
        }
        return bestN;
    }

    private String[] sortPopulation() {
        String[] bucket = new String[goal.length() + 1];
        for (String individual : population) {
            int position = evaluateIndividual(individual);
            bucket[position] = individual;
        }
        return bucket;
    }

    private int evaluateIndividual(String individual) {
        int evaluated = 0;
        for (int t = 0; t < individual.length(); t++) {
            if (individual.charAt(t) != this.goal.charAt(t)) {
                evaluated++;
            }
        }
        return evaluated;
    }
    
    
}
