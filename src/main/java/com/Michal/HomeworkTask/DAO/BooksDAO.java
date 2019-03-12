package com.Michal.HomeworkTask.DAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public interface BooksDAO {
    JSONObject getJSONData();
    JSONObject getBookByIsbn(JSONObject jsonObject, String isbn);
    JSONObject getBookById(JSONObject jsonObject, String id);
    JSONArray getBooksByCategory(JSONObject jsonObject, String categoryName);
    JSONArray getBookByRatingDesc(JSONObject jsonObject);
}
