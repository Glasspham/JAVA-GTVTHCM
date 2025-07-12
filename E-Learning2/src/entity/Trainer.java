package entity;

/**
 * Lớp đại diện cho huấn luyện viên.
 * Kế thừa từ lớp User.
 */
public class Trainer extends User {
    public Trainer(String id, String name, String username, String password) {
        super(id, name, username, password, "TRAINER");
    }
}
