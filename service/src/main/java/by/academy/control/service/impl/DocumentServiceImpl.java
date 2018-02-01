package by.academy.control.service.impl;

import by.academy.control.repository.dao.IDocumentDAO;
import by.academy.control.repository.dao.IUserDAO;
import by.academy.control.repository.model.Document;
import by.academy.control.repository.model.User;
import by.academy.control.service.IDocumentService;
import by.academy.control.service.converter.DocumentConverter;
import by.academy.control.service.model.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("documentService")
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private DocumentConverter documentConverter;

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IDocumentDAO documentDAO;

    @Override
    @Transactional
    public DocumentDTO getById(Long id) {
        Document document = documentDAO.getById(id);
        DocumentDTO documentDTO = null;
        if (document != null) {
            documentDTO = new DocumentDTO(document);
        }
        return documentDTO;
    }

    @Override
    @Transactional
    public List<DocumentDTO> getByUserId(Long userId) {
        User user = userDAO.getById(userId);
        List<Document> documents = user.getDocuments();
        List<DocumentDTO> documentDTOList = new ArrayList<>();
        for (Document document : documents) {
            documentDTOList.add(new DocumentDTO(document));
        }
        return documentDTOList;
    }

    @Override
    @Transactional
    public List<DocumentDTO> getAll() {
        List<Document> documents = documentDAO.getAll();
        List<DocumentDTO> documentDTOList = new ArrayList<>();
        for (Document document : documents) {
            documentDTOList.add(new DocumentDTO(document));
        }
        return documentDTOList;
    }

    @Override
    @Transactional
    public void create(DocumentDTO documentDTO) {
        Document document = new Document();
        documentConverter.convert(document, documentDTO);
        User user = userDAO.getById(documentDTO.getUserId());
        document.setUser(user);
        documentDAO.create(document);
    }

    @Override
    @Transactional
    public void update(DocumentDTO documentDTO) {
        Document document = documentDAO.getById(documentDTO.getId());
        documentConverter.convert(document, documentDTO);
        documentDAO.update(document);
    }

    @Override
    @Transactional
    public void delete(DocumentDTO documentDTO) {
        Document document = documentDAO.getById(documentDTO.getId());
        documentDAO.delete(document);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Document document = documentDAO.getById(id);
        documentDAO.delete(document);
    }
}
