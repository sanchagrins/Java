import java.io.*;
import java.net.*;
import java.util.*;

public class Bouy {
	private String url;
	private int id;
	private String dateRange[] = {"25", "26", "27", "28", "29", "30"};
	private boolean foundMonth;
	private boolean foundDate;
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

	public String[] getData() throws Exception {
		String header;
		StringBuilder results = new StringBuilder();
		String line;
		Integer lineNum = new Integer(1);
		Integer matchNum = new Integer(1);

		URL addr = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) addr.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader bouyData = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		header = bouyData.readLine() + "\n";
		results.append(header);
		
		while ((line = bouyData.readLine()) != null) {
			String readData[] = line.split("\\s+");
			String date = readData[2];
			boolean monthFound = readData[1].equals("08");
			boolean dateFound = Arrays.asList(dateRange).contains(date);
			if ((monthFound) && (dateFound)) {
				results.append(line + "\n");
				matchNum++;
			}
			lineNum++;
		}
		String[] data = {results.toString(), lineNum.toString(), matchNum.toString()};
		return data;

	}

	public HashMap getAvgWspd(String[] bouyData) throws Exception {
		String rawData = bouyData[0];
		HashMap<String, Double> avgWspd = new HashMap<String, Double>();

		for (int i=0;i<dateRange.length;i++) {
			double meanWspd=0.0;
			double sumWspd=0.0;
			double cnt=0.0;
			System.out.println(dateRange[i]);
			String line = null;
			BufferedReader br = new BufferedReader(new StringReader(rawData));
			while ((line=br.readLine()) != null) {
				String readData[] = line.split("\\s+");
				boolean dateCheck = readData[2].equals(dateRange[i]);
				if (dateCheck) {
					System.out.println(readData[6]);
					double wspd = Double.parseDouble(readData[6]);
					sumWspd = sumWspd + wspd;
					cnt++;
					meanWspd = sumWspd/cnt;
				}
				avgWspd.put(dateRange[i], meanWspd);
			}
		}
		return avgWspd;
	}
}
