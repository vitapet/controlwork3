package by.academy.control.service;

import by.academy.control.service.model.DocumentDTO;

import java.util.List;

public interface IDocumentService {

    DocumentDTO getById(Long id);

    List<DocumentDTO> getByUserId(Long userId);

    List<DocumentDTO> getAll();

    void create(DocumentDTO documentDTO);

    void update(DocumentDTO documentDTO);

    void delete(DocumentDTO documentDTO);

    void delete(Long id);
}
