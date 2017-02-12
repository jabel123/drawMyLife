package com.drawMyLife.common.util;

import com.google.gson.JsonArray;

public class JsonTest {
	public static void main(String[] args) {
		JsonArray jArray=new JsonArray();
		for(int i=0;i<10;i++)
		{
			JsonArray j2=new JsonArray();
			j2.add(i);
			jArray.add(j2);
		}
				
	}
}
