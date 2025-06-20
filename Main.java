import animals.AbsAnimal;
import data.AnimalTypeData;
import data.ColorData;
import data.CommandData;
import factory.AnimalFactory;
import tools.NumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<AbsAnimal> animals = new ArrayList<>();
    Scanner console = new Scanner(System.in);
    NumberValidator numberValidator = new NumberValidator();

    while (true) {
      System.out.println("Привет! Введи команду add/list/exit:");
      String input = console.next().trim().toLowerCase();
      CommandData command = CommandData.fromString(input);

      if (!input.equals("add") && !input.equals("list") && !input.equals("exit")) {
        System.out.println("Вы ввели неверную команду, повторите снова");
        continue;
      }
      switch (command) {
        case ADD: {
          AnimalTypeData animalTypeData;
          while (true) {
            System.out.println("Выберите животное для добавления: cat/dog/duck");
            String animalTypeUser = console.next().trim().toLowerCase();
            AnimalTypeData animalType = AnimalTypeData.fromString(animalTypeUser);

            if (!animalTypeUser.equals("cat") && !animalTypeUser.equals("dog") && !animalTypeUser.equals("duck")) {
              System.out.println("Животное не найдено, повторите снова");
              continue;
            }
            animalTypeData = AnimalTypeData.valueOf(animalTypeUser.toUpperCase());
            break;
          }

            System.out.println("Введите имя животного");
            String animalNameUser = console.next().trim();


          int animalAge;
          while (true) {
            System.out.println("Введите возраст животного");
            String animalAgeUser = console.next().trim();

            if(!numberValidator.isNumber(animalAgeUser)) {
              System.out.println("Введен некорректный возраст животного. Повторите снова");
              continue;
            }
            animalAge = Integer.parseInt(animalAgeUser);
            break;
          }

          int animalWeight;
          while (true) {
            System.out.println("Введите вес животного");
            String animalWeightUser = console.next().trim();

            if(!numberValidator.isNumber(animalWeightUser)) {
              System.out.println("Введен некорректный вес животного. Повторите снова");
              continue;
            }
            animalWeight = Integer.parseInt(animalWeightUser);
            break;
          }

          ColorData colorData;
          while (true) {
            System.out.println("Выберите цвет животного: white/black/orange");
            String animalColorUser = console.next().trim().toLowerCase();
            ColorData animalColor = ColorData.fromString(animalColorUser);

            if (!animalColorUser.equals("white") && !animalColorUser.equals("black") && !animalColorUser.equals("orange")) {
              System.out.println("Цвет не найден, повторите снова");
              continue;
            }
            colorData = ColorData.valueOf(animalColorUser.toUpperCase());
            break;
          }

          AbsAnimal animal = new AnimalFactory(animalNameUser, animalAge, animalWeight, colorData).create(animalTypeData);
          animals.add(animal);
          break;
        }
        case LIST: {
          for(AbsAnimal animal: animals) {
            System.out.println(animal.toString());
          }
          break;
        }
        case EXIT: {
          System.out.println("Пока пока!");
          console.close();
          return;

        }
      }
    }
  }
}