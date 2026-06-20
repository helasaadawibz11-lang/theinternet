Feature: tester les alertes java

  Background:
    Given je suis sur la page des alertes

  @Test
  Scenario: tester alerte java script simple click boite dialogue
    When je click sur l alerte java script sipmle click
    Then alerte saffiche avec msg boite dialogue I am a JS Alert et bouton ok
  @Test
  Scenario: tester alerte java script simple click result
    When je click sur l alerte java script sipmle click
    And  je click sur bouton OK
    Then result affiche You successfully clicked an alert

  @Test
  Scenario: tester alerte java script confirm boite dialogue
    When je click sur l alerte java script confirm
    Then alerte saffiche avec msg boite dialogue I am a JS Confirm et boutons ok cancel
  @Test
  Scenario: tester alerte java script confirm result OK
    When je click sur l alerte java script confirm
    And  je click sur bouton OK
    Then result affiche You clicked: Ok
  @Test
  Scenario: tester alerte java script confirm result Cancel
    When je click sur l alerte java script confirm
    And  je click sur bouton Cancel
    Then result affiche You clicked: Cancel
  @Test
  Scenario: tester alerte java script Prompt click OK sans saisi
    When je click sur l alerte java script Prompt
    And  je click sur bouton OK Prompt
    Then result affiche You entered:
  @Test
  Scenario: tester alerte java script Prompt saisi "hi" click OK
    When je click sur l alerte java script Prompt
    And  je saisi "hi hela" et click sur bouton OK
    Then result affiche You entered: hi hela
  @Test
  Scenario: tester alerte java script Prompt click cancel
    When je click sur l alerte java script Prompt
    And  je click sur cancel
    Then result affiche You entered: null
  @Test
  Scenario: tester Changement visuel lors du clic alerte java script simple click
    When je click sur l alerte java script sipmle click
    And  je click sur bouton OK
    Then modification couleur bouton lors du click
    And result affiche You successfully clicked an alert











