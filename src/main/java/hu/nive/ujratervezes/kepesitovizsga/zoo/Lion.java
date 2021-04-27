package hu.nive.ujratervezes.kepesitovizsga.zoo;

public class Lion extends ZooAnimal {

    public Lion(String name) {
        super(name, AnimalType.LION);
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public long getWeight() {
        return 0;
    }
}
