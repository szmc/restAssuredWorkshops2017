package workshops.exercises;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import workshops.answers.Authentication;
import workshops.answers.GetRequests;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by szymonr on 01/09/17.
 */
public class PostRequests {
	/**
	 * Exercise 1: Create new Board.
	 *
	 */

	public Response createBoard(String boardName) {
		return given()
				.queryParam("", "")
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

	Response createCard(String cardName, String boardName) {
		return given()
				.queryParam("", "")
				.when().post("");
	}

	@Test
	public void createCardTest() {
		//ToDo: use createCard method here
	}

	/**\
	 * Exercise 3: Create new list
	 *
	 */
	Response createList(String listName, String boardName) {
		return given()
				.queryParam("", "")
				.when().post("");
	}

	@Test
	public void createListTest() {
		//Todo: use createList method here
	}
}
