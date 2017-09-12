package workshops.exercises;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import sun.security.krb5.internal.AuthorizationDataEntry;

import static com.jayway.restassured.RestAssured.given;

public class GetRequests {
	Authentication authentication = new Authentication();

	/** Exercise 1 Boards
	 * 1) Create get request for /members/me/boards endpoint
	 * 2) Create method that will return id of chosen board taking board name as a parameter
	 * 3) Display permision level for choosen board
	 */


	public void displayBoards() {
		//ToDo: add authenticatcion, add endpoint change this method to return Response type
		 		given()
				.when().get("");

	}

	@Test
	public void displayBoardDetailsTest() {
		//ToDo: call displayBoards with prettyPrint() method here

	}

	@Test
	public void displayPermissionLevelTest() {
		//ToDo: call displayBoards with jsonPath.get("parent_node.child_node[order of parent node]" method here)
	}

	@Test
	public void displayBoardIdTest() {
		System.out.println(getBoardId("Agile Automation app"));
	}

	public String getBoardId(String boardName) {

		//ToDo:  Use displayBoard method to initiate response variable. Replace variable1 and variable2 with proper node names.
		Response response = null;
		int i = 0;
		while (!response.jsonPath().getString("variable1[" + String.valueOf(i) + "]").equals(boardName)) {
			i++;
		}
		return response.jsonPath().getString("variable2[" + String.valueOf(i) + "]");
	}

	/**
	 * Exercise 4 Cards
	 * 1) Display Card
	 * 2) Display id of Card using card name
	 */

	public Response getCards(String boardName) {
		//ToDo: add endpoint /boards/{$boardId}/cards. Hint: boardId can be taken from getBoardId method.
		return given()
				.spec(authentication.requestSpecification())
				.when().get("");
	}

	public String getCardId(String cardName, String boardName) {
		//ToDo:  Use proper method to initiate response variable. Replace variable1 and variable2 with proper node names.
		Response response = null;
		int i = 0;
		while (!response.jsonPath().getString("variable1[" + String.valueOf(i) + "]").equals(cardName)) {
			i++;
		}
		return response.jsonPath().getString("variable2[" + String.valueOf(i) + "]");
	}

	@Test
	public void displayCards() {
		//ToDo: test getCards and getCardId methods
	}


	/**Exercise 5 Lists
	 * Display list
	 * Display list id by list name
	 */

	//ToDo: Create getList(), getListId() methods with proper parameters. Use endpoint: "/boards/"+getBoardId(boardName)+"/lists"
	//Hint: You might need 2 parameters in getListId method
}
