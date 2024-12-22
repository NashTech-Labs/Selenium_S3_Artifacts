Feature: WebDriver BiDi with Cucumber

  Scenario: Navigate and listen to console logs
    Given I navigate to website
    When Navigate to Other website "https://www.amazon.com/"
    Then Title should be "Amazon" of website


