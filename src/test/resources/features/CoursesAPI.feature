@sdetcourse
Feature: Courses API tests

  Scenario: Verify both resources are active
    Given Resource "sdetcourse" is up and running
    When I send GET request using query parameter "name" equal to "API"
    Then Response code should be 200
    Then Print out and log the response body

    Scenario: Verify Json schema of sdetcourse response
      Given Resource "sdetcourse" is up and running
      When I send GET request using query parameter "name" equal to "Java"
      Then Validate JsonSchema matches to "sdetCourseSchema.json" file

