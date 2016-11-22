import java.io.*;
import java.util.*;
import java.net.*;

public class BouyCalc {
	public static void main(String[] args) throws Exception {
		Bouy bouy = new Bouy();
		//StringBuilder results = new StringBuilder();
		System.out.println("Fetching data for bouy NDBC 42001 from nbc.noaa.gov");
		//URL url = new URL(bouy.url);
		//HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//conn.setRequestMethod("GET");
		//BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//String line;
		int lineNum = 1;
		int matchNum = 1;
		String dateRange[] = {"25", "26", "27", "28", "29", "30"};
		//String header = rd.readLine();
		//BufferedReader bouyData = bouy.getConnection();
		//String header = bouyData.readLine();
		//results.append(header);
		//while ((line = rd.readLine()) != null) {
			//String readData[] = line.split(" ");
			//String month = readData[1];
			//String date = readData[2];
			//boolean monthFound = readData[1].equals("08");
			//boolean dateFound = Arrays.asList(dateRange).contains(date);
			//if ((monthFound) && (dateFound)) {
				//results.append(line + "\n");
				//matchNum++;
			//}
			//lineNum++;
		//}
		//rd.close();
		StringBuilder results = bouy.getData();
		System.out.println(results);
		//System.out.println("Feteched " + lineNum + " lines");
		//System.out.println("Found " + matchNum + " matches");
	}
}
