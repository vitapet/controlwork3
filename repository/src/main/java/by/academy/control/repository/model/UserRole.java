package by.academy.control.repository.model;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
