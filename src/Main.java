import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();
        store.addToy(new Toy(1, "Teddy Bear", 50));
        store.addToy(new Toy(2, "Doll", 30));
        store.addToy(new Toy(3, "Ball", 20));
        store.addToy(new Toy(4, "Car", 10));

        while (!store.toys.isEmpty()) {
            System.out.println("Press enter to draw a toy");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("Error reading input");
            }
            Toy toy = store.drawToy();
            if (toy != null) {
                System.out.println("Winner: " + toy.name);
            }
        }
    }
}