package by.academy.control.web.validator;

import by.academy.control.service.model.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "login", "user.login.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
        ValidationUtils.rejectIfEmpty(errors, "firstName", "user.firstName.empty");
        ValidationUtils.rejectIfEmpty(errors, "surname", "user.surname.empty");

        UserDTO user = (UserDTO) target;

        Pattern pattern;
        if (user.getLogin() != null && !user.getLogin().isEmpty()) {
            pattern = Pattern.compile("^[a-zA-Z0-9._]{1,50}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(user.getLogin()).matches())) {
                errors.rejectValue("login", "user.login.invalid");
            }
        }
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            pattern = Pattern.compile("^[a-zA-Z0-9._]{1,50}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(user.getPassword()).matches())) {
                errors.rejectValue("password", "user.password.invalid");
            }
        }
        if (user.getFirstName() != null && !user.getFirstName().isEmpty()) {
            pattern = Pattern.compile("^[a-zA-Z]{1,50}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(user.getFirstName()).matches())) {
                errors.rejectValue("firstName", "user.firstName.invalid");
            }
        }
        if (user.getSurname() != null && !user.getSurname().isEmpty()) {
            pattern = Pattern.compile("^[a-zA-Z]{1,50}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(user.getSurname()).matches())) {
                errors.rejectValue("surname", "user.surname.invalid");
            }
        }
    }
}
