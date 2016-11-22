import java.io.*;
import java.net.*;
import java.util.*;
import java.math.*;
import java.text.*;

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
			String line = null;
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
				avgWspd.put(dateRange[i], meanWspd);
			}
		}
		return avgWspd;
	}

	public HashMap getAvgGust(String[] bouyData) throws Exception {
		String rawData = bouyData[0];
		HashMap<String, Double> avgGust = new HashMap<String, Double>();

		for (int i=0;i<dateRange.length;i++) {
			double meanGust=0.0;
			double sumGust=0.0;
			double cnt=0.0;
			String line = null;
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
				avgGust.put(dateRange[i], meanGust);
			}
		}
		return avgGust;
	}

	public HashMap getAvgWvht(String[] bouyData) throws Exception {
		String rawData = bouyData[0];
		HashMap<String, Double> avgWvht = new HashMap<String, Double>();

		for (int i=0;i<dateRange.length;i++) {
			double meanWvht=0.0;
			double sumWvht=0.0;
			double cnt=0.0;
			String line = null;
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
				avgWvht.put(dateRange[i], meanWvht);
			}
		}
		return avgWvht;
	}

	public HashMap getAvgPres(String[] bouyData) throws Exception {
		String rawData = bouyData[0];
		HashMap<String, Double> avgBar = new HashMap<String, Double>();

		for (int i=0;i<dateRange.length;i++) {
			double meanBar=0.0;
			double sumBar=0.0;
			double cnt=0.0;
			String line = null;
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
				avgBar.put(dateRange[i], meanBar);
			}
		}
		return avgBar;
	}


	public String generateReport(HashMap wspd, HashMap gust, HashMap wvht, HashMap pres) {
		StringBuilder results = new StringBuilder();
		String horFrame = "+--------------------------------------------+\n";
		results.append(horFrame);
		results.append("|          NDBC ID " + id + " Report              |\n");
		results.append(horFrame);
		results.append("|Date|Avg. Wspd|Avg. Gust|Avg. Wvht|Avg. Pres|\n");
		results.append(horFrame);
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
			results.append("|8-"+ dateRange[i] + "|" +  wsPad + "|" + gsPad + "|" +
				                wvPad + "|" + psPad + "|\n");
			results.append(horFrame);
		}
		String finalResults = results.toString();
		return finalResults;
	}

}
