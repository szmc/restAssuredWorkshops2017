package workshops.answers;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import workshops.answers.GetRequests;

import static com.jayway.restassured.RestAssured.authentication;
import static com.jayway.restassured.RestAssured.given;

/**
 * Created by szymonr on 01/09/17.
 */
public class PostRequests {

	public GetRequests getRequests = new GetRequests();

	public Authentication authentication = new Authentication();

	/**
	 * Excercise 1: Create new Board
	 *
	 */

	public Response createBoard(String boardName) {
		return given()
				.spec(authentication.postRequestSpecification())
				.queryParam("name", boardName)
				.when().post("/boards/");
	}

	/**
	 *
	 * Create card
	 *
	 */

	public Response createCard(String cardName, String boardName) {
		return given()
				.spec(authentication.postRequestSpecification())
				.queryParam("name", cardName)
				.queryParam("idList", getRequests.getListId("To Do", boardName))
				.when().post("/cards/");
	}

	@Test
	public void createCardTest() {
		createCard("Testowa karta", "Agile Automation app");
	}
	/**
	 * Create list
	 *
	 */

	Response createList(String listName, String boardName) {
		return given()
				.spec(authentication.postRequestSpecification())
				.queryParam("name", listName)
				.queryParam("idBoard", getRequests.getBoardId(boardName))
				.when().post("/lists/");
	}

	@Test
	public void createListTest() {
		createList("Testowa lista", "Agile Automation app");
	}

	/**
	 * Exercise: json as body
	 *
	 */

}
