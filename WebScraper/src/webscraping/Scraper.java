package webscraping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * This is the static Scraper class that will be used to scrape pages
 * 
 * @author Dylan Watts
 * @version 0.2
 *
 */
public final class Scraper {

	private static URL url;
	private static String content;
	private static boolean success = true;
	
	/**
	 * Resets the variables used to allow another scrape
	 */
	public static void reset() {
		Scraper.url = null;
		Scraper.content = null;
		Scraper.success = true;
	}
	
	/**
	 * Assigns the URL
	 * @param targetURL - The URL of the web page
	 */
	public static void setURL(String targetURL) {
		try {
			Scraper.url = new URL(targetURL);
		} catch (Exception e) {
			Scraper.success = false;
		}
	}
	
	/**
	 * Performs scrape on the web page and returns true if successful
	 * @return Scraper.success
	 */
	public static boolean scrape() {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			int responseCode = conn.getResponseCode();
			System.out.println("Response Code: " + responseCode);
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			Scraper.content = response.toString();
			Scraper.clean();
		} catch (Exception e) {
			e.printStackTrace();
			Scraper.success = false;
		}
		return Scraper.success;
	}
	
	/**
	 * Cleans the content to make it more readable
	 */
	public static void clean() {
		Scraper.content = Scraper.content.replace(">", ">\n");
	}
	
	/**
	 * Getter for the web page's content
	 * @return Scraper.content
	 */
	public static String getContent() {
		return Scraper.content;
	}
	
	/**
	 * Conditional for whether scrape was successful
	 * @return Scraper.success
	 */
	public static boolean isSuccessful() {
		return Scraper.success;
	}
	
}
