package entity;

/**
 * Lop cha truu tuong cho tat ca nguoi dung (Admin, Trainer, Member).
 */
public abstract class User {
    // Id cua nguoi dung
    protected String id;
    // Ten cua nguoi dung
    protected String name;
    // Ten dang nhap cua nguoi dung
    protected String username;
    // Mat khau cua nguoi dung
    protected String password;
    // Vai tro cua nguoi dung (ADMIN, TRAINER, MEMBER)
    protected String role;

    public User(String id, String name, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setName(String name) { this.name = name; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}
