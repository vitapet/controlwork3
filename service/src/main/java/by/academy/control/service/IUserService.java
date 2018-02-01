package by.academy.control.service;

import by.academy.control.service.model.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO getById(Long id);

    List<UserDTO> getAll();

    void create(UserDTO userDTO);

    void update(UserDTO userDTO);

    void delete(UserDTO userDTO);

    void delete(Long id);

    UserDTO getByLogin(String login);
}
