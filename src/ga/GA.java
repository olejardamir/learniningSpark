package ga;

import ga.world.World;

public class GA {

    public static void main(String[] args) {

        //Initial values    
        String alphabet = "GATC";
        String goal = "GGGAAATTTCCC";
        String beginFrom = "GATCGTACGTTA";
        int worldSize = 100;
        int survivors = 5;
        String end = "";
        World world = new World(worldSize, alphabet, beginFrom, goal);
        

        while (!end.equals(goal)) {
            world.mutateWorld();
            String[] bestN = world.selectBest(survivors);
            end = bestN[0];
            System.out.println(bestN[0]);
            world.multiply(bestN);
        }

    }

}
