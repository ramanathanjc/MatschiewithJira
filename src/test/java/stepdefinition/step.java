package stepdefinition;

import java.io.File;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class step extends common {

	@When("Create New Ticket with string body {string}")
	public void create_new_ticket_with_string_body(String body) {

		input = RestAssured.given().contentType("application/json").when().body(body);
		response = input.post();
		response.prettyPrint();

		// get the ticket id
		ticket_id = response.jsonPath().get("id");
		System.out.println("Created Ticket ID is :" + ticket_id);

	}

	@When("update the issue with file {string}")
	public void update_the_issue_with_file(String filename) {

		File updatefile = new File("./src/test/resources/" + filename);
		
		input = RestAssured.given().contentType("application/json").when().body(updatefile);
		response = input.put("/"+ ticket_id);
		
	}
	
	@When("verify the update details")
	public void get_the_current_ticket_details() {
	    input = RestAssured.given();
	    response = input.get("/"+ticket_id);
		desp = response.jsonPath().get("fields.description");
		System.out.println("updated description details is ==== "+desp);
		
	}
	
	@When("delete the ticket")
	public void delete_the_ticket() {
	   
		input =RestAssured.given();
		response = input.delete("/"+ticket_id);
		
		System.out.println("Deleted Ticket number is " +ticket_id);
	}
	
	@Then("Validate the status code as {int}")
	public void validate_the_status_code_as(Integer statusCode) {

		response.then().assertThat().statusCode(statusCode);

	}

}
