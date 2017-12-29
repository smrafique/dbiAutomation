Feature: International Site: Contact Pages should have title..
  As an international site my Contact Pages should have page titles

  @Smoke
  Scenario: CA site's My Contact Page should have title
    Given User Open any browser
    And User goes to canadian David's Bridal home page
    When User scroll down to bottom of the page and click on the *Contact Us* link on the Footer section
    Then User verify the page title is Contact Us
    And user closes the browser
  @Smoke
  Scenario: UK site's My Contact Page should have title
    Given User Open any browser
    And User goes to UK David's Bridal home page
    When User scroll down to bottom of the page and click on the *Contact Us* link on the Footer section
    Then User verify the page title is Contact Us
    And user closes the browser