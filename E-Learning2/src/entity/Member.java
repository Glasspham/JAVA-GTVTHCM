package entity;

import java.util.*;

/**
 * Lop dai dien cho hoi vien phong gym.
 * Ke thua tu lop User.
 */
public class Member extends User {
    // Thong tin ve goi tap cua hoi vien
    private SubscriptionPlan subscription;
    // Danh sach lich tap cua hoi vien
    private List<Attendance> attendanceList;
    // Danh sach tien do tap luyen cua hoi vien
    private Map<String, Integer> workoutProgress; // workoutId -> percent

    public Member(String id, String name, String username, String password, SubscriptionPlan subscription) {
        super(id, name, username, password, "MEMBER");
        this.subscription = subscription;
        this.attendanceList = new ArrayList<>();
        this.workoutProgress = new HashMap<>();
    }

    public SubscriptionPlan getSubscription() { return subscription; }
    public void setSubscription(SubscriptionPlan subscription) { this.subscription = subscription; }
    public List<Attendance> getAttendanceList() { return attendanceList; }
    public Map<String, Integer> getWorkoutProgress() { return workoutProgress; }
}
