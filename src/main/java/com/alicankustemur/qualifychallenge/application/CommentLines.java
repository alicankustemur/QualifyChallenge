package com.alicankustemur.qualifychallenge.application;
/*
			
			
			Iterator iteratorBooks = books.iterator();
			
			JSONObject object = new JSONObject();
			object.put("name", "sample");
			JSONArray array = new JSONArray();
			
			JSONObject arrayElementOne = new JSONObject();
			JSONArray arrayElementOneArray = new JSONArray();
			
			JSONObject arrayElementOneArrayElementOne = null;
			
			Iterator iteratorTest = arrayElementOneArray.iterator();
			
			// take each value from the json array separately
			while (iteratorBooks.hasNext())
			{
				JSONObject innerObj = (JSONObject)iteratorBooks.next();
				arrayElementOneArrayElementOne = new JSONObject();
				arrayElementOneArrayElementOne.put("id", innerObj.get("id"));
				arrayElementOneArrayElementOne.put("name", innerObj.get("name"));
				arrayElementOneArrayElementOne.put("author_id", innerObj.get("author"));
				arrayElementOneArray.add(arrayElementOneArrayElementOne);
				arrayElementOne.put("books", arrayElementOneArray);
			
			}
			
			
			
			Iterator iteratorAuthors = authors.iterator();
			
			// take each value from the json array separately
			while (iteratorAuthors.hasNext())
			{
				JSONObject innerObj = (JSONObject)iteratorAuthors.next();
				//System.out.println(innerObj.get("id") + " " + innerObj.get("name"));
			}
			
						try
						{
			
							  
							File file = new File("C://new.json");
							file.createNewFile();
							FileWriter fileWriter = new FileWriter(file);
			
							fileWriter.write(arrayElementOne.toJSONString());
							fileWriter.flush();
							fileWriter.close();
			
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}*/
