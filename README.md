# sudoku-resolver

Ce projet permet de résoudre automatiquement tous les SUDOKUs proposés sur le site [sudoku.com](https://sudoku.com/fr/).

## Pour l'exécuter

Placez la page de sudoku sur votre écran principal, puis votre logiciel pour exécuter le projet sur l'écran de droite, par exemple, dans mon cas j'utilise éclypse.
Attention, le programe ce base sur des positions (pixel) pour effectuer ces cliques. Il se peut que le programme s'exécute mal selon les écrans. J'essayerai plus tard de détecter la taille de la grille avant d'exécuter le programme.

Pour le détection de la grille d'origine, j'ai utilisé une "IA" permettant de reconnaitre les chiffres présents sur la grille et de les récupérer pour résoudre le sudoku. Cet "IA" est [sikuli-fuzz](https://code.google.com/archive/p/sikuli-api/downloads), qui est un package open source et relativement simple à utiliser.

## Pourquoi Java ?

Tout simplement parce que je n'ai pas souvent l'occasion de coder en java, donc pour m'entrainer j'ai choisi ce langage.
