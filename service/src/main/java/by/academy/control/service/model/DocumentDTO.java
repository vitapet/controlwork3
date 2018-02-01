package by.academy.control.service.model;

import by.academy.control.repository.model.Document;

public class DocumentDTO {
    private Long id;
    private Long userId;
    private String name;
    private String description;
    private String pageCount;

    public DocumentDTO() {
    }

    public DocumentDTO(Document document) {
        setId(document.getId());
        setName(document.getName());
        setDescription(document.getDescription());
        setPageCount(document.getPageCount().toString());
        setUserId(document.getUser().getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }
}
