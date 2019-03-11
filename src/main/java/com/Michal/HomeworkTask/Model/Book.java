package com.Michal.HomeworkTask.Model;


import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
public class Book {
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Long publishedDate;
    private String description;
    private Integer pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private Double averageRating;
    private String[] authors;
    private String[] categories;
    public  Book() {}

    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();

        if (isbn != null) { jsonObject.put("isbn", isbn); }
        if (title != null) { jsonObject.put("title", title); }
        if (subtitle != null) { jsonObject.put("subtitle", subtitle); }
        if (publisher != null) { jsonObject.put("publisher", publisher); }
        if (publishedDate != null) { jsonObject.put("publishedDate", publishedDate); }
        if (description != null) { jsonObject.put("description", description); }
        if (pageCount != null) { jsonObject.put("pageCount", pageCount); }
        if (thumbnailUrl != null) { jsonObject.put("thumbnailUrl", thumbnailUrl); }
        if (language != null) { jsonObject.put("language", language); }
        if (previewLink != null) { jsonObject.put("previewLink", previewLink); }
        if (averageRating != null) { jsonObject.put("averageRating", averageRating); }
        if (authors != null) { jsonObject.put("authors", authors); }
        if (categories != null) { jsonObject.put("categories", categories); }

        return jsonObject;
    }
    @Override
    public String toString()
    {
        return  "{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", averageRating=" + averageRating +
                ", authors=" + Arrays.toString(authors) +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(subtitle, book.subtitle) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(publishedDate, book.publishedDate) &&
                Objects.equals(description, book.description) &&
                Objects.equals(pageCount, book.pageCount) &&
                Objects.equals(thumbnailUrl, book.thumbnailUrl) &&
                Objects.equals(language, book.language) &&
                Objects.equals(previewLink, book.previewLink) &&
                Objects.equals(averageRating, book.averageRating) &&
                Arrays.equals(authors, book.authors) &&
                Arrays.equals(categories, book.categories);
    }

    @Override
    public int hashCode()
    {

        int result = Objects.hash(isbn, title, subtitle, publisher, publishedDate, description, pageCount, thumbnailUrl,
                language, previewLink, averageRating);
        result = 31 * result + Arrays.hashCode(authors);
        result = 31 * result + Arrays.hashCode(categories);
        return result;
    }
}