package workshops.answers;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class GetRequests {

	Authentication authentication = new Authentication();


	/** Exercise 1 Boards
	 * 1) Create get request for /members/me/boards endpoint
	 * 2) Create method that will return id of chosen board taking board name as a parameter
	 * 3) Display permision level for choosen board
	 */


	public Response displayBoards() {
		Response response = given()
				.spec(authentication.authenticationSpecification())
				.when().get("/members/me/boards");
		return response;
	}

	@Test
	public void jsonTest() {
		Response response = displayBoards();
		System.out.println("TUTAJ" +response.jsonPath().get("/*[?(@name='Agile Automation app')]/id"));
	}
	@Test
	public void displayBoardDetailsTest() {
		displayBoards().prettyPrint();
	}

	@Test
	public void displayPermissionLevelTest() {
		System.out.println(displayBoards().jsonPath().get("prefs.permissionLevel[0]"));
	}

	@Test
	public void displayBoardIdTest() {
		System.out.println(getBoardId("Agile Automation app"));
	}

	public String getBoardId(String boardName) {

		Response response = displayBoards();

		int i = 0;
		while (!response.jsonPath().getString("name[" + String.valueOf(i) + "]").equals(boardName)) {
			i++;
		}
		return response.jsonPath().getString("id[" + String.valueOf(i) + "]");
	}

	/**
	 * Exercise 4 Cards
	 * 1) Display Card
	 * 2) Display id of Card using card name
	 */

	public Response getCards(String boardName) {
		return given()
				.spec(authentication.authenticationSpecification())
				.when().get("/boards/"+getBoardId(boardName)+"/cards");
	}

	public String getCardId(String cardName, String boardName) {
		Response response = getCards(boardName);
		int i = 0;
		while (!response.jsonPath().getString("name[" + String.valueOf(i) + "]").equals(cardName)) {
			i++;
		}
		return response.jsonPath().getString("id[" + String.valueOf(i) + "]");
	}

	@Test
	public void displayCards() {
		getCards("Agile Automation app").prettyPrint();
	}

	@Test
	public void displayCardId() {
		System.out.println(getCardId("Cookies", "Agile Automation app"));
	}

	/**Exercise 5 Lists
	 * Display list
	 * Display list id by list name
	 */

	public Response getLists(String boardName) {
		return given()
				.spec(authentication.authenticationSpecification())
				.when().get("/boards/"+getBoardId(boardName)+"/lists");
	} //"Agile Automation app"

	public String getListId(String listName, String boardName) {
		Response response = getLists(boardName);
		int i = 0;
		while (!response.jsonPath().getString("name[" + String.valueOf(i) + "]").equals(listName)) {
			i++;
		}
		return response.jsonPath().getString("id[" + String.valueOf(i) + "]");
	}

	@Test
	public void displayLists() {
		getLists("Agile Automation app").prettyPrint();
	}

	@Test
	public void displayListsId() {
		System.out.println(getListId("To Do", "Agile Automation app"));
	}
}
