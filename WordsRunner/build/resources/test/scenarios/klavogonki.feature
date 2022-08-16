Feature: Bot for the site klavagonki

  Background: Go to the home page of the site
    Given Open the link "https://klavogonki.ru/go?type=normal"

    Scenario: Bot launches the game and insert words
      When Start the game
      And Waiting for start
      And Insert highlight word in circle
      Then Game complete and symbols more than 1500


