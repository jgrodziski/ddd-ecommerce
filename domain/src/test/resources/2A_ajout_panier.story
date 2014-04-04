Given l'offre EG1-JA
When l'acheteur ajoute l'offre EG1-JA a son panier
Then le panier contient l'offre EG1-JA
Then le panier a des frais de port de 0 USD
Then le panier a un solde de 499.99 USD

Given l'offre GA1-JA
When l'acheteur ajoute l'offre GA1-JA a son panier
Then le panier contient l'offre GA1-JA
Then le panier a des frais de port de 10 USD
Then le panier a un solde de 209.99 USD
//verification regle FreeShippingCostRule