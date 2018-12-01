package be.vyncke.webfront;

import be.vyncke.webfront.pages.NieuwPersoneelPage;
import be.vyncke.webfront.pages.PersoneelDetailsPage;
import be.vyncke.webfront.pages.PersoneelPage;
import be.vyncke.webfront.drivers.VynckeWebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class StepDefinitions {

	WebDriver driver = VynckeWebDriver.getDriver();

	PersoneelPage personeelPage = new PersoneelPage();
	NieuwPersoneelPage nieuwPersoneelPage = new NieuwPersoneelPage();
	PersoneelDetailsPage personeelDetailsPage = new PersoneelDetailsPage();

	class LabelData {
		String label;
		String data;
	}

	// *******Feature: Add staff member*******
	// Scenario: Add one staff member
	@Given("^I am on the page where I can introduce a new staff member$")
	public void i_am_on_the_page_where_I_can_introduce_a_new_staff_member() throws Throwable {
		driver.get("http://localhost:8080/personeel.html");
		//driver.navigate().to("http://localhost:8080/personeel.html");
	}

	@When("^I press the nieuw button$")
	public void i_press_the_nieuw_button() throws Throwable {
		personeelPage.clickNieuwButton();
	}

	@When("^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
	public void i_enter_in_the_field(String enteredText, String fieldName) throws Throwable {
		nieuwPersoneelPage.waitUntilLoaded();
		nieuwPersoneelPage.fillFormFieldByFieldNameAndText(fieldName, enteredText);
	}

	@When("^I press on the verkoper button$")
	public void i_press_on_the_verkoper_button() throws Throwable {
		nieuwPersoneelPage.clickVerkoperButton();
	}


	@Then("^I should see \"([^\"]*)\" at the bottom of the staff page$")
	public void i_should_see_at_the_bottom_of_the_staff_page(String memberName) throws Throwable {
		personeelPage.waitUntilLoaded();

		Assert.assertTrue("Did not find this text: "+memberName+"\n",
				personeelPage.getBodyText().contains(memberName));
	}

	// Scenario: Verify the details of the newly added staff member
	@Given("^The list of all staff members is shown$")
	public void the_list_of_all_staff_members_is_shown(){
		driver.get("http://localhost:8080/personeel.html");

	}

	@When("^I click the details button of the new member \"([^\"]*)\"$")
	public void i_click_the_details_button_of_the_new_member(String newMemberName) throws Throwable {
		personeelPage.waitUntilLoaded();
		personeelPage.navigateToDetailsOfPersoneel(newMemberName);
	}


	@Then("^I should see a the following on screen$")
	public void i_should_see_a_the_following_on_screen(List<LabelData> checklist) throws Throwable {
		personeelDetailsPage.waitUntilLoaded();

		String bodyText = personeelPage.getBodyText();

		for (LabelData ld: checklist){
			String text2bFound = ld.label;
			Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));
			text2bFound = ld.data;
			Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));

		}
	}

	// *******Feature: Remove staff member*******
	// Scenario: Go to details page of the member I want to delete
	@Given("^I am on the page where I can see all the staff members$")
	public void i_am_on_the_page_where_I_can_see_all_the_staff_members() throws Throwable {
		driver.get("http://localhost:8080/personeel.html");
	}

	@When("^I press the details button of the member \"([^\"]*)\" that I want to remove$")
	public void i_press_the_details_button_of_the_member_that_I_want_to_remove(String personeelName) throws Throwable {
		personeelPage.navigateToDetailsOfPersoneel(personeelName);
		personeelDetailsPage.waitUntilLoaded();
	}

	/*@Then("^I should see a the following on screen$")
	public void i_should_see_a_the_following_on_screen(List<LabelData> checklist) throws Throwable {
		personeelDetailsPage.waitUntilLoaded();

		String bodyText = personeelPage.getBodyText();

		for (LabelData ld: checklist){
			String text2bFound = ld.label;
			Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));
			text2bFound = ld.data;
			Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));

		}
	}*/

	// Scenario: Remove the staff member show on the screen
	@Given("^I am on the details page of the member$")
	public void i_am_on_the_details_page_of_the_member() throws Throwable {
		String bodyText = personeelDetailsPage.getBodyText();
		Assert.assertTrue("Did not find this text: "+"Details"+"\n",bodyText.contains("Details"));
	}

	@When("^I click the delete button$")
	public void i_click_the_delete_button() throws Throwable {
		personeelDetailsPage.clickDeleteButton();
	}

	@Then("^I should see the personeel page$")
	public void i_should_see_the_personeel_page() throws Throwable {
		personeelPage.waitUntilLoaded();

		Assert.assertTrue("Did not navigate to personeel page this text: \n",
				personeelPage.getBodyText().contains("Personeel"));
	}

	@Then("^The member I removed \"([^\"]*)\" should not be visible$")
	public void the_member_I_removed_should_not_be_visible(String removedMember) throws Throwable {
		Assert.assertFalse("The member is not removed\n",
				personeelPage.getBodyText().contains(removedMember));
	}

	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.quit();
	}

}
