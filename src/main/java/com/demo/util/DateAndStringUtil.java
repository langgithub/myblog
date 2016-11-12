package com.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndStringUtil {

	public static String date2String(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String strDate=format.format(date);
		return strDate;
	}
	public static Date string2Date(String str){
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		Date date=null;
		try {
			date=format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	public static void main(String[] args) {
		System.out.println(string2Date("2016/11/06"));
	}
	public static String dateGetYear(String date){
		return date.trim().substring(0,4);
	}
}
