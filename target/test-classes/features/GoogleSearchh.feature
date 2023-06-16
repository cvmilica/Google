@wip @ui
Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search anything and see relevant results

  Scenario Outline: Search result title verification
    Given the user has already navigated to the Google search page
    Then the user should see that the title is "Google"
    When the user searches for "<searchTerm>"
    Then the user should see "<searchTerm>" in the title
    Examples:
      | searchTerm |
      | apple      |
      | orange     |
      | lemon      |