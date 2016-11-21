import java.io.*;
import java.net.*;

public class BouyCalc {
	public static void main(String[] args) throws Exception {
		StringBuilder results = new StringBuilder();
		System.out.println("Fetching data for bouy 42001...");
		URL url = new URL("http://www.ndbc.noaa.gov/view_text_file.php?" +
				          "filename=42001h2005.txt.gz&dir=data/historical/stdmet/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		int cnt = 1;
		while ((line = rd.readLine()) != null) {
			String readData[] = line.split(" ");
			//System.out.println(readData[1]);
			if (readData[1].equals("08")) {
				results.append(line);
				System.out.println(results);
			}
			cnt++;
		}
		rd.close();
		System.out.println(line);
		System.out.println("Feteched " + cnt + " lines");
	}
}
