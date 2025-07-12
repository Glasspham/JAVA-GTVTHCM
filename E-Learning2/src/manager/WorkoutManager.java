package manager;

import entity.*;
import java.util.*;

/**
 * Quan ly danh sach lich tap (them, xoa, tim kiem...).
 */
public class WorkoutManager {
    private Map<String, WorkoutSchedule> schedules;

    public WorkoutManager() {
        schedules = new HashMap<>();
    }

    public void addSchedule(WorkoutSchedule schedule) {
        schedules.put(schedule.getId(), schedule);
    }

    public void removeSchedule(String id) {
        schedules.remove(id);
    }

    public WorkoutSchedule getScheduleById(String id) {
        return schedules.get(id);
    }

    public List<WorkoutSchedule> getSchedulesByMemberId(String memberId) {
        List<WorkoutSchedule> result = new ArrayList<>();
        for (WorkoutSchedule ws : schedules.values()) {
            if (ws.getMemberId().equals(memberId)) result.add(ws);
        }
        return result;
    }

    public List<WorkoutSchedule> getSchedulesByTrainerId(String trainerId) {
        List<WorkoutSchedule> result = new ArrayList<>();
        for (WorkoutSchedule ws : schedules.values()) {
            if (ws.getTrainerId().equals(trainerId)) result.add(ws);
        }
        return result;
    }

    public Collection<WorkoutSchedule> getAllSchedules() {
        return schedules.values();
    }
}
