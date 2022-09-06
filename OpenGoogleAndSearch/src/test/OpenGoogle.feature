Feature: OpenSite
  Background: I'm on the site
    Given Open site "https://ek.ua/"

    Scenario: Input test and click on the button search
    When We on the site
    And Click the button
    Then See to the result