package recipeapp;

import java.util.Objects;

public class Ingredient implements Comparable<Ingredient>{
    private final String name;
    private final Location loc;

    public Ingredient(String name, Location loc) {
        if (name == null || loc == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        return name.equalsIgnoreCase(that.getName()) && loc == that.getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), loc);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Ingredient other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
