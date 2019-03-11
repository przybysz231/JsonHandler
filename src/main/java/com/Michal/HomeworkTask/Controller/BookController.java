package com.Michal.HomeworkTask.Controller;

import com.Michal.HomeworkTask.DAO.BooksDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;
@RestController
public class BookController {
    private BooksDAO booksDAO;
    @Autowired
    public BookController(BooksDAO booksDAO)
    {
        this.booksDAO = booksDAO;
    }

    @GetMapping(value = "api/book/{isbn}", produces = "application/json;charset=UTF-8")
    public JSONObject bookIsbnGet(@PathVariable("isbn") String isbn)
    {
        JSONObject dataJsonObject = booksDAO.getJSONData();

        return booksDAO.getBookByIsbn(dataJsonObject, isbn);
    }
    @GetMapping(value = "api/category/{categoryName}/books", produces = "application/json;charset=UTF-8")
    public JSONArray booksCategoryGet(@PathVariable("categoryName") String categoryName)
    {
        JSONObject dataJsonObject = booksDAO.getJSONData();

        return booksDAO.getBooksByCategory(dataJsonObject, categoryName);
    }
    @GetMapping(value = "api/rating", produces = "application/json;charset=UTF-8")
    public JSONArray booksRatingDesc()
    {
        JSONObject dataJsonObject = booksDAO.getJSONData();

        return booksDAO.getBookByRatingDesc(dataJsonObject);
    }

}
