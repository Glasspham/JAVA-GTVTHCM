import entity.*;
import manager.*;
import util.CSVUtil;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.FileNotFoundException;

public class Main {
    // Quan ly nguoi dung
    private static UserManager userManager = new UserManager();
    // Quan ly goi tap
    private static SubscriptionManager subscriptionManager = new SubscriptionManager();
    // Quan ly lich tap
    private static WorkoutManager workoutManager = new WorkoutManager();
    // Quan ly nguoi tham gia
    private static AttendanceManager attendanceManager = new AttendanceManager();
    // Nguoi dung hien tai
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;

    public static void main(String[] args) {
        loadAllData();
        seedData();
        while (true) {
            if (currentUser == null)
                loginMenu();
            else
                mainMenu();
        }
    }

    // --- Init --- //
    private static void seedData() {
        // Admins
        userManager.addUser(new Admin("admin", "Admin", "admin", "1"));
        userManager.addUser(new Admin("admin2", "Admin 2", "admin2", "2"));

        // Trainers
        Trainer trainer1 = new Trainer("trainer1", "Nguyen Van A", "trainer1", "1");
        Trainer trainer2 = new Trainer("trainer2", "Le Thi B", "trainer2", "2");
        userManager.addUser(trainer1);
        userManager.addUser(trainer2);

        // Subscription Plans
        SubscriptionPlan plan1 = new SubscriptionPlan("basic", "Basic", 500, 30, "Basic 1 month");
        SubscriptionPlan plan2 = new SubscriptionPlan("premium", "Premium", 900, 60, "Premium 2 months");
        SubscriptionPlan plan3 = new SubscriptionPlan("vip", "VIP", 1500, 90, "VIP 3 months");
        subscriptionManager.addPlan(plan1);
        subscriptionManager.addPlan(plan2);
        subscriptionManager.addPlan(plan3);

        // Members
        Member member1 = new Member("member1", "Tran Van C", "member1", "1", plan1);
        Member member2 = new Member("member2", "Pham Thi D", "member2", "2", plan2);
        Member member3 = new Member("member3", "Hoang Van E", "member3", "3", plan3);
        userManager.addUser(member1);
        userManager.addUser(member2);
        userManager.addUser(member3);

        // Workouts
        Workout squat = new Workout("Squat", "Tap chan", 4, 12);
        Workout pushup = new Workout("Push Up", "Tap nguc", 3, 15);
        Workout plank = new Workout("Plank", "Tap bung", 3, 60); // 60 giay

        // Workout Schedules
        WorkoutSchedule schedule1 = new WorkoutSchedule("ws1", member1.getId(), trainer1.getId(), Arrays.asList(squat, pushup));
        WorkoutSchedule schedule2 = new WorkoutSchedule("ws2", member2.getId(), trainer2.getId(), Arrays.asList(plank, pushup));
        workoutManager.addSchedule(schedule1);
        workoutManager.addSchedule(schedule2);

        // Attendance (giả lập điểm danh)
        attendanceManager.addAttendance(new Attendance(member1.getId(), LocalDate.now().minusDays(1), true));
        attendanceManager.addAttendance(new Attendance(member1.getId(), LocalDate.now(), true));
        attendanceManager.addAttendance(new Attendance(member2.getId(), LocalDate.now(), false));
        attendanceManager.addAttendance(new Attendance(member3.getId(), LocalDate.now(), true));
    }

    // --- He thong khi chua dang nhap --- //
    private static void loginMenu() {
        System.out.println("--- HE THONG QUAN LY PHONG GYM ---");
        System.out.print("Ten dang nhap: ");
        String username = scanner.nextLine();
        System.out.print("Mat khau: ");
        String password = scanner.nextLine();
        User user = userManager.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Dang nhap thanh cong voi vai tro " + user.getRole());
        } else {
            System.out.println("Thong tin dang nhap khong dung!");
        }
    }

    // --- Dua ra menu chinh tuong ung voi vai tro nguoi dung --- //
    private static void mainMenu() {
        switch (currentUser.getRole()) {
            case "ADMIN":
                adminMenu();
                break;
            case "TRAINER":
                trainerMenu();
                break;
            case "MEMBER":
                memberMenu();
                break;
        }
    }

    // --- ADMIN MENU --- //
    private static void adminMenu() {
        System.out.println("\n[MENU QUAN TRI VIEN]");
        System.out.println("1. Quan ly Hoi vien");
        System.out.println("2. Quan ly Huan luyen vien");
        System.out.println("3. Quan ly Goi tap");
        System.out.println("4. Bao cao");
        System.out.println("5. Luu du lieu");
        System.out.println("6. Tai lai du lieu");
        System.out.println("0. Dang xuat");
        System.out.print("Chon: ");
        String c = scanner.nextLine();
        switch (c) {
            case "1":
                manageMembers();
                break;
            case "2":
                manageTrainers();
                break;
            case "3":
                managePlans();
                break;
            case "4":
                adminReports();
                break;
            case "5":
                saveAllData();
                System.out.println("Da luu du lieu!");
                break;
            case "6":
                loadAllData();
                System.out.println("Da tai lai du lieu!");
                break;
            case "0":
                currentUser = null;
                break;
        }
    }

    private static void manageMembers() {
        System.out.println("\n[QUAN LY HOI VIEN]");
        System.out.println("1. Them Hoi vien");
        System.out.println("2. Liet ke Hoi vien");
        System.out.println("3. Xoa Hoi vien");
        System.out.println("0. Quay lai");
        System.out.print("Chon: ");
        String c = scanner.nextLine();
        switch (c) {
            case "1":
                addMember();
                break;
            case "2":
                listMembers();
                break;
            case "3":
                deleteMember();
                break;
        }
    }

    private static String getNextMemberId() {
        int max = 0;
        for (Member m : userManager.getAllMembers()) {
            String id = m.getId();
            if (id.startsWith("member")) {
                try {
                    int num = Integer.parseInt(id.substring(6));
                    if (num > max) max = num;
                } catch (Exception ignore) {}
            }
        }
        return "member" + (max + 1);
    }

    private static void addMember() {
        System.out.print("Ten: ");
        String name = scanner.nextLine();
        System.out.print("Ten dang nhap: ");
        String username = scanner.nextLine();
        if (userManager.getUserByUsername(username) != null) {
            System.out.println("Ten dang nhap da ton tai!");
            return;
        }
        System.out.print("Mat khau: ");
        String password = scanner.nextLine();
        System.out.print("Ma goi tap: ");
        String planId = scanner.nextLine();
        SubscriptionPlan plan = subscriptionManager.getPlanById(planId);
        if (plan == null) {
            System.out.println("Ma goi tap khong hop le!");
            return;
        }
        String id = getNextMemberId();
        Member member = new Member(id, name, username, password, plan);
        userManager.addUser(member);
        System.out.println("Da them hoi vien voi id: " + id);
    }

    private static void listMembers() {
        System.out.println("--- Danh sach Hoi vien ---");
        for (Member m : userManager.getAllMembers()) {
            System.out.println(m.getId() + " | " + m.getName() + " | Goi: " + m.getSubscription().getName());
        }
    }

    private static void deleteMember() {
        System.out.print("Nhap ma Hoi vien de xoa: ");
        String id = scanner.nextLine();
        userManager.removeUser(id);
        System.out.println("Da xoa (neu co).");
    }

    private static void manageTrainers() {
        System.out.println("\n[QUAN LY HUAN LUYEN VIEN]");
        System.out.println("1. Them Huan luyen vien");
        System.out.println("2. Liet ke Huan luyen vien");
        System.out.println("3. Xoa Huan luyen vien");
        System.out.println("0. Quay lai");
        System.out.print("Chon: ");
        String c = scanner.nextLine();
        switch (c) {
            case "1":
                addTrainer();
                break;
            case "2":
                listTrainers();
                break;
            case "3":
                deleteTrainer();
                break;
        }
    }

    private static String getNextTrainerId() {
        int max = 0;
        for (Trainer t : userManager.getAllTrainers()) {
            String id = t.getId();
            if (id.startsWith("trainer")) {
                try {
                    int num = Integer.parseInt(id.substring(7));
                    if (num > max) max = num;
                } catch (Exception ignore) {}
            }
        }
        return "trainer" + (max + 1);
    }

    private static void addTrainer() {
        System.out.print("Ten: ");
        String name = scanner.nextLine();
        System.out.print("Ten dang nhap: ");
        String username = scanner.nextLine();
        if (userManager.getUserByUsername(username) != null) {
            System.out.println("Ten dang nhap da ton tai!");
            return;
        }
        System.out.print("Mat khau: ");
        String password = scanner.nextLine();
        String id = getNextTrainerId();
        Trainer trainer = new Trainer(id, name, username, password);
        userManager.addUser(trainer);
        System.out.println("Da them huan luyen vien voi id: " + id);
    }

    private static void listTrainers() {
        System.out.println("--- Danh sach Huan luyen vien ---");
        for (Trainer t : userManager.getAllTrainers()) {
            System.out.println(t.getId() + " | " + t.getName());
        }
    }

    private static void deleteTrainer() {
        System.out.print("Nhap ma Huan luyen vien de xoa: ");
        String id = scanner.nextLine();
        userManager.removeUser(id);
        System.out.println("Da xoa (neu co).");
    }

    private static void managePlans() {
        System.out.println("\n[QUAN LY GOI TAP]");
        System.out.println("1. Them Goi tap");
        System.out.println("2. Liet ke Goi tap");
        System.out.println("3. Xoa Goi tap");
        System.out.println("0. Quay lai");
        System.out.print("Chon: ");
        String c = scanner.nextLine();
        switch (c) {
            case "1":
                addPlan();
                break;
            case "2":
                listPlans();
                break;
            case "3":
                deletePlan();
                break;
        }
    }

    private static String getNextPlanId() {
        int max = 0;
        for (SubscriptionPlan p : subscriptionManager.getAllPlans()) {
            String id = p.getId();
            if (id.startsWith("plan")) {
                try {
                    int num = Integer.parseInt(id.substring(4));
                    if (num > max) max = num;
                } catch (Exception ignore) {}
            }
        }
        return "plan" + (max + 1);
    }
    
    private static void addPlan() {
        System.out.print("Ten goi tap: ");
        String name = scanner.nextLine();
        System.out.print("Gia: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Thoi han (ngay): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Mo ta: ");
        String desc = scanner.nextLine();
        String id = getNextPlanId();
        SubscriptionPlan plan = new SubscriptionPlan(id, name, price, duration, desc);
        subscriptionManager.addPlan(plan);
        System.out.println("Da them goi tap voi id: " + id);
    }

    private static void listPlans() {
        System.out.println("--- Danh sach Goi tap ---");
        for (SubscriptionPlan p : subscriptionManager.getAllPlans()) {
            System.out.println(
                    p.getId() + " | " + p.getName() + " | $" + p.getPrice() + " | " + p.getDuration() + " ngay");
        }
    }

    private static void deletePlan() {
        System.out.print("Nhap ma Goi tap de xoa: ");
        String id = scanner.nextLine();
        subscriptionManager.removePlan(id);
        System.out.println("Da xoa (neu co).");
    }

    private static void adminReports() {
        System.out.println("\n[BAO CAO]");
        double totalRevenue = 0;
        int active = 0, expired = 0;
        List<String> reportLines = new ArrayList<>();
        reportLines.add("ID,Ten,Goi tap,Gia");
        for (Member m : userManager.getAllMembers()) {
            totalRevenue += m.getSubscription().getPrice();
            active++; // Gia su tat ca con han
            reportLines.add(m.getId() + "," + m.getName() + "," + m.getSubscription().getName() + ","
                    + m.getSubscription().getPrice());
        }
        System.out.println("Tong doanh thu: $" + totalRevenue);
        System.out.println("So hoi vien con han: " + active);
        System.out.println("So hoi vien het han: " + expired);

        System.out.println("1. Xuat bao cao ra CSV");
        System.out.println("0. Quay lai");
        System.out.print("Chon: ");
        String c = scanner.nextLine();
        if ("1".equals(c)) {
            try {
                CSVUtil.writeLines("csv/baocao.csv", reportLines);
                System.out.println("Da xuat bao cao ra file baocao.csv!");
            } catch (Exception e) {
                System.out.println("Loi khi xuat bao cao: " + e.getMessage());
            }
        }
    }

    // --- TRAINER MENU --- //
    private static void trainerMenu() {
        System.out.println("\n[MENU HUAN LUYEN VIEN]");
        System.out.println("1. Phan cong Lich tap");
        System.out.println("2. Cham cong");
        System.out.println("3. Xem Hoi vien");
        System.out.println("0. Dang xuat");
        System.out.print("Chon: ");
        String c = scanner.nextLine();
        switch (c) {
            case "1":
                assignWorkoutSchedule();
                break;
            case "2":
                trackAttendance();
                break;
            case "3":
                listMembers();
                break;
            case "0":
                currentUser = null;
                break;
        }
    }

    private static String getNextWorkoutScheduleId() {
        int max = 0;
        for (WorkoutSchedule ws : workoutManager.getAllSchedules()) {
            String id = ws.getId();
            if (id.startsWith("ws")) {
                try {
                    int num = Integer.parseInt(id.substring(2));
                    if (num > max) max = num;
                } catch (Exception ignore) {}
            }
        }
        return "ws" + (max + 1);
    }

    private static void assignWorkoutSchedule() {
        System.out.print("Ma Hoi vien: ");
        String memberId = scanner.nextLine();
        User user = userManager.getUserById(memberId);
        if (user == null || !(user instanceof Member)) {
            System.out.println("Hoi vien khong ton tai!");
            return;
        }
        System.out.print("Ten bai tap: ");
        String wName = scanner.nextLine();
        System.out.print("Mo ta: ");
        String desc = scanner.nextLine();
        System.out.print("So hiep: ");
        int sets = Integer.parseInt(scanner.nextLine());
        System.out.print("So lan lap lai: ");
        int reps = Integer.parseInt(scanner.nextLine());
        Workout workout = new Workout(wName, desc, sets, reps);
        List<Workout> workouts = new ArrayList<>();
        workouts.add(workout);
        String id = getNextWorkoutScheduleId();
        WorkoutSchedule ws = new WorkoutSchedule(id, memberId, currentUser.getId(), workouts);
        workoutManager.addSchedule(ws);
        System.out.println("Da phan cong lich tap voi id: " + id);
    }

    private static void trackAttendance() {
        System.out.print("Ma Hoi vien: ");
        String memberId = scanner.nextLine();
        System.out.print("Ngay (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = null;
        try {
            // Thu nhan dinh dang thieu so 0
            date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-M-d"));
        } catch (DateTimeParseException e) {
            try {
                date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException ex) {
                System.out.println("Ngay khong dung dinh dang! (Vi du: 2025-10-02)");
                return;
            }
        }
        System.out.print("Co mat? (y/n): ");
        boolean present = scanner.nextLine().equalsIgnoreCase("y");
        Attendance att = new Attendance(memberId, date, present);
        attendanceManager.addAttendance(att);
        System.out.println("Da ghi nhan cham cong!");
    }

    // --- MEMBER MENU --- //
    private static void memberMenu() {
        System.out.println("\n[MENU HOI VIEN]");
        System.out.println("1. Xem Lich tap");
        System.out.println("2. Cap nhat tien do");
        System.out.println("3. Gia han Goi tap");
        System.out.println("0. Dang xuat");
        System.out.print("Chon: ");
        String c = scanner.nextLine();
        switch (c) {
            case "1":
                viewWorkoutSchedule();
                break;
            case "2":
                updateProgress();
                break;
            case "3":
                renewSubscription();
                break;
            case "0":
                currentUser = null;
                break;
        }
    }

    private static void viewWorkoutSchedule() {
        Member m = (Member) currentUser;
        List<WorkoutSchedule> schedules = workoutManager.getSchedulesByMemberId(m.getId());
        if (schedules.isEmpty()) {
            System.out.println("Ban chua duoc phan lich tap!");
        } else {
            for (WorkoutSchedule ws : schedules) {
                System.out.println("Lich tap: " + ws.getId());
                for (Workout w : ws.getWorkouts()) {
                    System.out.println("- " + w.getName() + ": " + w.getDescription());
                }
            }
        }
    }

    private static void updateProgress() {
        System.out.print("Ma Lich tap: ");
        String scheduleId = scanner.nextLine();
        WorkoutSchedule ws = workoutManager.getScheduleById(scheduleId);
        if (ws == null || !ws.getMemberId().equals(currentUser.getId())) {
            System.out.println("Ma lich tap khong hop le!");
            return;
        }
        System.out.print("Nhap tien do moi (%): ");
        int progress = Integer.parseInt(scanner.nextLine());
        ws.setProgress(progress);
        System.out.println("Da cap nhat tien do!");
    }

    private static void renewSubscription() {
        System.out.print("Ma Goi tap: ");
        String planId = scanner.nextLine();
        SubscriptionPlan plan = subscriptionManager.getPlanById(planId);
        if (plan == null) {
            System.out.println("Ma goi tap khong hop le!");
            return;
        }
        ((Member) currentUser).setSubscription(plan);
        System.out.println("Da gia han goi tap!");
    }

    // --- LUU/TAI DU LIEU --- //
    private static void saveAllData() {
        try {
            // Save members
            List<String> memberLines = new ArrayList<>();
            for (Member m : userManager.getAllMembers()) {
                memberLines.add(m.getId() + "," + m.getName() + "," + m.getUsername() + "," + m.getPassword() + ","
                        + m.getSubscription().getId());
            }
            CSVUtil.writeLines("csv/members.csv", memberLines);
            // Save trainers
            List<String> trainerLines = new ArrayList<>();
            for (Trainer t : userManager.getAllTrainers()) {
                trainerLines.add(t.getId() + "," + t.getName() + "," + t.getUsername() + "," + t.getPassword());
            }
            CSVUtil.writeLines("csv/trainers.csv", trainerLines);
            // Save plans
            List<String> planLines = new ArrayList<>();
            for (SubscriptionPlan p : subscriptionManager.getAllPlans()) {
                planLines.add(p.getId() + "," + p.getName() + "," + p.getPrice() + "," + p.getDuration() + ","
                        + p.getDescription());
            }
            CSVUtil.writeLines("csv/plans.csv", planLines);
        } catch (Exception e) {
            System.out.println("Loi khi luu du lieu: " + e.getMessage());
        }
    }

    private static void loadAllData() {
        try {
            // Load plans
            List<String> planLines = CSVUtil.readLines("csv/plans.csv");
            for (String line : planLines) {
                String[] arr = line.split(",", 5);
                if (arr.length == 5) {
                    SubscriptionPlan plan = new SubscriptionPlan(arr[0], arr[1], Double.parseDouble(arr[2]),
                            Integer.parseInt(arr[3]), arr[4]);
                    subscriptionManager.addPlan(plan);
                }
            }
            // Load trainers
            List<String> trainerLines = CSVUtil.readLines("csv/trainers.csv");
            for (String line : trainerLines) {
                String[] arr = line.split(",", 4);
                if (arr.length == 4) {
                    Trainer t = new Trainer(arr[0], arr[1], arr[2], arr[3]);
                    userManager.addUser(t);
                }
            }
            // Load members
            List<String> memberLines = CSVUtil.readLines("csv/members.csv");
            for (String line : memberLines) {
                String[] arr = line.split(",", 5);
                if (arr.length == 5) {
                    SubscriptionPlan plan = subscriptionManager.getPlanById(arr[4]);
                    if (plan != null) {
                        Member m = new Member(arr[0], arr[1], arr[2], arr[3], plan);
                        userManager.addUser(m);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Chua co du lieu, khoi tao moi.");
        } catch (Exception e) {
            System.out.println("Loi khi tai du lieu: " + e.getMessage());
        }
    }
}