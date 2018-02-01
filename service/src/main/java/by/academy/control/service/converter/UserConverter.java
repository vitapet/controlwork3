package by.academy.control.service.converter;

import by.academy.control.repository.model.User;
import by.academy.control.service.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public void convert(User user, UserDTO userDTO) {
        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setSurname(userDTO.getSurname());
        user.setRole(userDTO.getRole().getRole());
    }
}
