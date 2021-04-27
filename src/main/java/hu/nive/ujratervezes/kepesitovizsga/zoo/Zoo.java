package hu.nive.ujratervezes.kepesitovizsga.zoo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private DataSource dataSource;

    private Set<ZooAnimal> animals;

    public Zoo(DataSource dataSource) {
        this.dataSource = dataSource;
        animals = new HashSet<>();
    }

    public void loadAnimals() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select animal_name, length_of_member, weight, animal_type from animals")){
            getResult(ps);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }

    }

    private void getResult(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                ZooAnimal animal = createAnimal(rs.getString("animal_name"), rs.getInt("length_of_member"), rs.getInt("weight"),
                        AnimalType.valueOf(rs.getString("animal_type")));
                animals.add(animal);
            }
        }
    }

    private ZooAnimal createAnimal(String name, int length, int weight, AnimalType type) {
        ZooAnimal result = null;
        switch (type) {
            case ELEPHANT -> {result = new Elephant(name, length, weight); }
            case LION -> {result = new Lion(name);}
            case GIRAFFE -> {result = new Giraffe(name, length); }
        }
        return result;
    }

    public Set<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }

    public void addAnimal(ZooAnimal animal) {
        animals.add(animal);
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        return animals.stream()
                .max(Comparator.comparing(ZooAnimal::getWeight))
                .orElseThrow();
    }

    public long countWeights() {
        return animals.stream()
                .collect(Collectors.summarizingLong(ZooAnimal::getWeight))
                .getSum();
    }

    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        return animals.stream()
                .filter(ani -> ani.equals(animal))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public ZooAnimal findExactAnimalByName(String name) {
        return animals.stream()
                .filter(ani -> ani.getName().equals(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        return animals.stream()
                .sorted(Comparator.comparing(ZooAnimal::getName))
                .collect(Collectors.toList());
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        return animals.stream()
                .collect(Collectors.toMap(ZooAnimal::getType, v -> 1, Integer::sum));
    }
}
