package com.Michal.HomeworkTask.Controller;

import com.Michal.HomeworkTask.DAO.BooksDAO;
import com.Michal.HomeworkTask.Model.Book;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class BookController {
    private BooksDAO booksDAO;


    @Autowired
    public BookController(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @GetMapping(value = "api/book/{isbn}", produces = "application/json;charset=UTF-8")
    public JSONObject bookIsbnGet(@PathVariable("isbn") String isbn) {
        JSONObject dataJsonObject = booksDAO.getJSONData();
        if (isbn.length() == 13) {
            log.info("done");
            return booksDAO.getBookByIsbn(dataJsonObject, isbn);
        } else return booksDAO.getBookById(dataJsonObject, isbn);

    }
//    @GetMapping(value = "api/book/{isbn}", produces = "application/json;charset=UTF-8")
//    public JSONObject bookIsbnGet(@PathVariable("isbn") String isbn) {
//    JSONObject dataJsonObject = booksDAO.getJSONData();
//    return booksDAO.getBookByIsbn(dataJsonObject, isbn);
//    }
//    @GetMapping(value = "api/book/{id}", produces = "application/json;charset=UTF-8")
//    public JSONObject bookIdGet(@PathVariable("id") String id) {
//        JSONObject dataJsonObject = booksDAO.getJSONData();
//        return booksDAO.getBookById(dataJsonObject, id);
//    }
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
