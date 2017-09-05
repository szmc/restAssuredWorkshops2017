package workshops.exercises;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class Authentication {

	String url = "https://api.trello.com/1";
	String apiKey = "";
	String token = "";

	/**
	 * Example: login with credentials
	 * 1) Populate parameters and post methods with proper values
	 * 2) Comment out header and print response
	 */
	public Response loginWithCredentials(String username, String password) {
		return  given()
				.baseUri(url)
				.header("", "")
				.formParam("", "")
				.formParam("", "")
				.param("", "")
				.when().post("");
	}

	/** Example: testing the method
	 * 3) Check if status code is ok for valid credentials
	 * 4) Print the json response
	 * 5) Print value of selected field from json response
	 */
	@Test
	public void ExampleTest() {
		loginWithCredentials("", "").then().statusCode(200);
		loginWithCredentials("", "").prettyPrint();
		System.out.println(loginWithCredentials("", "").jsonPath().get(""));
	}

	/**Exercise: login with api key method
	 * 1) Add parameter key with proper value
	 * 2) Add parameter token with proper value
	 * 3) Add endpoint /Members/me
	 */

	public Response authenticateWithApiKeyAndToken(String apiKey, String token) {
		//Todo: Add proper parameters for baseUri and get methods. Add proper values for key and token fields.
		return given()
				.baseUri("")
				.param( "key", "")
				.param("token", "")
				.when().get("");
	}

	/**Exercise: login with api key testing method
	 * 4) Add positive scenario: check if code 200 is returned when key and token are valid
	 * 5) Add negative scenario: check if code 401 is returned when key and token are invalid
	 */

	@Test
	public void authenticateWithApiTest() {
		//Todo: Add authenticateWithApiKeyAndToken method with proper parameters and assertions use
	}

	/**Exercise:
	 * Write request specification that will handle common parameters for given methods.
	 *
	 */

	public RequestSpecification requestSpecification(){
		return given();
	}

	@Test
	public void displayDetailsAboutUser() {
		//ToDo: test request specification here.
		// Use it in get method for/Members/me endpoint and print it with prettyPrint method
		// Use spec method to handle request Specification
	}
}
