Feature: login Origance application

Scenario: Positive testcase for login
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter "NYB\\MichaelFarris"
	And Enter "DelForMayor18!"
	And Click login 
	Then Verify loginname
	
Scenario: Negative testcase for login
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter "NYB\\MichaelFarris"
	And Enter "DelForMayor18123!"
	And Click login 
	Then Verify validation message "Invalid username/password"
