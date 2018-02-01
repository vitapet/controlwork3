package by.academy.control.service.model;

import by.academy.control.repository.model.UserRole;

public enum UserRoleDTO {
    ADMIN(UserRole.ADMIN),
    USER(UserRole.USER);

    UserRole role;

    UserRoleDTO(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }
}
