Feature: tester les alertes java

  Scenario: tester alerte java script simple click boite dialogue
    Given je suis sur la page des alertes
    When je click sur l alerte java script sipmle click
    Then alerte saffiche avec msg boite dialogue I am a JS Alert et bouton ok

  Scenario: tester alerte java script simple click result
    Given je suis sur la page des alertes
    When je click sur l alerte java script sipmle click
    And  je click sur bouton OK
    Then result affiche You successfully clicked an alert


  Scenario: tester alerte java script confirm boite dialogue
    Given je suis sur la page des alertes
    When je click sur l alerte java script confirm
    Then alerte saffiche avec msg boite dialogue I am a JS Confirm et boutons ok cancel

  Scenario: tester alerte java script confirm result OK
    Given je suis sur la page des alertes
    When je click sur l alerte java script confirm
    And  je click sur bouton OK
    Then result affiche You clicked: Ok

  Scenario: tester alerte java script confirm result Cancel
    Given je suis sur la page des alertes
    When je click sur l alerte java script confirm
    And  je click sur bouton Cancel
    Then result affiche You clicked: Cancel

  Scenario: tester alerte java script Prompt click OK
    Given je suis sur la page des alertes
    When je click sur l alerte java script Prompt
    And  je click sur bouton OK Prompt
    Then result affiche You entered:

  Scenario: tester alerte java script Prompt saisi "hi" click OK
    Given je suis sur la page des alertes
    When je click sur l alerte java script Prompt
    And  je saisi "hi hela" et click sur bouton OK
    Then result affiche You entered: hi hela

  Scenario: tester alerte java script Prompt click cancel
    Given je suis sur la page des alertes
    When je click sur l alerte java script Prompt
    And  je click sur cancel
    Then result affiche You entered: null








