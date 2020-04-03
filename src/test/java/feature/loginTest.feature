Feature:

Scenario Outline:
Given Initiate the chrome browser
And Navigate to the Rediff Welcome page
And Click on loginPage link
When Enter the valid user name <username> and password <password>
Then Successfully Navigated to the HomePage

Examples:

|username    |password   |
|user1		 |pass1		 |
|user2		 |pass2		 |
|user3		 |pass3		 |