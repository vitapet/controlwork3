package by.academy.control.service.converter;

import by.academy.control.repository.model.Document;
import by.academy.control.service.model.DocumentDTO;
import org.springframework.stereotype.Component;

@Component
public class DocumentConverter {
    public void convert(Document document, DocumentDTO documentDTO) {
        document.setId(documentDTO.getId());
        document.setName(documentDTO.getName());
        document.setDescription(documentDTO.getDescription());
        document.setPageCount(Integer.valueOf(documentDTO.getPageCount()));
    }
}
