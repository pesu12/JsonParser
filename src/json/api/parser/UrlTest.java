package json.api.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;

import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

class UrlTest {

	@Test
	void test() {
		JsonParser test = new JsonParser();
		URL url = test.getUrl();
		String output = url.toString();
		assertEquals("https://dog.ceo/api/breeds/image/random", output);

		JSONTokener token = test.getTokener(url);
		String output2 = token.toString();
		assertEquals(" at 0 [character 1 line 1]", output2);

		String output3 = test.displayJson(token).substring(0, 24);
		assertEquals("https://dog.ceo/api/img/", output3);
	}
}
