 Feature: Luma Login Feature

   Background: Login Background Steps
     Given user is on the login page

   Scenario: Successful Login
     When user enter valid username "kevin.lee@gmail.com
     And user enters a valid password "Kevin123"
     And user click on the sign in button
     Then user should be logged in successfully

   Scenario: Successful Login
     When user enter valid username "kevin.lee@gmail.com
     And user enters a invalid password "KevinIncorrect"
     And user click on the sign in button
     Then user should be logged in successfully