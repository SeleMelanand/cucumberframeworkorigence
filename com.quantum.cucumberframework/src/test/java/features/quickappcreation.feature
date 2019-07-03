Feature: Creating a loan using Quickapp 

@Smoketest
Scenario: loancreating using quickapp (positive case) 
	Given login as loanofficer
	When confirm loan officer is loged in 
	And Navigate to Quickapp page
	And Enter all necessary details and save
	Then print generated loannumber
	
	 