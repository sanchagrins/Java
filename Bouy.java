import java.io.*;
import java.net.*;
import java.util.*;

public class Bouy {
	private String url;
	private int id;
	private String dateRange[] = {"25", "26", "27", "28", "29", "30"};
	private boolean foundMonth;
	private boolean foundDate;
	private int lineNum=0;
	private int matchNum=0;
	private String data;

	public Bouy() {
		url = "http://www.ndbc.noaa.gov/view_text_file.php" +
			      "?filename=42001h2005.txt.gz&dir=data/historical/stdmet/";
		id = 42001;
	}

	public void setURL(String newURL) {
		url = newURL;
	}

	public void setID(int newID) {
		id = newID;
	}
	
	public String getURL() {
		return url;
	}

	public int getID() {
		return id;
	}

	public StringBuilder getData() throws Exception {
		String header;
		StringBuilder results = new StringBuilder();
		String line;

		URL addr = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) addr.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader bouyData = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		header = bouyData.readLine() + "\n";
		results.append(header);
		
		while ((line = bouyData.readLine()) != null) {
			String readData[] = line.split(" ");
			String date = readData[2];
			boolean monthFound = readData[1].equals("08");
			boolean dateFound = Arrays.asList(dateRange).contains(date);
			if ((monthFound) && (dateFound)) {
				results.append(line + "\n");
			}
		}
		return results;

	}
	


		

}
