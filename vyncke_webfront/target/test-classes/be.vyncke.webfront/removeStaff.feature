Feature: Remove staff member

It should be possible to remove a staff member
Just after deleting the staff member, the list of all the staff should be shown
After the list is shown, the removed staff member first name, last name and function should not be visible

Scenario: Go to details page of the member I want to delete
Given I am on the page where I can see all the staff members
When I press the details button of the member "Husein Kasem" that I want to remove
Then I should see a the following on screen
  | label        | data                      |
  | Naam:        | Kasem                     |
  | Voornaam:    | Husein                    |
  | E-mail:      | husein.kasem.90@gmail.com |
  | Functie:     | Verkoper                  |

Scenario: Remove the staff member show on the screen
Given I am on the details page of the member
When I click the delete button
Then I should see the personeel page
And The member I removed "Husein Kasem" should not be visible
And I close the browser