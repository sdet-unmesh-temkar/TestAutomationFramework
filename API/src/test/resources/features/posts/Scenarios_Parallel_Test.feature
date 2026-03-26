Feature: Run Cucumber scenarios in parallel

  @scenarioParallel
  Scenario: Test scenario parallel execution 1
    Given print thread count on console

  @scenarioParallel
  Scenario: Test scenario parallel execution 2
    Given print thread count on console

  @scenarioParallel
  Scenario: Test scenario parallel execution 3
    Given print thread count on console

  @scenarioParallel
  Scenario: Test scenario parallel execution 4
    Given print thread count on console