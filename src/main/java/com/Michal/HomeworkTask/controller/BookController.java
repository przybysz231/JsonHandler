package com.Michal.HomeworkTask.controller;

import com.Michal.HomeworkTask.dao.BooksDAO;
import com.Michal.HomeworkTask.exception.NotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private BooksDAO booksDAO;

    @Autowired
    public BookController(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @GetMapping(value = "api/book/{isbn}", produces = "application/json;charset=UTF-8")
    public JSONObject bookIsbnGet(@PathVariable("isbn") String isbn) {
        JSONObject dataJsonObject = booksDAO.getJSONData();
        if (isbn.length() == 13 && dataJsonObject.toJSONString().contains(isbn)) {
            return booksDAO.getBookByIsbn(dataJsonObject, isbn);
        } else if (dataJsonObject.toJSONString().contains(isbn)) {
            return booksDAO.getBookById(dataJsonObject, isbn);
        } else throw new NotFoundException();
    }

    @GetMapping(value = "api/category/{categoryName}/books", produces = "application/json;charset=UTF-8")
    public JSONArray booksCategoryGet(@PathVariable("categoryName") String categoryName) {
        JSONObject dataJsonObject = booksDAO.getJSONData();
        return booksDAO.getBooksByCategory(dataJsonObject, categoryName);
    }

    @GetMapping(value = "api/rating", produces = "application/json;charset=UTF-8")
    public JSONArray booksRatingDesc() {
        JSONObject dataJsonObject = booksDAO.getJSONData();
        return booksDAO.getBookByRatingDesc(dataJsonObject);
    }

}
