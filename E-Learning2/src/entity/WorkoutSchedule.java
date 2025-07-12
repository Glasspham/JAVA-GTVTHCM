package entity;

import java.util.*;

/**
 * Lop dai dien cho lich tap cua hoi vien.
 */
public class WorkoutSchedule {
    // ID cua lich tap
    private String id;
    // ID cua hoi vien
    private String memberId;
    // ID cua huan luyen vien
    private String trainerId;
    // Danh sach bai tap trong lich tap
    private List<Workout> workouts;
    // Tien do tap luyen (0-100%)
    private int progress; // percent

    public WorkoutSchedule(String id, String memberId, String trainerId, List<Workout> workouts) {
        this.id = id;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.workouts = workouts;
        this.progress = 0;
    }

    public String getId() { return id; }
    public String getMemberId() { return memberId; }
    public String getTrainerId() { return trainerId; }
    public List<Workout> getWorkouts() { return workouts; }
    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }
}
