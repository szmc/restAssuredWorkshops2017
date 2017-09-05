package workshops.exercises;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class PutRequests {

	/**
	 * Exercise 1: create a method to change cardName
	 *
	 */
	public Response changeCardName(String oldCardName, String newCardName, String boardName) {
		return given()
				.queryParam("", "")
				.when()
				.put("");
	}

	@Test
	public void changeCardNameTest() {
		//ToDo: test changeCardName method here
	}

	/**
	 * Exercise 2: create a method to move card to other list;
	 *
	 */
	public Response moveCardToOtherList(String cardName, String listId, String boardName) {
		return given()
				.queryParam("", "")
				.when()
				.put("");
	}

	@Test
	public void moveCardToOtherListTest() {
		//ToDo: test moveCardToOtherList method here;
	}

}
