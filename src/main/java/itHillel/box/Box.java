package itHillel.box;

import itHillel.fruit.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        if (fruits.size() > 0) {
            if (fruit.getClass() != fruits.get(0).getClass()) {
                throw new RuntimeException("Unable to add fruit to box of different type.");
            }
        }
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruits) {
        for (T fruit : fruits) {
            addFruit(fruit);
        }
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0.0f;
        }
        float weight = fruits.size() * fruits.get(0).getWeight();
        return weight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001;
    }

    public void merge(Box<T> box) {
        if (box.fruits.size() == 0) {
            return;
        }
        if (fruits.size() == 0) {
            fruits = box.fruits;
            box.fruits = new ArrayList<>();
            return;
        }
        if (box.fruits.get(0).getClass() != fruits.get(0).getClass()) {
            throw new RuntimeException("Unable to merge boxes of different type.");
        }
        fruits.addAll(box.fruits);
        box.fruits = new ArrayList<>();
    }
}
