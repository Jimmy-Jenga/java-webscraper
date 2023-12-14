package webscraping;

/**
 * 
 * The Webpage class is used for storing information about the scraped page
 * 
 * @author Dylan Watts
 * @version 0.2
 *
 */
public class Webpage {

	private String url;
	private String content;
	
	
	/**
	 * This constructor assigns the variables and calls {@link Scraper} to scrape the page
	 * @param targetURL - The URL of the page to be scraped
	 */
	public Webpage(String targetURL) {
		url = targetURL;
		Scraper.setURL(url);
		if (Scraper.scrape()) {
			content = Scraper.getContent();
		} else {
			content = "";
		}
	}
	
	/**
	 * Getter for the URL of the web page
	 * @return url
	 */
	public String getURL() {
		return url;
	}
	
	/**
	 * Getter for the content of the web page
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	
}
