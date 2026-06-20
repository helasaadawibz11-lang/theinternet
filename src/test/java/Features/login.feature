Feature: tester le formulaire login du site the internet
  #@Test
  Scenario: successful login avec identifiants valides
    Given je suis sur la page de login
    When je saisi username "tomsmith"
    And je saisi password "SuperSecretPassword!"
    And je click sur login button
    Then redirection vers successful login page

   @Test
    Scenario Outline: login avec identifiants invalides
      Given je suis sur la page de login
      When je saisi username "<user>"
      And je saisi password "<pass>"
      And je click sur login button
      Then loginfailed et msg erreur saffiche "<msgExpected>"

     Examples:
       | user     | pass                 | msgExpected               |
       | tomsmith | SuperSecretPasswo    | Your password is invalid! |
       | tomsmit  | SuperSecretPassword! | Your username is invalid! |
       |          | SuperSecretPassword! | Your username is invalid! |
       | tomsmith |                      | Your password is invalid! |
       |          |                      | Your username is invalid! |
       | !ù!é##   |                      | Your username is invalid! |
       |          | !ù!é##               | Your username is invalid! |
       | TomSmith | SuperSecretPassword! | Your username is invalid! |
       | tomsmith | supersecretpassword! | Your password is invalid! |
       | <script> | SuperSecretPassword! | Your username is invalid! |


      #password invalide
      #username invalide
      #username vide
      #password vide
      #deux champs vides
      #caracteres speciaux
      # Mauvaise casse Username
      # Mauvaise casse Password
      # Robustesse / Tentative d'injection données inattendu
