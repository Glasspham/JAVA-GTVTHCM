package manager;

import entity.*;
import java.util.*;
/**
 * Quan ly danh sach nguoi dung (them, xoa, tim kiem...).
 */
public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUserById(String id) {
        return users.get(id);
    }

    public User getUserByUsername(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public void removeUser(String id) {
        users.remove(id);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        for (User user : users.values()) {
            if (user instanceof Member) members.add((Member) user);
        }
        return members;
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        for (User user : users.values()) {
            if (user instanceof Trainer) trainers.add((Trainer) user);
        }
        return trainers;
    }
}
