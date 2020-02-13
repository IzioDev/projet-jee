# Projet JEE
## PORT:

http://ellsworth.iut2.upmf-grenoble.fr:7280/

https://ellsworth.iut2.upmf-grenoble.fr:7248/

(jalmmi4)
## Notes
La branche master contient la dernière version sous glassfish.

Pour avoir le tp 1 et 2 sous tomcat, il suffit d'aller dans release sur github et de télécharger les deux versions
(elles sont taguées donc pas de soucis pour les avoir indépendemment).

Les autres tags contiennent les TP3 et + sous glassfish (sauf le TP2 qui est tagué sur les deux versions).

## Base de données docker
Vous pouvez soit utiliser le script `bin/start.sh` qui instancie un container mysql localement, soit utiliser votre propre instance MySQL.

Dans le cas où vous n'utilisez pas docker, il faudra modifier les identifiants de connexion à MySQL dans `src/META-INF/persistence.xml`