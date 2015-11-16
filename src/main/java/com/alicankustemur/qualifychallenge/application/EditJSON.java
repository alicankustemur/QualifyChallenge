package com.alicankustemur.qualifychallenge.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditJSON
{
	public static void main(String[] args)
	{

		JSONParser parser = new JSONParser();

		try
		{
			String filePath = "C:\\book_data.json";
			FileReader reader = new FileReader(filePath);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
			JSONArray books = (JSONArray)jsonObject.get("books");
			JSONArray authors = (JSONArray)jsonObject.get("authors");

			Iterator iteratorBooks = books.iterator();

			JSONObject booksObj = new JSONObject();
			JSONArray arrayData = new JSONArray();
			JSONObject newJSONObj = null;

			while (iteratorBooks.hasNext())
			{
				JSONObject innerObj = (JSONObject)iteratorBooks.next();
				newJSONObj = new JSONObject();
				newJSONObj.put("id", innerObj.get("id"));
				newJSONObj.put("name", innerObj.get("name"));
				newJSONObj.put("author_id", innerObj.get("author"));
				arrayData.add(newJSONObj);
				booksObj.put("books", arrayData);

			}

			Iterator iteratorAuthors = authors.iterator();

			// take each value from the json array separately
			while (iteratorAuthors.hasNext())
			{
				JSONObject innerObj = (JSONObject)iteratorAuthors.next();
			}

			try
			{

				File file = new File("C://new_book_data.json");
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);

				fileWriter.write(booksObj.toJSONString());
				fileWriter.flush();
				fileWriter.close();

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

	}

}
