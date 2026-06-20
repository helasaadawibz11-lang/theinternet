Feature: tester l'interface drag and drop du site the internet


  Background:
    Given je suis sur la page de l application


  #Smoke
  Scenario: Test drag and drop réussi (A vers B)
    When je click sur square A
    And je drag A vers B
    Then B et A switch de places

  #Regression
  Scenario: Test drag and drop dans le sens inverse (B vers A)
    When je drag le carre B vers le carre A
    Then le carre A doit afficher le texte "B"
    And le carre B doit afficher le texte "A"


  #Robustesse
  Scenario: Glisser un carre dans le vide ne doit pas modifier l'état
    When je drag le carre A et je le lâche dans le vide
    Then le carre A doit afficher le texte "A"
    And le carre B doit afficher le texte "B"

  @Test
  #EdgeCase (cas limite)
  Scenario: Glisser un carre sur lui-même
    When je drag le carre A et je le lâche sur le carre A
    Then le carre A doit afficher le texte "A"
