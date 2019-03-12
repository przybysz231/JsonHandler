package com.Michal.HomeworkTask.DAO;

import com.Michal.HomeworkTask.Model.Book;
import com.Michal.HomeworkTask.Utilities.BookUtilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BooksDAOImpl implements BooksDAO{
    @Override
    public JSONObject getJSONData(){
        JSONObject jsonObject;
        try {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\Michał\\Desktop\\HomeworkTask\\src\\main\\resources\\data\\books.json"));
            return jsonObject;
        }
        catch (ParseException | IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject getBookByIsbn(JSONObject jsonObject, String isbn) {
        JSONObject bookJsonObject = null;
        JSONArray jsonArray = (JSONArray) jsonObject.get("items");
        List<Book> bookList = BookUtilities.toBookList(jsonArray);
        Optional<Book> book = bookList.stream().filter(Book -> {

            boolean isTrue = false;
            String result = Book.getIsbn();

            if (result != null && result.equals(isbn))
            {
                isTrue = true;
            }
            return isTrue;
        }).findFirst();

        if (book.isPresent())
        {
            bookJsonObject = book.get().toJsonObject();
        }

        return bookJsonObject;
    }
    @Override
    public JSONObject getBookById(JSONObject jsonObject, String id) {
        JSONObject bookJsonObject = null;
        JSONArray jsonArray = (JSONArray) jsonObject.get("items");
        List<Book> bookList = BookUtilities.toBookList(jsonArray);
        Optional<Book> book = bookList.stream().filter(Book -> {

            boolean isTrue = false;
            String result = Book.getId();
            if (result != null && result.equals(id))
            {
                isTrue = true;
            }
            return isTrue;
        }).findFirst();

        if (book.isPresent())
        {
            bookJsonObject = book.get().toJsonObject();
        }
        return bookJsonObject;
    }

    @Override
    public JSONArray getBooksByCategory(JSONObject jsonObject, String categoryName)
    {
        JSONArray bookJsonArray = new JSONArray();
        JSONArray jsonArray = (JSONArray) jsonObject.get("items");
        List<Book> bookList = BookUtilities.toBookList(jsonArray);

        bookList = bookList.stream().filter(Book -> {

            boolean isTrue = false;
            String[] categories = Book.getCategories();

            if (categories != null)
            {
                for (String s : categories)
                {
                    if (s.equals(categoryName))
                    {
                        isTrue = true;
                    }
                }
            }
            return isTrue;
        }).collect(Collectors.toList());

        bookJsonArray.addAll(bookList);
        return bookJsonArray;
    }

    @Override
    public JSONArray getBookByRatingDesc(JSONObject jsonObject)
    {
        JSONArray bookJsonArray = new JSONArray();

        JSONArray jsonArray = (JSONArray) jsonObject.get("items");
        for (Object aJsonArray : jsonArray)
        {
            JSONObject record = (JSONObject) aJsonArray;
            JSONObject volumeInfo = (JSONObject) record.get("volumeInfo");
            JSONArray authors = (JSONArray) volumeInfo.get("authors");
            Double averageRating = (Double) volumeInfo.get("averageRating");

            if (authors == null || averageRating == null)
            {
                continue;
            }

            Book book = new Book();

            book.setAuthors(BookUtilities.toStringArray(authors));
            book.setAverageRating(averageRating);

            JSONObject bookJsonObject = book.toJsonObject();

            bookJsonArray.add(bookJsonObject);
        }


        bookJsonArray.sort((o1, o2) -> {
            Double v1 = (Double) ((JSONObject) o1).get("averageRating");
            Double v2 = (Double) ((JSONObject) o2).get("averageRating");

            return v2.compareTo(v1);
        });

        return bookJsonArray;
    }
}
