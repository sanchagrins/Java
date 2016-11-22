import java.io.*;
import java.util.*;
import java.net.*;

public class BouyCalc {
	public static void main(String[] args) throws Exception {
		String lines;
		String matches;
		HashMap avgWspd;

		Bouy bouy = new Bouy();
		System.out.println("Fetching data for bouy NDBC 42001 from nbc.noaa.gov...");
		String[] results = bouy.getData();
		System.out.println(results[0]);

		lines = results[1];
		matches = results[2];
		System.out.println("Feteched " + lines  + " lines");
		System.out.println("Found " + matches + " matches");

		System.out.println("Calculating avg. wind speed for date range...");
		avgWspd = bouy.getAvgWspd(results);

		Set set = avgWspd.entrySet();

		Iterator i = set.iterator();

		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
	}
}
