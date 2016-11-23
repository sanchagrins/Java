/* File:	Bouy.java
 * Author:	sanchagrins
 * Date:	11-23-2016
 * Purpose:	Associated class file for BouyCalc.java and provides
 * 			methods for connecting to ndbc.noaa.gov and retrieving 
 * 			bouy data. Also calculates averages for wind speed,
 * 			wind gust, wave hieght and barometric pressure.
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class Bouy {

	// Field Declarations
	private String url;
	private int id;
	private String dateRange[] = {"25", "26", "27", "28", "29", "30"};
	private boolean foundMonth;
	private boolean foundDate;
	private String data;

	// Default Constructor
	public Bouy() {
		url = "http://www.ndbc.noaa.gov/view_text_file.php" +
			      "?filename=42001h2005.txt.gz&dir=data/historical/stdmet/";
		id = 42001;
	}

	// Setter Methods
	public void setURL(String newURL) {
		url = newURL;
	}

	public void setID(int newID) {
		id = newID;
	}
	
	// Getter Methods
	public String getURL() {
		return url;
	}

	public int getID() {
		return id;
	}
	
	/* Establishes connection with nbdc.noaa.gov and returns and array with the 
	 * slelected raw data, the count of lines processed and the count of matched
	 * lines.
	*/ 
	public String[] getData() throws Exception {
		String header;
		StringBuilder results = new StringBuilder();
		String line;
		Integer lineNum = new Integer(1);
		Integer matchNum = new Integer(1);

		// Opens the connection and feeds the data into the BufferedREader object bouyData
		URL addr = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) addr.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader bouyData = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		// Takes the first line from bouyData (i.e. header) and appends it to the results 
		header = bouyData.readLine() + "\n";
		results.append(header);

		// Reads through bouyData by line
		while ((line = bouyData.readLine()) != null) {
			String readData[] = line.split("\\s+");  // Splits each line into an array of values
			String date = readData[2]; // Gets value in third colume (i.e. date)
			boolean monthFound = readData[1].equals("08"); // Checks the line for the month (08 = August)
			boolean dateFound = Arrays.asList(dateRange).contains(date); // Checks the dates vs the dateRange Array

			// If the month is August and the date is found in the dateRange
			// array
			if ((monthFound) && (dateFound)) {
				results.append(line + "\n"); // Append the line
				matchNum++;
			}
			lineNum++;
		}

		// Converts the string StringBuilder object and Integer objects lineNum
		// and matchNum to strings and stores them in the new String array data
		String[] data = {results.toString(), lineNum.toString(), matchNum.toString()};
		return data;

	}
	
	// Takes in the String[] array data from the getConnection() method as a
	// parameter and retruns a HashMap of avaerages by date for wind speed
	public HashMap getAvgWspd(String[] bouyData) throws Exception {
		// Store the raw data
		String rawData = bouyData[0];

		// Creates output HashMap
		HashMap<String, Double> avgWspd = new HashMap<String, Double>();

		// For each date in dateRange[] array
		for (int i=0;i<dateRange.length;i++) {
			double meanWspd=0.0;
			double sumWspd=0.0;
			double cnt=0.0;
			String line = null;

			// Read in the raw data, split the line, check for date i in
			// dateRange[] and add the values
			BufferedReader br = new BufferedReader(new StringReader(rawData));
			while ((line=br.readLine()) != null) {
				String readData[] = line.split("\\s+");
				boolean dateCheck = readData[2].equals(dateRange[i]);
				if (dateCheck) {
					double wspd = Double.parseDouble(readData[6]);
					sumWspd = sumWspd + wspd;
					cnt++;
					meanWspd = sumWspd/cnt;
				}
				// Put key = date and value = mean wind speed in the HashMap
				avgWspd.put(dateRange[i], meanWspd);
			}
		}
		return avgWspd;
	}

	// Takes in the String[] array data from the getConnection() method as a
	// parameter and retruns a HashMap of avaerages by date for wind gust
	public HashMap getAvgGust(String[] bouyData) throws Exception {
		// Store the raw data
		String rawData = bouyData[0];

		// Create output HashMap
		HashMap<String, Double> avgGust = new HashMap<String, Double>();

		// For each date in dateRange[] array
		for (int i=0;i<dateRange.length;i++) {
			double meanGust=0.0;
			double sumGust=0.0;
			double cnt=0.0;
			String line = null;

			// Read in the raw data, split the line, check for date i in
			// dateRange[] and add the values
			BufferedReader br = new BufferedReader(new StringReader(rawData));
			while ((line=br.readLine()) != null) {
				String readData[] = line.split("\\s+");
				boolean dateCheck = readData[2].equals(dateRange[i]);
				if (dateCheck) {
					double gust = Double.parseDouble(readData[7]);
					sumGust = sumGust + gust;
					cnt++;
					meanGust = sumGust/cnt;
				}
				// Put key = date and value = mean wind gust in the HashMap
				avgGust.put(dateRange[i], meanGust);
			}
		}
		return avgGust;
	}

	// Takes in the String[] array data from the getConnection() method as a
	// parameter and retruns a HashMap of avaerages by date for wave height
	public HashMap getAvgWvht(String[] bouyData) throws Exception {
		// Store the raw data
		String rawData = bouyData[0];

		// Create output HashMap
		HashMap<String, Double> avgWvht = new HashMap<String, Double>();

		// For each date in dateRange[] array
		for (int i=0;i<dateRange.length;i++) {
			double meanWvht=0.0;
			double sumWvht=0.0;
			double cnt=0.0;
			String line = null;

			// Read in the raw data, split the line, check for date i in
			// dateRange[] and add the values
			BufferedReader br = new BufferedReader(new StringReader(rawData));
			while ((line=br.readLine()) != null) {
				String readData[] = line.split("\\s+");
				boolean dateCheck = readData[2].equals(dateRange[i]);
				if (dateCheck) {
					double wvht = Double.parseDouble(readData[8]);
					sumWvht = sumWvht + wvht;
					cnt++;
					meanWvht = sumWvht/cnt;
				}
				// Put key = date and value = mean wave height in the HashMap
				avgWvht.put(dateRange[i], meanWvht);
			}
		}
		return avgWvht;
	}

	// Takes in the String[] array data from the getConnection() method as a
	// parameter and retruns a HashMap of avaerages by date for barometric
	// pressure
	public HashMap getAvgPres(String[] bouyData) throws Exception {
		// Store the raw data
		String rawData = bouyData[0];

		// Create output HashMap
		HashMap<String, Double> avgBar = new HashMap<String, Double>();

		// For each date in dateRange[] array
		for (int i=0;i<dateRange.length;i++) {
			double meanBar=0.0;
			double sumBar=0.0;
			double cnt=0.0;
			String line = null;

			// Read in the raw data, split the line, check for date i in
			BufferedReader br = new BufferedReader(new StringReader(rawData));
			while ((line=br.readLine()) != null) {
				String readData[] = line.split("\\s+");
				boolean dateCheck = readData[2].equals(dateRange[i]);
				if (dateCheck) {
					double bar = Double.parseDouble(readData[12]);
					sumBar = sumBar + bar;
					cnt++;
					meanBar = sumBar/cnt;
				}
				// Put key = date and value = mean wave height in the HashMap
				avgBar.put(dateRange[i], meanBar);
			}
		}
		return avgBar;
	}

	// Takes in all the generated HashMaps and prints them in a report
	public String generateReport(HashMap wspd, HashMap gust, HashMap wvht, HashMap pres) {
		// Create a StringBuilder object to store the results
		StringBuilder results = new StringBuilder();

		// Build the report header
		String horFrame = "+-----------------------------------------------------------------------------+\n";
		results.append(horFrame);
		results.append("|                               NDBC ID " + id + " Report                          |\n");
		results.append(horFrame);
		results.append("|   Date    | Avg. Wspd(m/s) | Avg. Gust(m/s) |  Avg. Wvht(m) | Avg. Pres(hPa)|\n");
		results.append(horFrame);

		// Populates the report
		for (int i=0;i<dateRange.length;i++) {
			double wspdVal = (Double)wspd.get(dateRange[i]);
			double gustVal = (Double)gust.get(dateRange[i]);
			double wvhtVal = (Double)wvht.get(dateRange[i]);
			double presVal = (Double)pres.get(dateRange[i]);
			DecimalFormat df = new DecimalFormat("00.0000000");
			DecimalFormat dfPres = new DecimalFormat("0000.0");
			String wsPad = df.format(wspdVal);
			String gsPad = df.format(gustVal);
			String wvPad = df.format(wvhtVal);
			String psPad = dfPres.format(presVal);
			results.append("| 8-"+ dateRange[i] + "-2005 |   " +  wsPad + "   |   " + gsPad + "   |   " +
				                wvPad + "  |    " + psPad + "     |\n");
			results.append(horFrame);
		}
		String finalResults = results.toString();
		return finalResults;
	}

}
