Feature: tester le formulaire login de lapp the internet
  @Test
  Scenario: successful login avec identifiants valides
    Given je suis sur la page de login
    When je saisi username "tomsmith"
    And je saisi password "SuperSecretPassword!"
    And je click sur login button
    Then redirection vers successful login page

   @Test
    Scenario Outline: login avec identifiants invalides
      Given je suis sur la page de login
      When je saisi user "<user>"
      And je saisi pass "<pass>"
      And je click sur login button
      Then loginfailed et msg erreur saffiche "<msg>"

      Examples:
      |user|pass|msg|
      |tomsmith|SuperSecretPasswo| Your password is invalid!|
      |tomsmit|SuperSecretPassword!| Your username is invalid!|
      | |SuperSecretPassword!|Your username is invalid!|
      |tomsmith|             | Your password is invalid!|
      |        |             | Your username is invalid!|
