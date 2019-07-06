Feature: login Origance application

<<<<<<< HEAD
@Sanity
=======
@smoketest
>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git
Scenario: Positive testcase for login
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter uname NYB\MichaelFarris
	And Enter password DelForMayor18!
	And Click login 
	
<<<<<<< HEAD
@Smoke
=======
	
@Negativetest
>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git
Scenario: Negative testcase for login
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter uname NYB\MichaelFarris
	And Enter password DelForMayor18123!
	And Click login 
	Then Verify validation message Invalid username/password
<<<<<<< HEAD

=======
	
>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git
@Datadriventest
Scenario Outline: testcase for login using different username and password
	Given Open the browser using the URL 
	When title of login page is Login to Application
	And Enter uname <username>
	And Enter password <password> 
	And Click login 
	Then Verify loginname <verifyname>
	
Examples: 
<<<<<<< HEAD
|username|password|verifyname|
|NYB\Clientadmin|DelForMayor18!|NYB m ClientAdmin|
|NYB\MichaelFarris|DelForMayor18!|Michael Farris|
=======
|username			|password		|verifyname			|
|NYB\MichaelFarris	|DelForMayor18!	|Michael Farris		|
|NYB\Processor		|DelForMayor18!	|NYB Mi Processor	|
>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git
