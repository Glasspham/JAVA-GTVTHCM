# Mô tả các lớp và phương thức trong chương trình

## 1. entity (Thực thể)
- **User (abstract class):** Lớp cha cho Admin, Trainer, Member. Thuộc tính: id, name, username, password, role.
- **Admin:** Kế thừa User, đại diện cho quản trị viên.
- **Trainer:** Kế thừa User, đại diện cho huấn luyện viên.
- **Member:** Kế thừa User, đại diện cho hội viên, có thêm thuộc tính SubscriptionPlan.
- **SubscriptionPlan:** Đại diện cho gói tập (id, name, price, duration, description).
- **Workout:** Đại diện cho bài tập (name, description, sets, reps).
- **WorkoutSchedule:** Lịch tập (id, memberId, trainerId, List<Workout>, progress).
- **Attendance:** Điểm danh (memberId, date, present).

## 2. manager (Quản lý)
- **UserManager:** Quản lý danh sách User (addUser, removeUser, getUserByUsername, getUserById, getAllMembers, getAllTrainers).
- **SubscriptionManager:** Quản lý danh sách gói tập (addPlan, removePlan, getPlanById, getAllPlans).
- **WorkoutManager:** Quản lý lịch tập (addSchedule, getSchedulesByMemberId, getScheduleById, getAllSchedules).
- **AttendanceManager:** Quản lý điểm danh (addAttendance, getAttendanceByMemberId).

## 3. util
- **CSVUtil:** Hỗ trợ đọc/ghi file CSV (writeLines, readLines).

## 4. Main.java (Chương trình chính)
- **main:** Hàm chạy chính, vòng lặp đăng nhập và menu.
- **seedData:** Tạo dữ liệu mẫu ban đầu.
- **loginMenu:** Đăng nhập hệ thống.
- **mainMenu:** Hiển thị menu theo vai trò.
- **adminMenu, trainerMenu, memberMenu:** Menu chức năng cho từng vai trò.
- **addMember, addTrainer, addPlan:** Thêm mới hội viên, huấn luyện viên, gói tập.
- **listMembers, listTrainers, listPlans:** Liệt kê danh sách.
- **deleteMember, deleteTrainer, deletePlan:** Xóa đối tượng.
- **assignWorkoutSchedule:** Phân công lịch tập cho hội viên.
- **trackAttendance:** Chấm công hội viên.
- **viewWorkoutSchedule:** Hội viên xem lịch tập.
- **updateProgress:** Hội viên cập nhật tiến độ.
- **renewSubscription:** Hội viên gia hạn gói tập.
- **saveAllData, loadAllData:** Lưu và tải dữ liệu từ file CSV.
- **adminReports:** Xem và xuất báo cáo doanh thu, hội viên.
