Feature: Search contact
  Everybody wants to know when it's Friday

  Scenario Outline: Find a contact by first name
    Given Search page is displayed
    When Input <name>
    Then Found <input_name> in the result line

    Examples:
      | name            | input_name |
      | Sara         | Sara Alston   |
