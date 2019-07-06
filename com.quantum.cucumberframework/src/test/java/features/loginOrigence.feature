Feature: login Origance application

@Sanity
Scenario: Positive testcase for login
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter uname NYB\MichaelFarris
	And Enter password DelForMayor18!
	And Click login 
	
@Smoke
Scenario: Negative testcase for login
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter uname NYB\MichaelFarris
	And Enter password DelForMayor18123!
	And Click login 
	Then Verify validation message Invalid username/password

@Datadriventest
Scenario Outline: testcase for login using different username and password
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter uname <username>
	And Enter password <password> 
	And Click login 
	Then Verify loginname <verifyname>
	
Examples: 
|username|password|verifyname|
|NYB\Clientadmin|DelForMayor18!|NYB m ClientAdmin|
|NYB\MichaelFarris|DelForMayor18!|Michael Farris|
