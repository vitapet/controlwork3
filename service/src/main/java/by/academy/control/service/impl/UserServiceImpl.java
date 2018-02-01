package by.academy.control.service.impl;

import by.academy.control.repository.dao.IUserDAO;
import by.academy.control.repository.model.User;
import by.academy.control.service.IUserService;
import by.academy.control.service.converter.UserConverter;
import by.academy.control.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private IUserDAO userDAO;

    @Override
    @Transactional
    public UserDTO getById(Long id) {
        UserDTO userDTO = null;
        User user = userDAO.getById(id);
        if (user != null) {
            userDTO = new UserDTO(user);
        }
        return userDTO;
    }

    @Override
    @Transactional
    public List<UserDTO> getAll() {
        List<User> users = userDAO.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    @Override
    @Transactional
    public void create(UserDTO userDTO) {
        User user = new User();
        userConverter.convert(user, userDTO);
        userDAO.create(user);
    }

    @Override
    @Transactional
    public void update(UserDTO userDTO) {
        User user = userDAO.getById(userDTO.getId());
        userConverter.convert(user, userDTO);
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void delete(UserDTO userDTO) {
        User user = userDAO.getById(userDTO.getId());
        userDAO.delete(user);
    }

    @Override
    @Transactional
    public UserDTO getByLogin(String login) {
        User user = userDAO.getByLogin(login);
        if (user == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO(user);
            return userDTO;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = userDAO.getById(id);
        userDAO.delete(user);
    }
}
