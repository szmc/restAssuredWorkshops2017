package workshops.answers;

import org.testng.annotations.Test;

public class End2EndTests {

	GetRequests getRequests = new GetRequests();

	PostRequests postRequests = new PostRequests();

	PutRequests putRequests = new PutRequests();

	String boardName = "End2EndBoardName2";
	String cardName1 = "Card name 1";
	String cardName2 = "Card name 2";
	String cardName3 = "Card name 3";
	String cardName4 = "Card name 4";
	String cardName5 = "Card name 5";
	String cardName6 = "Card name 6";

	String listName = "New list for my items";

	@Test
	public void end2endTest() {
		postRequests.createBoard(boardName).prettyPrint();
		postRequests.createCard(cardName1, boardName);
		postRequests.createCard(cardName2, boardName);
		postRequests.createCard(cardName3, boardName);
		postRequests.createCard(cardName4, boardName);
		postRequests.createCard(cardName5, boardName);
		postRequests.createCard(cardName6, boardName);
		postRequests.createList(listName, boardName);
		putRequests.changeCardName(cardName1, "card name 1 updated", boardName);
		putRequests.moveCardToOtherList(cardName2, getRequests.getListId(listName, boardName), boardName);
		putRequests.moveCardToOtherList(cardName3, getRequests.getListId("Doing", boardName), boardName).then().statusCode(200);
		putRequests.moveCardToOtherList(cardName4, getRequests.getListId("Doing", boardName), boardName).then().statusCode(200);
		putRequests.moveCardToOtherList(cardName3, getRequests.getListId("Done", boardName), boardName).then().statusCode(200);
		putRequests.moveCardToOtherList(cardName4, getRequests.getListId("Done", boardName), boardName).then().statusCode(200);
	}


}
