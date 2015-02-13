package ga.world;

import java.util.ArrayList;

public class World {

    private ArrayList<String> population;
    private final String alphabet;
    private final String goal;
    private Mutate mutate;

    public World(int worldSize, String alphabet, String beginFrom, String goal) {
        this.population = new ArrayList<>();
        this.alphabet = alphabet;
        this.goal = goal;
        initializePopulation(worldSize, beginFrom);
    }

    private void initializePopulation(int worldSize, String beginFrom) {
        for (int t = 0; t < worldSize; t++) {
            population.add(beginFrom);
        }
    }

    public void mutateWorld() {
        this.mutate = new Mutate(this.population,alphabet);
        this.population = this.mutate.mutateWorld();
    }

    public String[] selectBest(int best) {
        SelectBest sb = new SelectBest(this.population, this.goal);
        return sb.selectBest(best);
    }

    public void multiply(String[] best) {
        this.population = new Multiply().multiply(best, this.population.size());
    }

}
