package bg.softuni.advancedqueries;

import bg.softuni.advancedqueries.entities.Shampoo;

import bg.softuni.advancedqueries.entities.Size;
import bg.softuni.advancedqueries.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private ShampooService shampooService;

    public Main(ShampooService shampooService) {
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String ingredient= scanner.nextLine();
        for (Shampoo shampoo: this.shampooService.findByIngredient(ingredient)) {
            System.out.println(shampoo.getId());
        }
    }
}
