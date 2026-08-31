package SkillRack.SmallerMatrixSearch;

import javax.lang.model.element.Name;
import java.util.HashMap;

class Human {
    int age;
    String name;
    int salary;
    boolean married;

    static long population;
    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        population += 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Human p1 = new Human(21, "kishor", 20000, false);
        Human p2 = new Human(23, "kumar", 15000, true);

        System.out.println(p1.population);
        System.out.println(p2.population);
    }
}
