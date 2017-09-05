package workshops.answers;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class PutRequests {

	public GetRequests getRequests = new GetRequests();
	Authentication authentication = new Authentication();


	public Response changeCardName(String oldCardName, String newCardName, String boardName) {
		return given()
				.spec(authentication.authenticationSpecification())
				//.baseUri(url)
				//.queryParam("key", apiKey)
				//.queryParam("token", token)
				.queryParam("name", newCardName)
				.when()
				.put("/cards/"+getRequests.getCardId(oldCardName, boardName));
	}

	@Test
	public void changeCardNameTest() {
		changeCardName("Cookies", "Cookies updated", "Agile Automation app");
	}


	public Response moveCardToOtherList(String cardName, String listId, String boardName) {
		return given()
				.spec(authentication.authenticationSpecification())
				//.baseUri(url)
				//.queryParam("key", apiKey)
				//.queryParam("token", token)
				.queryParam("idList", listId)
				.when()
				.put("/cards/"+getRequests.getCardId(cardName, boardName));
	}

	@Test
	public void moveCardToOtherListTest() {
		moveCardToOtherList("Cookies updated", getRequests.getListId("To Do", "Agile Automation app"), "Agile Automation app");
	}

}
