Feature: Various tests GET Requests
@tag2
  Scenario: Test
    Given Run
  When Jump
  And I make "first scenario"
  Then Sleep

  @tag2
  Scenario: Test 2
    Given Run
    When Jump
    And I make "second scenario"
    Then Sleep

  @tag2
  Scenario: Test 3
    Given Run
    When Jump
    And I make "third scenario"
    Then Sleep
