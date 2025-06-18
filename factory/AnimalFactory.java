package factory;

import animals.AbsAnimal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalTypeData;
import data.ColorData;

public class AnimalFactory {

  private String name;
  private int age;
  private int weight;
  private ColorData color;

  public AnimalFactory (String name, int age, int weight, ColorData color) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.color = color;
  }

  public AbsAnimal create(AnimalTypeData animalTypeData) {
    switch (animalTypeData) {
      case CAT: {
        return new Cat(name, age, weight, color);
      }
      case DOG: {
        return new Dog(name, age, weight, color);
      }
      case DUCK: {
        return new Duck(name, age, weight, color);
      }
    }
    throw new RuntimeException(String.format("Animal %s not found", animalTypeData.name().toLowerCase()));
  }
}
