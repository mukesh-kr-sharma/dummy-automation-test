Feature: Careers

  @Test
  Scenario Outline: Test Numadics careers page
    Given I open page "<URL>"
    Then I verify header "<Header>"
    Then I select job type "Internship" from "Job type" dropdown
    And I verify message "<Message>"
    Then I select job type "Full time" from "Job type" dropdown
    Then I click on job "QA Engineer"
    And I verify page URL "<RedirectURL>"
    And I validate button "Apply here now" in "QA Engineer" page
    Then I click on button "Apply here now" in "QA Engineer" page
    And It gets redirected to "Careers" page
    Then I hover over "QA Engineer" job and click on "Apply" button
    Then I validate all fields in "Personal Details" section

    Examples:
      | URL | Header  | Message | RedirectURL |
      | https://numadic.com/careers/  | JOIN OUR CREW  | There are no available job positions that match your filters. |  https://numadic.com/careers/qa-engineer.php |