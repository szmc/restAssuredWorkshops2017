package workshops.exercises;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import workshops.answers.Authentication;
import workshops.answers.GetRequests;

import static com.jayway.restassured.RestAssured.given;

public class PostRequests {
	/**
	 * Exercise 1: Create new Board.
	 *
	 */

	public Response createBoard(String boardName) {
		//ToDo: add authentication and proper parameters.
		// Hint: use trello documentation to check endpoint details.
		return given()
				.param("", "")
				.when().post("");
	}

	@Test
	public void createBoardTest() {
		//ToDo: use createBoard method here
	}

	/**
	 * Exercise 2: Create new card on board
	 *
	 */

	//ToDo: create and test createCard method.
	//Hint: use trello documentation. You might need 2 arguments for createCard method.


	/**\
	 * Exercise 3: Create new list
	 *
	 */

	//ToDo: create and test createList method.
	//Hint: use trello documentation and use 2 arguments

}
