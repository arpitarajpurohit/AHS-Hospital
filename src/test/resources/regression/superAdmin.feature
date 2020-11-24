Feature: SupperAdmin can Create Edit and delete user

  @01
  Scenario Outline:1 Verify SuperAdmin can Edit user details
    Given SuperAdmin logIn
    And He navigate to Masters screen and select Users
    And He select Edit from action column
    When He updates details and select UserType as "<UserType>" and click submit.
    Then All the updated data should be available for the selected user
    Examples:
      | UserType     |
      | SuperAdmin   |
      | CallCenter   |
      | LabTechnican |
      | Admin        |
      | ILDBoy       |
      | Manager      |

  @02
  Scenario:2 Verify SuperAdmin can create group test
    Given SuperAdmin logIn
    And He navigate to Masters screen and select Group Test
    And In GroupTestName select AddNew
    When Add group test name and price and click submit
    Then Group test created successfully

  @03
  Scenario Outline: Super admin can create a new user
    Given SuperAdmin logIn
    And He navigate to Masters screen and select Users
    And He navigate to Add New
    When He updates details and select UserType as "<UserType>" and click submit.
    Then New user created successfully
    Examples:
      | UserType     |
      | SuperAdmin   |
      | CallCenter   |
      | LabTechnican |
      | Admin        |
      | ILDBoy       |
      | Manager      |
  @04
  Scenario: Super admin can delete user
    Given SuperAdmin logIn
    And He navigate to Masters screen and select Users
    When He go to action column and select delete
    Then user should be deleted successfully









