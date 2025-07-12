package entity;

/**
 * Lop dai dien cho goi tap/luyen tap.
 */
public class SubscriptionPlan {
    // Id cua goi tap
    private String id;
    // Ten goi tap
    private String name;
    // Gia cua goi tap
    private double price;
    // Thoi gian cua goi tap (ngay)
    private int duration;
    // Mo ta ve goi tap
    private String description;

    public SubscriptionPlan(String id, String name, double price, int duration, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.description = description;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getDuration() { return duration; }
    public String getDescription() { return description; }
}
