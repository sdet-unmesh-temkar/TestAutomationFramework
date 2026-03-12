Framework features:
1. cross browser testing for UI
2. Parallel test execution for faster feedback
3. Retry mechanism for failed tests to improve test stability
2. Centralized and thread safe WebDriver management
3. Page Object Model (POM) design pattern for better maintainability
4. POJO classes for API tests, serialization and deserialization of JSON data.
4. TestNG for test execution and reporting
5. Maven for dependency management and build automation
6. ExtentReports for detailed test reporting
7. Log4j for logging test execution details
8. Data-driven testing using TestNG's @DataProvider. Externalize test data in Excel or CSV files for better maintainability and scalability.
9. Integration with CI/CD tools like Jenkins for automated test execution on code changes
10. Environment configuration management using properties files to easily switch between different test environments (e.g., dev, staging, production)
11. Use of WebDriverWait and ExpectedConditions for better synchronization and stability of tests
12. OOPS concepts in Framework:
13. Encapsulation: WebDriver management and test data handling are encapsulated within utility classes, providing a clean interface for test classes to interact with.
14. Inheritance: BaseTest class can be extended by all test classes to inherit common setup and teardown methods, reducing code duplication.
15. Polymorphism: Test classes can override methods from the BaseTest class to provide specific implementations for different test scenarios, allowing for flexible and reusable code.
16. Abstraction: The framework abstracts away the complexities of WebDriver management, test data handling, and reporting, allowing testers to focus on writing test logic without worrying about the underlying implementation details.
17. Test written using cucumber as well as testng, performed setup and tear down in both styles

Problems:
1. for testNg naukri test, if test fails, @AfterMethod kills the driver and Listener does not have driver to capture screenshot
2. failed screenshots currently overwrite each other, need to implement a mechanism to save screenshots with unique names (e.g., timestamp or test method name).
3. For cucumber tests, need to implement a mechanism to capture screenshots on failure and save them with unique names (e.g., timestamp or scenario name).
4. Normal Screenshots also overwrite each other, need to implement a mechanism to save screenshots with unique names (e.g., timestamp or test method name) for normal screenshots as well.

Q4. Explain your automation framework?
Answer:
My automation framework is built in Java.
It integrates Selenium for web testing and Rest Assured for API testing.
We follow a layered architecture — Page Object Model for maintainability, utility classes for reusability, and ThreadLocal driver management for parallel execution.
Maven is our build tool.
We use Cucumber for BDD scenarios so business teams can read and understand tests easily.
For logging we rely on Logback.
For reporting we’ve integrated Extent Reports
We have also implemented listeners to capture screenshots on failure.
Test data is externalized in property files and managed per environment, which makes the framework flexible across QA, UAT, and production.
On the CI/CD side, we’ve set up GitHub Actions workflows to run tests in parallel, publish reports, and store artifacts like logs and screenshots.
Overall, the design is modular, scalable, and easy to extend — new pages or APIs can be added quickly without impacting existing tests.