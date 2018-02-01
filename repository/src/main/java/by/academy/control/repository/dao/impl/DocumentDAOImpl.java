package by.academy.control.repository.dao.impl;

import by.academy.control.repository.dao.IDocumentDAO;
import by.academy.control.repository.dao.IUserDAO;
import by.academy.control.repository.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("documentDAO")
public class DocumentDAOImpl extends GenericDAOImpl<Document> implements IDocumentDAO {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<Document> getByUserId(Long userId) {
        List<Document> documents = userDAO.getById(userId).getDocuments();
        return documents;
    }
}
