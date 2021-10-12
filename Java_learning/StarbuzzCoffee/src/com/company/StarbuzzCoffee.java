package com.company;
import java.io.PrintStream;

public class StarbuzzCoffee {
    static PrintStream so = System.out;
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage.setSize("TALL");
        so.printf("%s(%s) $%.2f\n", beverage.getDescription(), beverage.SizeName(),beverage.cost());
        so.println(beverage.NutritionInfo().toString());

        Beverage bev2 = new DarkRoast();
        bev2 = new Mocha(bev2);
        bev2 = new Mocha(bev2);
        bev2 = new Whip(bev2);
        bev2.setSize("GRANDE");
        so.printf("\n%s(%s) $%.2f\n%s\n", bev2.getDescription(),bev2.SizeName(),
                bev2.cost(), bev2.NutritionInfo().toString());

        Beverage bev3 = new Soy(new Mocha(new Whip(new HouseBlend())));
        bev3.setSize("VENTI");
        so.printf("\n%s(%s) $%.2f\n%s\n", bev3.getDescription(),bev3.SizeName(),
                bev3.cost(),bev3.NutritionInfo().toString());

        Beverage bev4 = new Milk(new Mocha(new Decaf()));
        bev4.setSize("VENTI");
        so.printf("\n%s(%s) $%.2f\n%s\n", bev4.getDescription(),bev4.SizeName(),
                bev4.cost(),bev4.NutritionInfo().toString());

    }
}
class Nutrition {
    private int servingSize;
    private int calories;
    private int fat;
    private int caffeine;
    private int sugar;

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("serving size: ").append(servingSize)
                .append(", calories: ").append(calories)
                .append(", fat: ").append(fat)
                .append(". caffeine: ").append(caffeine)
                .append(", sugar: ").append(sugar);
        return sb.toString();
    }
    public Nutrition(int servingSize, int calories, int fat, int caffeine, int sugar){
        this.servingSize = servingSize;
        this.calories = calories;
        this.fat = fat;
        this.caffeine = caffeine;
        this.sugar = sugar;
    }
    public void add(int servingSize, int calories, int fat, int caffeine, int sugar){
        this.servingSize += servingSize;
        this.calories += calories;
        this.fat += fat;
        this.caffeine += caffeine;
        this.sugar += sugar;
    }

}
abstract class Beverage {
    String desc = "Unknown beverage";
    String coffeeSize = "Unknown Size";
    int TALL = 0;
    int GRANDE = 1;
    int VENTI = 2;
    public String getDescription() { return desc; }
    public String SizeName(){return coffeeSize;}
    public void setSize(String size){coffeeSize = size;}
    public int getSize(){
        if(coffeeSize == "GRANDE"){
            return GRANDE;
        }else if(coffeeSize == "VENTI"){
            return VENTI;
        }else{return TALL;}
    }

    public abstract double cost();
    //    create nutrition
    public abstract Nutrition NutritionInfo();
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
    public abstract int getSize();
    public abstract Nutrition NutritionInfo();
}

class Espresso extends Beverage {
    public Espresso() { desc = "Espresso"; }
    public double cost() { return 1.99; }
    public Nutrition NutritionInfo(){
        Nutrition info = new Nutrition(150, 10,2,150,0);
        return info;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() { desc = "HouseBlend"; }
    public double cost() { return 0.89; }
    public Nutrition NutritionInfo(){
        Nutrition info = new Nutrition(237, 1,0,12,0);
        return info;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() { desc = "DarkRoast"; }
    public double cost() { return 0.99; }
    public Nutrition NutritionInfo(){
        Nutrition info = new Nutrition(240, 5,0,260,0);
        return info;
    }
}

class Decaf extends Beverage {
    public Decaf() { desc = "Decaf"; }
    public double cost() { return 1.05; }
    public Nutrition NutritionInfo(){
        Nutrition info = new Nutrition(200, 10,0,50,0);
        return info;
    }
}

class Mocha extends CondimentDecorator {
    Beverage bev;

    public Mocha(Beverage beverage) { bev = beverage; }
    public int getSize(){return bev.getSize();}
    public String getDescription() { return "Mocha, " + bev.getDescription(); }
    public double cost() {
        double cost = bev.cost();
        if (getSize() == bev.TALL) {
            cost += .10;
        } else if (getSize() == bev.GRANDE) {
            cost += .15;
        } else if (getSize() == bev.VENTI) {
            cost += .20;
        }
        return cost;
    }
    public Nutrition NutritionInfo() {
        Nutrition changeNutrition = bev.NutritionInfo();
        changeNutrition.add(16,20,3,10,58);
        return changeNutrition;
    }

}

class Milk extends CondimentDecorator {
    Beverage bev;

    public Milk(Beverage beverage) { bev = beverage; }
    public int getSize(){return bev.getSize();}
    public String getDescription() { return "Milk, " + bev.getDescription(); }
    public double cost() {
        double cost = bev.cost();
        if (getSize() == bev.TALL) {
            cost += .20;
        } else if (getSize() == bev.GRANDE) {
            cost += .25;
        } else if (getSize() == bev.VENTI) {
            cost += .30;
        }
        return cost;
    }
    public Nutrition NutritionInfo() {
        Nutrition changeNutrition = bev.NutritionInfo();
        changeNutrition.add(16,260,10,0,25);
        return changeNutrition;
    }
}

class Soy extends CondimentDecorator {
    Beverage bev;

    public Soy(Beverage beverage) { bev = beverage; }
    public int getSize(){return bev.getSize();}
    public String getDescription() { return "Soy, " + bev.getDescription(); }
    public double cost() {
        double cost = bev.cost();
        if (getSize() == bev.TALL) {
            cost += .10;
        } else if (getSize() == bev.GRANDE) {
            cost += .15;
        } else if (getSize() == bev.VENTI) {
            cost += .20;
        }
        return cost;
    }
    public Nutrition NutritionInfo() {
        Nutrition changeNutrition = bev.NutritionInfo();
        changeNutrition.add(16,260,10,0,25);
        return changeNutrition;
    }
}

class Whip extends CondimentDecorator {
    Beverage bev;

    public Whip(Beverage beverage) { bev = beverage; }
    public int getSize(){return bev.getSize();}
    public String getDescription() { return "Whip, " + bev.getDescription(); }
    public double cost() {
        double cost = bev.cost();
        if (getSize() == bev.TALL) {
            cost += .20;
        } else if (getSize() == bev.GRANDE) {
            cost += .30;
        } else if (getSize() == bev.VENTI) {
            cost += .40;
        }
        return cost;
    }
    public Nutrition NutritionInfo() {
        Nutrition changeNutrition = bev.NutritionInfo();
        changeNutrition.add(20,80,8,0,20);
        return changeNutrition;
    }
}

//output
//        Mocha, Espresso(TALL) $2.09
//        serving size: 166, calories: 30, fat: 5. caffeine: 160, sugar: 58
//
//        Whip, Mocha, Mocha, DarkRoast(GRANDE) $1.39
//        serving size: 292, calories: 125, fat: 14. caffeine: 280, sugar: 136
//
//        Soy, Mocha, Whip, HouseBlend(VENTI) $1.29
//        serving size: 289, calories: 361, fat: 21. caffeine: 22, sugar: 103
//
//        Milk, Mocha, Decaf(VENTI) $1.35
//        serving size: 232, calories: 290, fat: 13. caffeine: 60, sugar: 83