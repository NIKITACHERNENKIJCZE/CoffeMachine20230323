import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Кофемашина - Никита Черненкий");

        int moneyAmount = 120;
        System.out.println("Вы внесли " + moneyAmount + " руб.");

        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of("products.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Product> products = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("\s+");
            int price = Integer.parseInt(parts[1]);
            products.add( new Product(price, parts[0]));
        }

        products.add( new Product(200, "капучино"));
        products.add( new Product(100, "эспрессо"));
        products.add( new Product(50, "вода"));
        
        checkPrice(products,moneyAmount);
    }

    public static void checkPrice(ArrayList<Product> products, int moneyAmount) {

        boolean canBuyAnything = false;

        for (Product product : products) {
            if (moneyAmount >= product.getPrice()) {
                System.out.println("Вы можете купить " + product.getName());
                canBuyAnything = true;
            }
        }

        if (canBuyAnything == false) {
            System.out.println("Недостаточно средств : (Изучайте Java и " +
                    "зарабатывайте много");

        }
    }
}