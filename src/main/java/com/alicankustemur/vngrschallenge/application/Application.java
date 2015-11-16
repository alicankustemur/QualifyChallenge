package com.alicankustemur.vngrschallenge.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Application
{

	static List<String> removeDuplicates(List<String> list)
	{

		ArrayList<String> result = new ArrayList<>();

		HashSet<String> set = new HashSet<>();

		for (String item : list)
		{

			if (!set.contains(item))
			{
				result.add(item);
				set.add(item);
			}
		}
		return result;
	}

	static void findAuthorBooksCount(List<String> list)
	{
		List<String> result = new ArrayList();
		Map<String, Integer> nameAndCount = new HashMap<>();
		for (String name : list)
		{
			Integer count = nameAndCount.get(name);
			if (count == null)
			{
				nameAndCount.put(name, 1);
			}
			else
			{
				nameAndCount.put(name, ++count);
			}
		}
		Set<Entry<String, Integer>> entrySet = nameAndCount.entrySet();
		for (Entry<String, Integer> entry : entrySet)
		{
			if (entry.getValue() > 1)
			{
				result.add(entry.getKey() + "  books count :  " + entry.getValue());

			}
		}

		createJSONFile("E:\\authorbookscount.json", result);

	}

	static void createJSONFile(String fileName, List<String> data)
	{
		try

		{

			File file = new File(fileName);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);

			for (String s : data)
			{
				fileWriter.write(s + " \n");
			}
			fileWriter.close();

		}
		catch (

		IOException e)

		{
			e.printStackTrace();
		}
	}

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

			List<String> available = new ArrayList();
			List<String> unAvailable = new ArrayList();

			for (Iterator booksIte = books.iterator(); booksIte.hasNext();)
			{
				JSONObject booksObj = (JSONObject)booksIte.next();

				for (Iterator authorsIte = authors.iterator(); authorsIte.hasNext();)
				{
					JSONObject authorsObj = (JSONObject)authorsIte.next();

					String author = booksObj.get("author").toString();
					String id = authorsObj.get("id").toString();

					//burada kitabı bulunan yazarları available listesine ekletiyorum
					if (author.equals(id))
					{
						available.add(author);
					}
					//kitabı olmayanlar ise unAvailable listesine ekleniyor.
					//yalnız burada bir sorun mevcut.tekrar eden her veri için unAvailable listesine aynı veriler tekrar tekrar eklenmektedir.
					else
					{
						unAvailable.add(author);
					}

				}

			}

			//tekrar eden verileri removeDuplicates methodu ile silmiş olsakta elimizde yine eklenmiş bazı veriler bulunmakta.
			//bu veriler available listesine eklendiği gibi birden fazla kitaba sahip yazarlar olduğu için unAvailable listesine eklenmektedir.
			//burada tekrarlarını sildiğimiz zaman editedUnAvailableData listesinin editedAvailableData listesinden daha fazla veriye sahip 
			//olduğu durumunda bu fazla verileri bu fazla verileri bulup listeden kaldırıyorum.
			//malformedData içerisinde kalan veriler ise bozuk veriye işaret etmektedir.
			List<String> editedUnAvailableData = removeDuplicates(unAvailable);
			List<String> editedAvailableData = removeDuplicates(available);
			List<String> malformedData = new ArrayList(editedUnAvailableData);

			if (editedUnAvailableData.size() > editedAvailableData.size())
			{
				for (String i : editedAvailableData)
				{
					for (String j : editedUnAvailableData)
					{
						if (j.equals(i))
						{
							malformedData.remove(i);
						}

					}
				}
			}

			createJSONFile("E:\\malformeddata.json", malformedData);

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
