#Auto generated Octane revision tag
@BSPID3001REV0.2.0
Feature: Search for the APG website on Google

  As a user of the Google search functionality
  I want to search for the APG website
  So I want to be sure that APG website is displayed in the search results

@TSCID17001
  Scenario: The APG website must be in the search results Jos
    Given I am on the Google homepage
    When I search for APG
    Then the APG website must be in the search results

@TSCID17002
  Scenario: The APG Wikipedia website must be in the search results
    Given I am on the Google homepage
    When I search for APG
    Then the APG Wikipedia website must be in the search results

@TSCID17003
  Scenario: The APG PPF website must be in the search results
    Given I am on the Google homepage
    When I search for APG
    Then the APG PPF website must be in the search results

@TSCID17004
  Scenario: The APG Google Maps details should be displayed
    Given I am on the Google homepage
    When I search for APG
    Then the APG Google Maps details should be displayed in the search results