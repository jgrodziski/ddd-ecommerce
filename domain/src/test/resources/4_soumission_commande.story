Given service de commande initialisé avec un catalogue et un service client
Given un service de validation de mode de paiement CB
Given un panier non vide et un compte client valide
When le service client soumet le panier au service commande
Then le service commande vérifie que le stock des offres du panier est valide
Then le service commande demande au client de choisir son mode de paiement
Given le client choisit le mode de paiement CB 
When le client rentre son numéro de CB, sa date d'expiration et son cryptogramme
Then le service de commande vérifie que le paiement est valide
Then le service de commande vérifie exécute le paiement
Then le service de commande informe la compta
Then le service de commande soumet la commande au service expédition
Then le service de commande informe le client de la soumission de la commande au service expédition