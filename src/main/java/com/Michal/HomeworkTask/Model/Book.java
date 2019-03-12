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
    private String id;
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

        if (isbn != null) jsonObject.put("isbn", isbn);
        if (id != null) jsonObject.put("id", id);
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
//    @Override
//    public String toString()
//    {
//        return  "{" +
//                "isbn='" + isbn +  '\'' +
//                ", title='" + title + '\'' +
//                ", subtitle='" + subtitle + '\'' +
//                ", publisher='" + publisher + '\'' +
//                ", publishedDate=" + publishedDate +
//                ", description='" + description + '\'' +
//                ", pageCount=" + pageCount +
//                ", thumbnailUrl='" + thumbnailUrl + '\'' +
//                ", language='" + language + '\'' +
//                ", previewLink='" + previewLink + '\'' +
//                ", averageRating=" + averageRating +
//                ", authors=" + Arrays.toString(authors) +
//                ", categories=" + Arrays.toString(categories) +
//                '}';
//    }

}