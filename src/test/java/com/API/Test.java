package com.API;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Test {
	public static void main(String[] args) throws ParseException {

		String s = "https://reqres.in/api/users?page=2";
		String s1 = "Michael";

		RequestSpecification given = RestAssured.given();
		Response r = given.get(s);
		ResponseBody rs = r.getBody();
		System.out.println(rs.asPrettyString());

		JSONParser p = new JSONParser();// split the group of response into individual JSON
		Object o = p.parse(rs.asString());// the splitted content will be stored inside object

		JSONObject j1 = (JSONObject) o;// type casting object with JSON(for converting object to JSON object)
		Object o2 = j1.get("data");// taking only data group from JSONObject

		JSONArray a1 = (JSONArray) o2;// to get Id Seperately using JSONArray, since their is multiple id's

		for (int i = 0; i <= a1.size(); i++) {
			Object o3 = a1.get(i);
			JSONObject j2 = (JSONObject) o3;
			Object object = j2.get("first_name");
			String s2 = (String) object;

			if (s2.equalsIgnoreCase(s1)) {

				System.out.println(s2);

				Object object2 = j2.get("id");
				long s3 = (Long) object2;
				System.out.println(s3);

				Response r2 = given.pathParam("id", s3).get("https://reqres.in/api/users/{id}");
				ResponseBody rs2 = r2.getBody();
				System.out.println(rs2.asPrettyString());

				break;
			}

		}

	}

}
