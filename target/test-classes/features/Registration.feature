@registration
Feature: Registering to automation practice


@dev @sqi @uat
  Scenario: Validate user is able to register
    Given Automation practice page is opened
    When I click on Sign in link
    And I provide with email address "testautoprac_115@gmail.com"
    Then I click on "Create an account" button
    And provide all the required information of "testautoprac_115@gmail.com"
    And I click on Register button
    Then I should be able to register successfully and receive the following message "Welcome to your account. Here you can manage all of your personal information and orders."

@dev @sqi @uat
  Scenario: While registering, if the email address is incorrect. User should see an error message
    Given Automation practice page is opened
    When I click on Sign in link
    And I provide with email address "testautoprac_111"
    Then I click on "Create an account" button
    Then user should see the following error message "Invalid email address."