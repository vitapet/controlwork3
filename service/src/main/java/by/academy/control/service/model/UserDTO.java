package by.academy.control.service.model;

import by.academy.control.repository.model.User;

public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String surname;
    private UserRoleDTO role;

    public UserDTO() {
    }

    public UserDTO(User user) {
        setId(user.getId());
        setLogin(user.getLogin());
        setPassword(user.getPassword());
        setFirstName(user.getFirstName());
        setSurname(user.getSurname());
        setRole(UserRoleDTO.valueOf(user.getRole().name()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserRoleDTO getRole() {
        return role;
    }

    public void setRole(UserRoleDTO role) {
        this.role = role;
    }
}
