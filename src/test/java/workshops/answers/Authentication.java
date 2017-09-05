package workshops.answers;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class Authentication {

	String url = "https://api.trello.com/1";
	String apiKey = "34aa950d53d686b21bfd7d8c35b56e3a";
	String token = "a90c6bcbdc3373442314f8db4e1bfe93416d0e2e636c643771d74458118f1ae5";

	/**
	 * Excercise 1: login with credentials
	 * @param username
	 * @param password
	 * @return response
	 * 1) Populate parameters and post methods with proper values
	 * 2) Test method with valid and invalid values
	 * 3) Print response using prettyPrint method
	 * 4) Print code field from response using jsonPath.get() method
	 * 5) comment out header method in response and print the output using prettyPrint method.
	 */
	public Response loginWithCredentials(String username, String password) {
		return  given()
				.baseUri(url)
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("factors[user]", username)
				.formParam("factors[password]", password)
				.param("method", "password")
				.when().post("/authentication");
	}

	/** Excercise 1 test
	 * 3) Print response
	 * 4) Print code field frome response
	 */
	@Test
	public void Exercise1Test() {
		loginWithCredentials("", "").jsonPath().get("code");
		//ToDo: positive and negative scenario, print response, print code field, print response with header commented out.
	}

	/**Excercise 2 login with api key
	 * 1) Add parameter key with proper value
	 * 2) Add parameter token with proper value
	 * 3) Add endpoint /Members/me
	 * 4) Test method positive and negative scenario(200, 401)
	 * 5) Print the response using prettyPrint method
	 */

	public Response authenticateWithApiKeyAndToken(String apiKey, String token) {
		return given()
				.baseUri(url)
				.param( "key", apiKey)
				.param("token", token)
				.when().get("/Members/me");
	}

	@Test
	public void authenticateWithApiTest() {
		//ToDo: test authenticateWithApiKeyAndToken method here
	}

	/**
	 * Exercise 3
	 * Use specification builder to not repeat yourself (url, apiKey, token)
	 *
	 */

	public RequestSpecification authenticationSpecification(){
		return given().baseUri(url)
				.param( "key", apiKey)
				.param("token", token);
	}

	public RequestSpecification postRequestSpecification() {
		return given().baseUri(url)
				.accept("")
				.queryParam( "key", apiKey)
				.queryParam("token", token);
	}

}
