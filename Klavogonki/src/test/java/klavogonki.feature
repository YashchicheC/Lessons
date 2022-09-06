Feature: Bot

  Background: Go to main scene
    Given Open site "https://klavogonki.ru/go?type=normal"

    Scenario: Start the game and input words
      When Start the game
      And Waiting for start
      And Input highlighted value
      Then Game Over with more than 1500 symbols