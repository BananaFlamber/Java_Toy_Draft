import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore {
    List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.id == id) {
                toy.weight = weight;
                break;
            }
        }
    }

    public Toy drawToy() {
        List<Integer> weights = new ArrayList<>();
        int totalWeight = 0;
        for (Toy toy : toys) {
            weights.add(toy.weight);
            totalWeight += toy.weight;
        }
        Random random = new Random();
        int rndWeight = random.nextInt(totalWeight);
        for (int i = 0; i < toys.size(); i++) {
            if (rndWeight < weights.get(i)) {
                Toy toy = toys.get(i);
                toy.weight--;
                if (toy.weight == 0) {
                    toys.remove(i);
                }
                try {
                    File winnersFile = new File("winners.txt");
                    FileWriter writer = new FileWriter(winnersFile, true);
                    writer.write(toy.id + ", " + toy.name + "\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error writing to winners file");
                }
                return toy;
            }
            rndWeight -= weights.get(i);
        }
        return null;
    }
}
