Given service de commande initialis� avec un catalogue et un service client
Given un service de validation de mode de paiement CB
Given un panier non vide et un compte client valide
When le service client soumet le panier au service commande
Then le service commande v�rifie que le stock des offres du panier est valide
Then le service commande demande au client de choisir son mode de paiement
Given le client choisit le mode de paiement CB 
When le client rentre son num�ro de CB, sa date d'expiration et son cryptogramme
Then le service de commande v�rifie que le paiement est valide
Then le service de commande v�rifie ex�cute le paiement
Then le service de commande informe la compta
Then le service de commande soumet la commande au service exp�dition
Then le service de commande informe le client de la soumission de la commande au service exp�dition