Feature: Login to All Applications with Account Creation


  @Test @positive @KD
  Scenario: Create an authorizer for KastleDirect
    Given user open "kastlesDirect" application

  @Test1 @positive
  Scenario: Create an account on okta
    Given user open "kastlesDirect" application

  @Test @positive @MKLogin @myKastleRelease @MK @Mini @KD
  Scenario: Login To MK Application
    Given user open "kastlesDirect" application


  @Test @positive @KDLogin @kastlesDirect @KD @Mini
   Scenario: Login To KD Application
    Given user open "kastlesDirect" application