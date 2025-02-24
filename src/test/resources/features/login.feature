Feature: Login Test Cases

Scenario: Check Login function with valid credentials

  Given user open login page
  When user enters mobile number
  And press next button
  And user enters OTP
  And press next button
  Then user is navigated to homepage

Scenario Outline: Check Login function with invalid credentials
  Given user open login page
  When user enters <mobile number>
  And press next button
  And user enters <OTP>
  And press next button
  Then Error message is displayed

  Examples:
  |mobile number|OTP|
  |238950|166473|
  |238951|166472|