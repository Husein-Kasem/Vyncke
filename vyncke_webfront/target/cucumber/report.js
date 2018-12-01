$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("addStaff.feature");
formatter.feature({
  "line": 1,
  "name": "Add Staff member",
  "description": "\nIt should be possible to add a staff member to the staff\nJust after adding the staff, the list of all the staff should be shown\nAfter the list is shown again, the new staff member first name, last name and function should be visible",
  "id": "add-staff-member",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "Add one staff member",
  "description": "",
  "id": "add-staff-member;add-one-staff-member",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I am on the page where I can introduce a new staff member",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I press the nieuw button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I enter \"Husein\" in the \"voornaam\" field",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"Kasem\" in the \"naam\" field",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I enter \"husein.kasem.90@gmail.com\" in the \"email\" field",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I enter \"111\" in the \"passwoord\" field",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I press on the verkoper button",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I should see \"Husein Kasem\" at the bottom of the staff page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_on_the_page_where_I_can_introduce_a_new_staff_member()"
});
formatter.result({
  "duration": 10341488024,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_press_the_nieuw_button()"
});
formatter.result({
  "duration": 399616362,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Husein",
      "offset": 9
    },
    {
      "val": "voornaam",
      "offset": 25
    }
  ],
  "location": "StepDefinitions.i_enter_in_the_field(String,String)"
});
formatter.result({
  "duration": 182597579,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Kasem",
      "offset": 9
    },
    {
      "val": "naam",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.i_enter_in_the_field(String,String)"
});
formatter.result({
  "duration": 143094374,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "husein.kasem.90@gmail.com",
      "offset": 9
    },
    {
      "val": "email",
      "offset": 44
    }
  ],
  "location": "StepDefinitions.i_enter_in_the_field(String,String)"
});
formatter.result({
  "duration": 154506019,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "111",
      "offset": 9
    },
    {
      "val": "passwoord",
      "offset": 22
    }
  ],
  "location": "StepDefinitions.i_enter_in_the_field(String,String)"
});
formatter.result({
  "duration": 97537257,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_press_on_the_verkoper_button()"
});
formatter.result({
  "duration": 578529184,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Husein Kasem",
      "offset": 14
    }
  ],
  "location": "StepDefinitions.i_should_see_at_the_bottom_of_the_staff_page(String)"
});
formatter.result({
  "duration": 320000308,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verify the details of the newly added staff member",
  "description": "",
  "id": "add-staff-member;verify-the-details-of-the-newly-added-staff-member",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "The list of all staff members is shown",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I click the details button of the new member \"Husein Kasem\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I should see a the following on screen",
  "rows": [
    {
      "cells": [
        "label",
        "data"
      ],
      "line": 21
    },
    {
      "cells": [
        "Naam:",
        "Kasem"
      ],
      "line": 22
    },
    {
      "cells": [
        "Voornaam:",
        "Husein"
      ],
      "line": 23
    },
    {
      "cells": [
        "E-mail:",
        "husein.kasem.90@gmail.com"
      ],
      "line": 24
    },
    {
      "cells": [
        "Functie:",
        "Verkoper"
      ],
      "line": 25
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.the_list_of_all_staff_members_is_shown()"
});
formatter.result({
  "duration": 596769631,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Husein Kasem",
      "offset": 46
    }
  ],
  "location": "StepDefinitions.i_click_the_details_button_of_the_new_member(String)"
});
formatter.result({
  "duration": 354465023,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_see_a_the_following_on_screen(StepDefinitions$LabelData\u003e)"
});
formatter.result({
  "duration": 197727714,
  "status": "passed"
});
formatter.uri("removeStaff.feature");
formatter.feature({
  "line": 1,
  "name": "Remove staff member",
  "description": "\nIt should be possible to remove a staff member\nJust after deleting the staff member, the list of all the staff should be shown\nAfter the list is shown, the removed staff member first name, last name and function should not be visible",
  "id": "remove-staff-member",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "Go to details page of the member I want to delete",
  "description": "",
  "id": "remove-staff-member;go-to-details-page-of-the-member-i-want-to-delete",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I am on the page where I can see all the staff members",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I press the details button of the member \"Husein Kasem\" that I want to remove",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I should see a the following on screen",
  "rows": [
    {
      "cells": [
        "label",
        "data"
      ],
      "line": 11
    },
    {
      "cells": [
        "Naam:",
        "Kasem"
      ],
      "line": 12
    },
    {
      "cells": [
        "Voornaam:",
        "Husein"
      ],
      "line": 13
    },
    {
      "cells": [
        "E-mail:",
        "husein.kasem.90@gmail.com"
      ],
      "line": 14
    },
    {
      "cells": [
        "Functie:",
        "Verkoper"
      ],
      "line": 15
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_on_the_page_where_I_can_see_all_the_staff_members()"
});
formatter.result({
  "duration": 371619158,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Husein Kasem",
      "offset": 42
    }
  ],
  "location": "StepDefinitions.i_press_the_details_button_of_the_member_that_I_want_to_remove(String)"
});
formatter.result({
  "duration": 441099078,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_see_a_the_following_on_screen(StepDefinitions$LabelData\u003e)"
});
formatter.result({
  "duration": 201811892,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Remove the staff member show on the screen",
  "description": "",
  "id": "remove-staff-member;remove-the-staff-member-show-on-the-screen",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I am on the details page of the member",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I click the delete button",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I should see the personeel page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "The member I removed \"Husein Kasem\" should not be visible",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.i_am_on_the_details_page_of_the_member()"
});
formatter.result({
  "duration": 139067395,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_click_the_delete_button()"
});
formatter.result({
  "duration": 502850642,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_see_the_personeel_page()"
});
formatter.result({
  "duration": 275253768,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Husein Kasem",
      "offset": 22
    }
  ],
  "location": "StepDefinitions.the_member_I_removed_should_not_be_visible(String)"
});
formatter.result({
  "duration": 195277402,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_close_the_browser()"
});
formatter.result({
  "duration": 1647841764,
  "status": "passed"
});
});