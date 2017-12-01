/* JsonParserMain.java
 * Date 2017-11-23 by Per Sundberg
 */

package json.api.parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Class JsonParser gets a url with as json and displays it as test.
 * 
 * @author Per Sundberg
 *
 */
class JsonParser {

	/**
	 * Constructor
	 */
	public JsonParser() {
	}

	/**
	 * Method getUrl that fetches Json from web and return data. 
	 * Inparameter: -
	 * Return value: url
	 */
	URL getUrl() {
		URL data = null;
		try {
			// https://github.com/toddmotto/public-apis
			data = new URL("https://dog.ceo/api/breeds/image/random");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Method getTokener that get token from url-data. 
	 * Inparameter: url 
	 * Return value: tokener
	 */
	JSONTokener getTokener(URL url) {
		JSONTokener tokener = null;
		try {
			tokener = new JSONTokener(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tokener;
	}

	/**
	 * Method displayJson that fetches tokener and displays result. 
	 * Inparameter: tokener 
	 * Return value: -
	 */
	String displayJson(JSONTokener tokener) {
		JSONObject obj = new JSONObject(tokener);
		// JSONObject data = obj.getJSONObject("user");
		// String message = data.getString("message");
		System.out.println(obj.get("message"));
		return (String) obj.get("message");
	}

	/**
	 * Method parse that is the main function of class JsonParser. 
	 * Inparameter: -
	 * Return value: -
	 */
	public void parse() {
		URL url = getUrl();
		JSONTokener tokener = getTokener(url);
		displayJson(tokener);
	}
}

/**
 * Class JsonParserMain that starts the program.
 * 
 * @author Per Sundberg
 *
 */
public class JsonParserMain {
	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		parser.parse();
	}
}
