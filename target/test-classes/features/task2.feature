Feature: Validating add and delete module from Protractor Practice Website

  @wip
  Scenario: Delete user User Name: novak and validate user has been delete
    Given Admin is on the HomePage "http://www.way2automation.com/angularjs-protractor/webtables/"
    When  Admin locating "novak" from table
    And   Admin delete
    Then  Admin validate "novak" has deleted
