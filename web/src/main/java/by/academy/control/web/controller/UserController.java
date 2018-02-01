package by.academy.control.web.controller;

import by.academy.control.service.IDocumentService;
import by.academy.control.service.model.DocumentDTO;
import by.academy.control.web.model.UserPrincipal;
import by.academy.control.web.validator.DocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IDocumentService documentService;

    @Autowired
    private DocumentValidator documentValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(documentValidator);
    }

    @GetMapping("/user")
    public String showUserPage(Model model) {
        return "redirect:/user/documents";
    }

    @GetMapping("/user/documents")
    public String showDocuments(Model model) {
        List<DocumentDTO> documents = documentService.getByUserId(getPrincipal().getUserId());
        model.addAttribute("documents", documents);
        return "user/user_page";
    }

    //ADD
    @GetMapping("/user/documents/add")
    public String addDocument(Model model) {
        DocumentDTO documentDTO = new DocumentDTO();
        model.addAttribute("document", documentDTO);
        return "user/user_add_document";
    }

    @PostMapping("/user/documents/add")
    public String saveNewDocument(@Valid @ModelAttribute("document") DocumentDTO document,
                                  BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            document.setUserId(getPrincipal().getUserId());
            documentService.create(document);
            return "redirect:/user/documents";
        } else {
            return "user/user_add_document";
        }
    }

    //EDIT
    @GetMapping("/user/documents/{id}/edit")
    public String editDocument(Model model, @PathVariable Long id) {
        DocumentDTO documentDTO = documentService.getById(id);
        model.addAttribute("document", documentDTO);
        return "user/user_add_document";
    }

    @PostMapping("/user/documents/{id}/edit")
    public String saveEditedDocument(@Valid @ModelAttribute("document") DocumentDTO document,
                                     BindingResult bindingResult, @PathVariable Long id) {
        if (!bindingResult.hasErrors()) {
            documentService.update(document);
            return "redirect:/user/documents";
        } else {
            return "user/user_add_document";
        }
    }

    //Delete
    @GetMapping("/user/documents/{id}/delete")
    public String deleteDocument(Model model, @PathVariable Long id) {
        documentService.delete(id);
        return "redirect:/user/documents";
    }

    private UserPrincipal getPrincipal() {
        UserPrincipal user = null;
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null) {
            user = (UserPrincipal) principal;
        }
        return user;
    }
}
