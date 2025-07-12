package entity;

/**
 * Lớp đại diện cho tài khoản quản trị viên.
 * Kế thừa từ lớp User.
 */
public class Admin extends User {
    public Admin(String id, String name, String username, String password) {
        super(id, name, username, password, "ADMIN");
    }
}
