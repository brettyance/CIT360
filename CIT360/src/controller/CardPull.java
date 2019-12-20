package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.*;

import model.Card;

public class CardPull implements ListItem {
	public void run() {
		
		
		try {
			
			HttpURLConnection con = createConnection();
			JSONObject cardJSON = getCardFromAPI(con);
			Card card = new Card((String)cardJSON.get("code"), (String)cardJSON.get("suit"), (String)cardJSON.get("value"));
			
			Start.view.print(card.toString() + "\n");
			
			//take Object and convert to JSON
			printJSON(card);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static JSONObject getCardFromAPI(HttpURLConnection con) throws Exception {
		
		JSONParser parser = new JSONParser();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		
		while ((inputLine = in.readLine()) !=null) {
			response.append(inputLine);
		}
		in.close();
		
		
		String cardString = String.valueOf(response);
		
		JSONObject jsobj = (JSONObject)parser.parse(cardString);
		
		JSONArray jsArray = (JSONArray)jsobj.get("cards");
		
		JSONObject json = (JSONObject)jsArray.get(0);
		
		return json;
	}
	
	static HttpURLConnection createConnection() throws Exception {
		
		final String USER_AGENT = "Mozilla/5.0";
		
		String url = "https://deckofcardsapi.com/api/deck/new/draw/?count=1";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		int responseCode = con.getResponseCode();
		Start.view.print("\nSending 'GET' request to URL: " + url);
		Start.view.print("Response Code : " + responseCode + "\n");
		
		
		return con;
	}
	
	static void printJSON(Card card) {
		
		//take Object and convert to JSON
		Gson gson = new Gson();
		String jsonString = gson.toJson(card);
		System.out.println(jsonString);
	}
}
