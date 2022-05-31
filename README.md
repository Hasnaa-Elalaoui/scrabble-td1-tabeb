# scrabble-td1-tabeb
scrabble-td1-tabeb created by M1 MIAGE students : 
- Wen-Miin Cheng
- Thomas Delmare
- Hasnaa Elalaoui
- Thomas Klein
- Nicolas Parizet
- Marie-Céleste Sanchez

Ce projet consiste en le développement d'une version numérisée du jeu plateau *Scrabble*.
L'intégration de tests unitaires, d'intégration et des technologies comme *Spring*, 
*Maven* ou encore *Docker* en demeure la tâche principale.

Ce document sera modifié au fur et à mesure de l'avancement du projet.

Le titre des issues respecte le format du modèle suivant :
(nom de la branche) Titre de la tâche 

Pour respecter le git-flow, nous avons 5 branches : *feature*, *dev*, *release*, *hotfix* et *main*
Ces branches sont inspirées du [modèle](https://i.stack.imgur.com/XgtXO.png)
décrit dans la [documentation git-flow](https://git-flow.readthedocs.io/fr/latest/presentation.html).


Afin de démarrer chaque service du projet, il faut se placer dans le dossier racine (contenant le pom.xml) et lancer la commande suivante :

    mvn spring-boot:run