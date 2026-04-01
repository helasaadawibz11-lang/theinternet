Feature: tester l'interface drag and drop du site the internet
  Scenario: test drag and drop
    Given je suis sur la page de l application
    When je click sur square A
    And je drag A vers B
    Then B et A switch de places