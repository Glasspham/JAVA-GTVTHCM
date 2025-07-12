package manager;

import entity.Attendance;
import java.util.*;

/**
 * Quan ly danh sach tham du (them, xoa, tim kiem...).
 */
public class AttendanceManager {
    private List<Attendance> attendanceList;

    public AttendanceManager() {
        attendanceList = new ArrayList<>();
    }

    public void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }

    public List<Attendance> getAttendanceByMemberId(String memberId) {
        List<Attendance> result = new ArrayList<>();
        for (Attendance att : attendanceList) {
            if (att.getMemberId().equals(memberId)) result.add(att);
        }
        return result;
    }

    public List<Attendance> getAttendanceByDate(java.time.LocalDate date) {
        List<Attendance> result = new ArrayList<>();
        for (Attendance att : attendanceList) {
            if (att.getDate().equals(date)) result.add(att);
        }
        return result;
    }

    public List<Attendance> getAllAttendance() {
        return attendanceList;
    }
}
