package entity;

import java.time.LocalDate;

/**
 * Bieu thi ho so tham du cua mot thanh vien.
 */
public class Attendance {
    // ID cua thanh vien
    private String memberId;
    // Ngay tham du
    private LocalDate date;
    // Trang thai tham du (true: co mat, false: vang mat)
    private boolean present;

    public Attendance(String memberId, LocalDate date, boolean present) {
        this.memberId = memberId;
        this.date = date;
        this.present = present;
    }

    public String getMemberId() { return memberId; }
    public LocalDate getDate() { return date; }
    public boolean isPresent() { return present; }
}
