package by.academy.control.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "t_document")
public class Document implements Serializable {

    private static final long serialVersionUID = 3971723920410407167L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "F_USER_ID")
    private User user;
    @Column(name = "F_NAME")
    private String name;
    @Column(name = "F_DESCRIPTION")
    private String description;
    @Column(name = "F_PAGE_COUNT")
    private Integer pageCount;

    public Document() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return Objects.equals(getId(), document.getId()) &&
                Objects.equals(getUser(), document.getUser()) &&
                Objects.equals(getName(), document.getName()) &&
                Objects.equals(getDescription(), document.getDescription()) &&
                Objects.equals(getPageCount(), document.getPageCount());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUser(), getName(), getDescription(), getPageCount());
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}
