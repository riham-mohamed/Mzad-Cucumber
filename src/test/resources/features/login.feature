Feature: Login Test Cases

 Scenario: Check Login with empty mobile number
  Given user open login page
  When user leave mobile number empty
  Then next button is disabled

 Scenario: Check Login with wrong OTP
  Given user open login page
  When user enters mobile number
  And press next button
  And user enters wrong OTP
  Then press next button and check Error message

@smoke
 Scenario: Check Login function with valid credentials
  Given user open login page
  When user enters mobile number
  And press next button
  And user enters OTP
  And press next button
  Then user is navigated to homepage

 Scenario Outline: Check Login function with invalid credentials
  Given user open login page
  When user enters <invalidmobilenumber>
  And press next button
  And again user enters <invalidOTP>
  And press next button
  Then Error message is displayed

  Examples:
  |invalidmobilenumber|invalidOTP|
  |"14755555"|"123455"|
  |"14755556"|"123456"|