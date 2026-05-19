---
layout: image
image: ../assets/backgrounds/background_2.svg
backgroundSize: contain
---

<div class="flex justify-center items-center h-full">
  <img src="../assets/backstage_no_background.png" />
</div>

<!--
Comme on a déjà un super nom, on a fait 90% du travail.
Ce qu'on vous propose aujourd'hui, c'est de faire les 10% restants ensemble, en utilisant les méthodologies du Domain-Driven Design.
-->

---
layout: image-right
image: ../assets/mixer.jpg
--- 

<div class="absolute inset-0 w-1/2" style="background-image: url('../assets/backgrounds/background_3.svg'); background-size: cover;"></div>

<div class="relative z-10">

<br>
<br>

## Business concepts ?

<br>
<br>

### <v-click> Musician</v-click>

### <v-click> Instrument</v-click>

### <v-click> Studio</v-click>

### <v-click> Marketplace</v-click>

### <v-click> Ad</v-click>

### <v-click> to apply a discount</v-click>

### <v-click> make a price proposition</v-click>

### <v-click> place an alert</v-click>

### <v-click>pay</v-click>

</div>

<!--
Quels sont les concepts métiers importants que l'on retient ?

Musicien
Studio
Instrument
Annonce
Prix
Faire une Proposition de prix
Alerte
appliquer un discount
-->
--- 
class: text-center
layout: center
---

<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## UBIQUITOUS LANGUAGE


<!--
Ce qu'on vient de faire, c'est commencer à construire un langage commun entre nous, développeurs, et les experts métiers.

Le language ubiquitaire.

-->
    

--- 
class: text-center
layout: center
---

![ubiquitous-language.png](../assets/ubiquitous-language.png)

<!--

On veut construire un model mental partagé avec tout le monde et dans le code.

TODO retravailler transition avec contexte

Ce qu'on veut, c'est lever toutes les ambiguités sur le vocabulaire métier.
Avoir des termes précis, partagés, et compris par tous.

Le piège c'est d'avoir des termes qui veulent dire plusieurs choses, selon les personnes à qui on parle.

Et en tant que développeur, on a une grosse responsabilité sur ce vocabulaire, 
car on a tendance à introduire des termes techniques (biais du dev) qui n'ont pas de sens pour les experts métiers.


-->



---
class: text-center
layout: center
---
<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## Bounded Context

<!--

Ca tombe bien, pour ça DDD nous donne la notion de bounded Context.

Un bounded contexte, c'est une frontière explicite dans laquelle un langage ubiquitaire 
va s'appliquer, via un modèle spécifique.

Tout l'enjeu va être de bien définir ces frontières.

Et pour ça on va s'appuyer sur les...
-->

---
class: text-center
layout: center
---

<img src="../assets/bounded-context-en.png" alt="bounded-context" class="max-h-full max-w-full object-contain" style="max-height: 52vh;" />

<!--
Ici quel est notre core-domain?
Quels sont les supporting subdomains?
Quels sont les generic subdomains?

Grace à ce découpage, on va pouvoir aligner les bounded contexts.
L'alignement entre les sous-domaines et les bounded contextes n'est pas forcément 1:1, mais c'est souvent le cas.

C'est un choix d'architecture important à faire en amont du projet.

On peut découper le domaine métier en sous-domaines.
[click] Le Core Domain est le sous-domaine principal, celui qui apporte de la valeur différenciante à l'entreprise.

[click] Le Supporting Subdomain est un sous-domaine qui apporte de la valeur, mais qui n'est
pas différenciante. (ex: un catalogue de produits)

[click] Le Generic Subdomain est un sous-domaine qui n'apporte pas de valeur différenciante, et qui peut être externalisé. (ex: gestion des notifications, gestion des paiements, etc...)

TODO attention au dernier clic
-->




