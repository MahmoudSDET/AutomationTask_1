# AutomationTask_1

This is automation task which contains a group of test cases to validate login process and registration process in specific.
The test cases are represent as this below
1-	Implement an HTTP interceptor for the signUp API request and save the response in any way so it can be checked later by the user and this class which is implemented to this process
(TestImplementingHttpIntercreptorForSignUp.java)
2-Registration with valid and invalid scenarios and login successfully with existing registered user and this class which is implemented to this process is called
(UserRegistrationTest.java)

3- This code is implemented an object-oriented design and POM (Page Object Model) design pattern and Maven Repository (build management tool)

4- I used java faker library to generate the data which are used to register and store this data in Excel file in addition to the type of this registered data is (valid or invalid) represented
 as the last column in Excel sheet (data type). this file in package Data in test "src/test/java" . the file is called "UserData.xlsx" and when user login with registered data
  i can read the valid creditials from the last valid registerd row in this excel file .
  
5-after ending of the execution , you can verify the testing report in the "TestReportResults" folder. this report is considered as "Extent Report" is represented as "ExtentReport.html"
   this report contains all tests which are exected (passed and failed tests with screen shot and the name and description of the failure )
   
6- if you running all test classes , you can run "testng.xml" file with testng and if you run specific class , you can select the test class which i implemented like this "TestImplementingHttpIntercreptorForSignUp.java" or
  UserRegistrationTest and run with testng  test runner and (mvn clean test) if you like with command line cmd
