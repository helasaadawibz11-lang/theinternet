# 🌐 Automation Testing Exercices - The Internet (Herokuapp)

Ce Mini-projet présente un framework d'automatisation de tests de bout en bout (End-to-End) développé pour valider différentes interfaces et scénarios interactifs du site d'entraînement **The Internet**.

L'objectif de ce dépôt est de démontrer la mise en application des pratiques QA, notamment la robustesse des scripts et la maintenabilité du code.

---

## 🛠️ Stack Technique & Architecture

* **Langage :** Java
* **Framework d'Automation :** Selenium WebDriver
* **Approche Spécification :** BDD (Behavior-Driven Development) avec **Cucumber**
* **Framework d'Assertion :** JUnit
* **Design Pattern :** Page Object Model (POM)  **Page Factory**
* **Gestionnaire de dépendances :** Maven

## 🚀 Structure du Projet

Conformément au pattern Page Object Model, le projet sépare strictement la cartographie des pages des étapes d'exécution 

---

## 📋 Couverture des Tests (Interfaces Testées)

Le framework automatise et valide de manière exhaustive les composants et interactions utilisateur suivants :

### 1. Formulaire d'Authentification (`/login`)
* **Happy Path :** Validation de la connexion réussie avec des identifiants valides et vérification de la redirection sécurisée.
* **Robustesse & Cas Limites (Matrix Testing via `Scenario Outline`) :** * Gestion des identifiants erronés, des champs vides et de la sensibilité à la casse.
  * Tests de sécurité (tentatives d'injections de scripts basiques/XSS).
  * Validation dynamique des messages d'erreur système contextuels.

### 2. Glisser-Déposer HTML5 (`/drag_and_drop`)
* **Interactions complexes :** Simulation et exécution du Drag & Drop via des scripts JavaScript (`JavascriptExecutor`) pour contourner les limitations natives du protocole de navigation.
* **Non-Régression & Robustesse :**
  * Inversion des mouvements (déplacement de B vers A).
  * Gestion des anomalies UX : relâcher un élément dans le vide (coordonnées par *offsets*) ou glisser un composant sur lui-même (Edge Case).

### 3. Gestion des Alertes JavaScript (`/javascript_alerts`)
* **Alertes Système :** Prise en charge et isolation du focus des fenêtres contextuelles natives du navigateur (`driver.switchTo().alert()`).
* **Validation unitaire :**
  * **JS Alert :** Récupération du texte et acceptation.
  * **JS Confirm :** Test de flux alternatif (Validation / Annulation ).
  * **JS Prompt :** Saisie dynamique de chaînes (données normales, chaînes vides) et interception des résultats renvoyés (`null`/ msg saisi).
* **Vérification UI :** Validation des modifications graphiques (code couleur CSS / Hexadécimal) lors de l'interaction avec les éléments de la page.

---

