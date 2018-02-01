package by.academy.control.repository.dao;

import by.academy.control.repository.model.Document;

import java.util.List;

public interface IDocumentDAO extends GenericDAO<Document> {

    List<Document> getByUserId(Long userId);
}
