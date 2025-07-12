package entity;

/**
 * Lop dai dien cho mot bai tap cu the.
 */
public class Workout {
    // Ten bai tap
    private String name;
    // Mo ta bai tap
    private String description;
    // So hiep
    private int sets;
    // So lan lap lai
    private int reps;

    public Workout(String name, String description, int sets, int reps) {
        this.name = name;
        this.description = description;
        this.sets = sets;
        this.reps = reps;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getSets() { return sets; }
    public int getReps() { return reps; }
}
