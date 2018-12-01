Feature: Add Staff member

It should be possible to add a staff member to the staff
Just after adding the staff, the list of all the staff should be shown
After the list is shown again, the new staff member first name, last name and function should be visible

Scenario: Add one staff member
Given I am on the page where I can introduce a new staff member
When I press the nieuw button
  And I enter "Husein" in the "voornaam" field
  And I enter "Kasem" in the "naam" field
  And I enter "husein.kasem.90@gmail.com" in the "email" field
  And I enter "111" in the "passwoord" field
  And I press on the verkoper button
Then I should see "Husein Kasem" at the bottom of the staff page

Scenario: Verify the details of the newly added staff member
Given The list of all staff members is shown
When I click the details button of the new member "Husein Kasem"
Then I should see a the following on screen
  | label        | data                      |
  | Naam:        | Kasem                     |
  | Voornaam:    | Husein                    |
  | E-mail:      | husein.kasem.90@gmail.com |
  | Functie:     | Verkoper                  |