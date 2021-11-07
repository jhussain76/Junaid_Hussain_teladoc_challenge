Feature: Validating add and delete module from Protractor Practice Website

  @wip
  Scenario Outline: Add a user and validate the user has been added to the table
    Given Admin is on the HomePage "http://www.way2automation.com/angularjs-protractor/webtables/"
    When  Admin click on add User module
    And   Admin insert required information to create a user "<firstName>" "<lastName>" "<userName>" "<password>""<email>""<cellPhone>"
    Then  Admin validate the user has been added to the table
      | Steve Jobs          |
      | SteveJobs1111       |
      | SteveJobs123        |
      | SteveJobs@gmail.com |
      | 777888999           |


    Examples: Required information
      | firstName  | lastName      | userName     | password   | email               | cellPhone |
      | Steve Jobs | SteveJobs1111 | SteveJobs123 | Steve Jobs | SteveJobs@gmail.com | 777888999 |