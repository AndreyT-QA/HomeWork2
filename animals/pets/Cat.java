package animals.pets;

import animals.AbsAnimal;
import data.ColorData;

public class Cat extends AbsAnimal {

  public Cat(String name, int age, int weight, ColorData color) {
    super(name, age, weight, color);
  }

  @Override
  public void say () {
    System.out.println("Мяу");
  }


}

