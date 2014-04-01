Scenario: creation de compte client
When le visiteur cree son compte client email : jeremie@grodziski.com, prenom : Jeremie, nom : Grodziski, mot de passe : mdp
Then son compte client avec identifiant "jeremie@grodziski.com" est cree dans l'etat "EN_ATTENTE_CONFIRMATION"
Then la confirmation de creation du compte est envoyee par email au client
When le client confirme sa creation
Then le compte client avec identifiant "jeremie@grodziski.com" est passe dans l'etat "CONFIRME"

Scenario: connexion par un client
Given creation de compte client
When le client se connecte avec les informations identifiant "jeremie@grodziski.com" mot de passe "mdp"
Then le client a une session active


When le client ajoute une adresse de livraison a son compte client 21 rue de milan 75009 Paris
When le client ajoute une adresse de facturation a son compte client 21 rue de milan 75009 Paris
