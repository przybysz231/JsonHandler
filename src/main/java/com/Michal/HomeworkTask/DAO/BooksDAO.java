package com.Michal.HomeworkTask.DAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public interface BooksDAO {
    JSONObject getJSONData();
    JSONArray getBookAll(JSONObject jsonObject);
    JSONObject getBookByIsbn(JSONObject jsonObject, String isbn);
    JSONArray getBooksByCategory(JSONObject jsonObject, String categoryName);
    JSONArray getBookByRatingDesc(JSONObject jsonObject);
    List<String> getBookCategories(JSONObject jsonObject);
}
