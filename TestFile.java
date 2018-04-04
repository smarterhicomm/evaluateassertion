package com.smarterhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject; 

public class TestFile {
	private Connection conn;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "[7]";
		
		Gson gs = new Gson();
		JSONArray ja = new JSONArray(test);
		if((Integer)ja.toList().get(0) == 7) {
			System.out.println("Indeed");
		}
		System.out.println(ja.toList().get(0));
		System.out.println(gs.toJson(test));
		Integer[] inputprofileIDs={};
		ArrayList<Integer> intArrList = new ArrayList<>();
		for(int i =0;i<ja.length();i++) {
			intArrList.add((Integer)ja.getInt(i));
		}
		inputprofileIDs = (Integer[])intArrList.toArray(inputprofileIDs);
		System.out.println("lz " + inputprofileIDs.length );
		
		TestFile tf = new TestFile();
		tf.createConnector();
	}
	
	public void createConnector() {
		String url = "jdbc:oracle:thin:@192.168.10.17:1521/orcl";
        try {
        	this.conn = DriverManager.getConnection(url, "assertiontest",
                    "oracle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void executeQuery(String query) {
		
	}

}
