package hu.nive.ujratervezes.kepesitovizsga.zoo;

public class Elephant extends ZooAnimal {

    private int length;
    private long weight;

    public Elephant(String name, int length, long weight) {
        super(name, AnimalType.ELEPHANT);
        this.length = length;
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public long getWeight() {
        return weight;
    }
}
