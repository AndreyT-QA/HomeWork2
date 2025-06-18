package animals;

import data.ColorData;

public abstract class AbsAnimal {

  private String name;
  private int age;
  private int weight;
  private ColorData color;

  public AbsAnimal (String name, int age, int weight, ColorData color) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getWeight() {
    return weight;
  }

  public ColorData getColor() {
    return color;
  }

  public void say () {
    System.out.println("Я говорю");
  }

  public void go () {
    System.out.println("Я иду");
  }

  public void drink () {
    System.out.println("Я пью");
  }

  public void eat () {
    System.out.println("Я ем");
  }

  @Override
  public String toString () {
    return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
        name, age, ageWord(), weight, color.getName());
  }
     String ageWord() {
    if (age >= 11 && age <= 14) {
      return "лет";
    }

    int ost = age % 10;
    if (ost == 1) {
      return "год";
    }

    if (ost >= 2 && ost <= 4) {
      return "года";
    }

    return "лет";

  }
}