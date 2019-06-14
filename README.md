# framework-auto-prac-vinay-koduri

This project can be executed from mvn command line using the following command:

*clean verify "-Dcucumber.options=--tags @dev" -Dbrowser=chrome -DrunLocation=local*

This will execute the scripts in chrome in the local/dev environment.

To create an account using scripts, just need to update to unique email in the "Registration.feature" file and in "dataFile.yml"
Instead of hardcoding data, I am reading it from dataFile.yml. So, that we can create and update data, without touching the scripts.

By just changing the variable from the command prompt, the scripts can be executed in various browsers both **locally and remotly(anywhere in saucelab,seetest,browserstack or in selenium grid etc**(template in place and code partially done)

**Reports will be saved under target/cucumber-reports/cucumber-html-reports/overview-features.html**

**please read maven comments to execute the scripts in parallel**

As requested 2 sceanrios had been automated and making sure the below tasks are completed.



Tasks:

·         To the best of your skill and knowledge create a simple a basic  Automation framework (maven project) using Cucumber BDD in github / send us through a ZIP file with some design ( if possible ) 
**(Implemented)**

Write BDD scenarios for the above user stories(pick any one or  two )  with necessary tags 
**(Implemented)**

Automate the scenarios using Selenium 3, follow Page Object/factory pattern 
**(Implemented)**

Run the Automation suite from command line and generate the report ( not mandatory ) 
**(Implemented)**

Pass the browser name and tag dynamically as Maven parameter(not mandatory ) 
**(Implemented)**

Add the following project in https://github.com/ and please send back the github url for review 
**(Implemented)**

Run all the stories in parallel ( not mandatory ) 
**(Implemented)**

