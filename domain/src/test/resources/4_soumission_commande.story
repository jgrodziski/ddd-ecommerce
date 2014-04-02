Given service de commande initialise avec un catalogue et un service client
Given le panier courant du compte client "jeremie@grodziski.com"
When le client soumet le panier
Then la commande est creee dans l'etat "SUBMITTED"
Then le recapitulatif de la commande est affichee au client

Given la commande dans l'etat "SUBMITTED"
When le client demarre le processus de paiement
Then le systeme verifie que le stock des offres de la commande est suffisant pour les quantites
Then le systeme demande au client de choisir parmi les modes de paiements : CB, VIREMENT, CHEQUE
When le client choisit le mode de paiement CB
Then le systeme demande au client de renseigner ses informations CB
When le client saisit ses informations CB 1234 5678 9011 1213, 456, 04/15
Then le systeme a valide le paiement
Then la commande est dans l'etat "PAID"
Then la facture est emise