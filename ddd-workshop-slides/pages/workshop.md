---
layout: center
class: text-center
---

<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## Hands-on


<!--
@François - 8min

On a fait la partie stratégique, on va rentrer dans la partie tactique. Et plutôt que de présenter tous les concepts un par un, 
on va partir d'une approche naïve afin de les faire émerger au fur et à mesure.
-->

---
layout: center
class: text-center
---

<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>


## Architecture

<!--
@François - 8min

#### Scope and limitations

On va partir de certains use cases simples de l'application afin de mettre en lumière les différents patterns.

On a un temps limité, on va donc sciemment laisser certains aspects de côté. Notamment la partie infrastructure.

présentation rapide de l'architecture proposée

- présentation des BCs (layered vs hexagonal architecture)
- Ubiquitous langage: instrument a une forme differente dans les 2 BCs
-->

---
layout: center
class: text-center
---
<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## 1. The Ad

<br>
<br>
<br>

<div class="relative z-10 text-2xl">

A musician can publish an Ad to sell an instrument.

An Ad should have a title, an instrument, and a price.

An Ad can be sold

An Ad is available to sell until it is sold.
</div>

<!--
@François - 13min

Temps de codage : 7min
-->

---
layout: image-right
image: ../assets/bass.jpg
---


<div class="absolute inset-0 w-1/2" style="background-image: url('../assets/backgrounds/background_3.svg'); background-size: cover;"></div>

<div class="relative z-10">

<br>
<br>

## Entity

<br>
<br>
<br>

<h3 v-click>identity</h3>
<h3 v-click>lifecycle</h3>
<h3 v-click>mutable</h3>

</div>

<!--
@François - 20min

Une entité est un objet qui a une identité propre et un cycle de vie.

Elle est mutable, on peut modifier ses propriétés au cours de son cycle de vie.
Par contre, ce n'est pas une entité Hibernate (attributs vs comportement)
Ici la notion d'encapsulation est importante. On n'expose pas les propriétés, mais des comportements.
On veut exprimer l'intention métier.

Elle porte ses invariants métier. C'est elle qui garantit la cohérence de son état.
-->


---
layout: center
class: text-center
---
<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## 2. Price

<br>
<br>
<br>

<div class="relative z-10 text-2xl">

A musician can apply a discount on the price of his ad.

The discount is a percentage of the price (between 0% and 100%).

A price cannot be negative.

</div>

<!-- 
@Thomas - 30min

Temps codage : 10min

-->

---
layout: image-right
image: ../assets/drums.jpg
---

<div class="absolute inset-0 w-1/2" style="background-image: url('../assets/backgrounds/background_3.svg'); background-size: cover;"></div>

<div class="relative z-10">

<br>
<br>

## Value object

<br>
<br>
<br>

<h3 v-click>defined by its value</h3>
<h3 v-click>immutable</h3>
<h3 v-click>no lifecycle</h3>
</div>

<!--
@Thomas - 40min

Un Value Object est un objet défini par sa valeur. Deux VO avec la même valeur sont égaux.

Ils sont immuables. On ne peut pas modifier un VO, on crée un nouveau VO avec la nouvelle valeur.

Ils n'ont pas de cycle de vie. Ils n'ont pas d'identité propre. Ils existent uniquement dans le contexte d'une autre entité.
-->


---
layout: center
class: text-center
---
<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## 3. The proposal

<br>
<br>
<br>
<div class="relative z-10 text-2xl">

A proposal has a proposed price.

A proposal is placed by a musician.

A placed proposal is waiting for a decision.

A proposal can be accepted or rejected (if in waiting state).

</div>

<!--
@Bastien - 48min

Poser la question: proposal est-il une entité ou un VO?

Temps de code : 15min

-->

---
layout: image-right
image: ../assets/guitar.jpg
---
<div class="absolute inset-0 w-1/2" style="background-image: url('../assets/backgrounds/background_3.svg'); background-size: cover;"></div>

<div class="relative z-10">

<br>
<br>

## The Aggregate

<br>
<br>
<br>

<h3 v-click>contains VO and/or entities</h3>
<h3 v-click>root is responsible for its invariants</h3>
<h3 v-click>garantees consistency</h3>
<h3 v-click>defines transactional boundaries</h3>
</div>

<!--
@Bastien - 1h03min

Un aggregate est un ensemble de VO et/ou d'entités qui forment une unité cohérente.

La racine est responsable de ses invariants. C'est lui qui garantit la cohérence de l'ensemble.

Il définit les frontières transactionnelles et structurelles.

Il est le seul point d'entrée pour accéder aux VO et entités qu'il contient.

Plus besoin de code défensif pour vérifier les invariants, c'est l'aggregate qui s'en charge.

Plus facile à tester, plus facile à maintenir.
-->
