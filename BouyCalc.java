import java.io.*;
import java.util.*;
import java.net.*;

public class BouyCalc {
	public static void main(String[] args) throws Exception {
		String lines;
		String matches;
		HashMap avgWspd;
		HashMap avgGust;
		HashMap avgWvht;
		HashMap avgPres;

		Bouy bouy = new Bouy();
		System.out.println("Fetching data from nbc.noaa.gov:");
		System.out.println("Date Range: 08-25-2005 - 08-31-2005");
		System.out.println("NDBC ID: " + bouy.getID());
		String[] results = bouy.getData();

		// Print Raw Data
		System.out.println("=====================Begin Raw Data=======================");
		System.out.println(results[0]);
		System.out.println("======================End Raw Data========================");

		// Print Fetch Summary
		lines = results[1];
		matches = results[2];
		System.out.println("Feteched " + lines  + " lines");
		System.out.println("Found " + matches + " matches");
        
        // Calculate Average Wind Speed
		System.out.print("\nCalculating avg. wind speed for date range...");
		avgWspd = bouy.getAvgWspd(results);
		System.out.println("Done.");

		// Calculate Average Wind Gust
		System.out.print("Calculating avg. wind gust for date range...");
		avgGust = bouy.getAvgGust(results);
		System.out.println("Done.");

		
		System.out.print("Calculating avg. wave height for date range...");
		avgWvht = bouy.getAvgWvht(results);
		System.out.println("Done.");

		System.out.print("Calculating avg barometric pressure for date range...");
		avgPres = bouy.getAvgPres(results);
		System.out.println("Done.\n");

		String report = bouy.generateReport(avgWspd, avgGust, avgWvht, avgPres);
		System.out.println(report);
	}
}
