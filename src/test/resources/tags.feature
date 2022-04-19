Feature: I want to test tag feature


  Background: Tags is working
    Given User has some tags


  Scenario Outline: I want to delete my tag
    Given I have account at site
    And I create a new tag with "<name>"
    And I have created tag successfully
    When I see tag with this id
    And I delete tag with this id
    Then I have deleted tag successfully

    Examples:
      | name    |
      | OneJava   |
      | TwoJava |


  Scenario Outline: I want to see absent tag
    Given I have account at site
    And I try to see tag with some "<wrong id>"
    Then I not see tag with this id

    Examples:
      | wrong id    |
      | 487a666c-aa3c-4767-86f2-796156ad67a6   |
      | 487a666c-aa3c-4767-86f2-796156ad67a7 |
