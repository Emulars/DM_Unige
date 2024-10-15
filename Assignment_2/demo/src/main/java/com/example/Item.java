package com.example;

public interface Item {
	
	public static String name = "";
	public static float price = 0;
    
	//==================
	//===	Methods
	//==================
	
    public float cost();
    public void setValue(float cost);

}