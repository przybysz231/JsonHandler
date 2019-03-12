package com.Michal.HomeworkTask.utilities;

import com.Michal.HomeworkTask.model.Book;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class BookUtilities {
    private static final Logger LOGGER = Logger.getLogger(BookUtilities.class.getName());
    public static Integer toInteger(Long variable)
    {
        return variable != null ? variable.intValue() : null;
    }
    public static String[] toStringArray(JSONArray jsonArray)
    {
        if (jsonArray == null)
        {
            return null;
        }

        String[] strings = new String[jsonArray.size()];

        for (int i = 0; i < strings.length; ++i)
        {
            strings[i] = (String) jsonArray.get(i);
        }

        return strings;
    }
    public static Long toLong(String stringDateFormat)
    {
        Date date = null;
        SimpleDateFormat formatter;

        try
        {
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(stringDateFormat);
        }
        catch (ParseException e1)
        {
            // LOGGER.warning("ParseException #1 EXCEPTION!");
        }
        catch (NullPointerException e2)
        {
            //LOGGER.warning("NullPointerException #1 EXCEPTION!");
        }

        try
        {
            formatter = new SimpleDateFormat("yyyy");
            date = formatter.parse(stringDateFormat);
        }
        catch (ParseException e3)
        {
            // LOGGER.warning("ParseException #2 EXCEPTION!");
        }
        catch (NullPointerException e4)
        {
           // LOGGER.warning("NullPointerException #2 EXCEPTION!");
        }

        return date != null ? date.getTime() : null;
    }
    public static List<Book> toBookList(JSONArray bookJsonArray)
    {
        List<Book> bookList = new LinkedList<>();

        for (Object aJsonArray : bookJsonArray)
        {
            JSONObject record = (JSONObject) aJsonArray;
            JSONObject volumeInfo = (JSONObject) record.get("volumeInfo");
            JSONObject imageLinks = (JSONObject) volumeInfo.get("imageLinks");
            JSONArray industryIdentifiers = (JSONArray) volumeInfo.get("industryIdentifiers");
            Book book = new Book();

            for (Object o : industryIdentifiers)
            {
                JSONObject industryIdentify = (JSONObject) o;
                if (industryIdentify.get("type").equals("ISBN_13"))
                    book.setIsbn((String) industryIdentify.get("identifier"));
                    else book.setId((String) record.get("id"));

            }
            //book.setId((String) record.get("id"));
            book.setTitle((String) volumeInfo.get("title"));
            book.setSubtitle((String) volumeInfo.get("subtitle"));
            book.setPublisher((String) volumeInfo.get("publisher"));
            book.setPublishedDate(BookUtilities.toLong((String) volumeInfo.get("publishedDate")));
            book.setDescription((String) volumeInfo.get("description"));
            book.setPageCount(BookUtilities.toInteger((Long) volumeInfo.get("pageCount")));
            book.setThumbnailUrl((String) imageLinks.get("thumbnail"));
            book.setLanguage((String) volumeInfo.get("language"));
            book.setPreviewLink((String) volumeInfo.get("previewLink"));
            book.setAverageRating((Double) volumeInfo.get("averageRating"));
            book.setAuthors(BookUtilities.toStringArray((JSONArray) volumeInfo.get("authors")));
            book.setCategories(BookUtilities.toStringArray((JSONArray) volumeInfo.get("categories")));
            bookList.add(book);
        }
        return bookList;
    }
}
