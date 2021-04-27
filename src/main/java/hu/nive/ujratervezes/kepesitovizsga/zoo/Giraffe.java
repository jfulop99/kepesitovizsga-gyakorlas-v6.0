package hu.nive.ujratervezes.kepesitovizsga.zoo;

public class Giraffe extends ZooAnimal {

    int length;

    public Giraffe(String name, int length) {
        super(name, AnimalType.GIRAFFE);
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public long getWeight() {
        return 0;
    }
}
