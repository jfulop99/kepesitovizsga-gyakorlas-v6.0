package hu.nive.ujratervezes.kepesitovizsga.zoo;

public abstract class ZooAnimal {
    private String name;
    private AnimalType type;

    public ZooAnimal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public abstract int getLength();

    public abstract long getWeight();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZooAnimal zooAnimal = (ZooAnimal) o;

        if (name != null ? !name.equals(zooAnimal.name) : zooAnimal.name != null) return false;
        return type == zooAnimal.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
