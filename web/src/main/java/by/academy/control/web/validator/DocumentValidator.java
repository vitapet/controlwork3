package by.academy.control.web.validator;

import by.academy.control.service.model.DocumentDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class DocumentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return DocumentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "document.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "pageCount", "document.page.count.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "document.description.empty");

        DocumentDTO document = (DocumentDTO) target;

        Pattern pattern;
        if (document.getName() != null && !document.getName().isEmpty()) {
            pattern = Pattern.compile("^[a-zA-Z0-9.\\s]{1,50}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(document.getName()).matches())) {
                errors.rejectValue("name", "document.name.invalid");
            }
        }
        if (document.getPageCount() != null && !document.getPageCount().isEmpty()) {
            pattern = Pattern.compile("^[1-9][0-9]{1,8}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(document.getPageCount()).matches())) {
                errors.rejectValue("pageCount", "document.page.count.invalid");
            }
        }
        if (document.getDescription() != null && !document.getDescription().isEmpty()) {
            pattern = Pattern.compile("^[a-zA-Z0-9.\\s]{1,50}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(document.getDescription()).matches())) {
                errors.rejectValue("description", "document.description.invalid");
            }
        }
    }
}
