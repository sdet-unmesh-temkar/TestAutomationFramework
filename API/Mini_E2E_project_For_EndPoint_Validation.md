Section 1: REST API and Automation ( 20 mins )
API testing
1.	https://jsonplaceholder.typicode.com/posts
2.	Access the API and provide a test plan for the JSON data set.
3.	Write REST Assured or PyTest code to access API and implement the test cases as narrated above. Include exceptions and flaky issues
4.	validate response body values without hardcoding them
5.	Understanding of HTTP return methods and failures.
6.	Handle exceptions of 300/400/500 series
7.	handle timeouts and retries in REST Assured
Section 2: Environment Management – 5 mins
1.	How does API automation code adapt across multiple environments (QA, Stage, Prod)
2.	What configuration changes are required when switching environments?
3.	What content would need to be parametrized in environment config
4.	How do you avoid hardcoding environment-specific values?
5.	How would the configurations be reused in a test suite
6.	What challenges arise when maintaining tests across environments?
Section 3: Framework & Project Design – 10 mins
1.	Write down the project structure followed in your test suite for REST API automation.
2.	How do you separate test logic from API logic?
Section 4: Test Data & Management – 5 mins
1.	How are test data maintained in your project? Json, db, excel etc. How are they loaded and reused across test suite
2.	How are data cleaned up post automation.
3.	How do you load DB or configuration properties into Java/Python?
4.	How do you design property loading for reusability?
5.	What are common issues while connecting automation tests to databases?
Section 5: Security & Sensitive Information – 5 mins
1.	How do you manage sensitive information like passwords or API keys?
2.	What tools or approaches can be used to secure secrets?
3.	How do you mask sensitive data while logging requests and responses?
Section 6: Scenario validation– 10 mins
1.	Provide a real case scenario and identify test cases in usability, negative test cases, improvements.
For Example: Tissue paper, a glass, pencil, stock market application or a website. Identify their positive, negative, improvements and out of the box test cases.
Section 7: Debugging & Triage – 5 mins
1.	What information are collected and analysed before raising a defect?
2.	How do you trace API failures using logs?
3.	HTTP Status codes and information collection.