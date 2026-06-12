---
layout: center
class: text-center big-title
---


## Hands-on

<div class="mt-14">
<a href="https://tinyurl.com/devlille-ddd" target="_blank" class="workshop-link">💻 tinyurl.com/devlille-ddd</a>
</div>

<style>
.workshop-link {
  display: inline-block;
  background-color: #ffffff;
  color: #00465b !important;
  padding: 0.7rem 2rem;
  font-weight: 800;
  font-size: 1.6rem;
  letter-spacing: 0.03em;
  border: none !important;
  clip-path: polygon(
    2% 0%, 93% 5%, 100% 25%, 100% 79%, 85% 98%, 5% 100%, 0% 75%, 0% 21%
  );
}
</style>

<!--
@François - 13min

We did a quick introduction to one of the pillar of DDD, the strategic part. 
But today we want to code, and for this we have the tactical part, with many technical concepts.

As we don't want to enumerate them, we are going to take a naive approach in order to showcase some patterns.
-->

---
layout: center
class: text-center big-title
---



## Architecture

<!--
@François - 13min

So fo this, we are going to take some simple use cases to go to the point.
We have a limited time, so we are going to intentionally leave some aspects aside. Notably the infrastructure part.

Show the code architecture :
- layered vs hexagonal architecture
- Ubiquitous language: instrument has a different form on the two BCs.
-->

---
layout: center
class: text-center
---

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
@François - 18min

Temps de codage : 7min
-->

---
layout: image-right
image: ../assets/bass.jpg
---



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
@François - 25min

An entity is an object with an identity and a lifecycle.
It is mutable, with a state that can evolve over time.

This is not a Hibernate entity, we are not talking about persistence here. This is not a data container. 
We are talking about a domain entity, with behavior and invariants that express the business intention.

The invariants part is very important, as it guarantees the cohesion of the state.
There are no setters, the only way to alter the state of the entity, is by using its behavior methods.

 - Show archunit tests
-->
---
layout: image-right
image: ../assets/bass.jpg
---

<div class="relative z-10">

<br>
<br>

## Entity

<br>
<br>
<br>

<h3 v-click>enforce invariants</h3>
<h3 v-click>increase consistency</h3>
<h3 v-click>decrease defensive code</h3>
<h3 v-click>prevent anemic objects</h3>

</div>


<!-- 
@François - 35min

-->





---
layout: center
class: text-center
---

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
@Thomas - 40min

Temps codage : 10min

-->

---
layout: image-right
image: ../assets/drums.jpg
---


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
@Thomas - 50min

A value Object is an object defined by its value. Two VO with the same value are equal.

They are immutables. We can't modify a vo, we need to create another one with the new value.

They don't have a lifecyle nor do they have their own identity. They only exist in the context of another entity.

TODO : take away (slide dédiée) + property archi
-->

---
layout: image-right
image: ../assets/bass.jpg
---


<div class="relative z-10">

<br>
<br>

## Value object

<br>
<br>
<br>

<h3 v-click>clarify the domain</h3>
<h3 v-click>validation centralized</h3>
<h3 v-click>reusable</h3>
<h3 v-click>easily testable</h3>

</div>


<!-- 
@Thomas - 55min

-->


---
layout: center
class: text-center
---

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
@Bastien - 60min

Poser la question: proposal est-il une entité ou un VO?

Temps de code : 20min

-->

---
layout: image-right
image: ../assets/guitar.jpg
---

<div class="relative z-10">

<br>
<br>

## The Aggregate

<br>
<br>
<br>

<h3 v-click>contains VO and/or entities</h3>
<h3 v-click>root is responsible for its invariants</h3>
<h3 v-click>guarantees consistency</h3>
<h3 v-click>defines transactional & structural boundaries</h3>
</div>

<!--
@Bastien - 1h20min

 Un Agrégat est un ensemble d'Entités et d'Objets Valeurs (Value Objects) qui forment une unité cohérente.
 
 La Racine d'Agrégat (Aggregate Root) est responsable de ses propres règles métiers (les invariants). Elle garantit la cohérence de l'ensemble du groupe.
 
 Elle définit à la fois des frontières structurelles et transactionnelles.
 
 Frontière structurelle :
  - Point d'entrée unique : Elle sert de point d'entrée unique pour accéder à n'importe quelle Entité ou Objet Valeur interne.
  - Cycle de vie lié : Si vous supprimez l'Annonce (Ad), les propositions (proposals) sont également supprimées.
  - Accès indirect : Vous n'accédez pas directement à la proposition : vous devez obligatoirement passer par l'Annonce.
 
 Frontière transactionnelle :
  - Cohérence immédiate : C'est du "tout ou rien".
  -  Exemple : Lorsque vous acceptez la proposition d'un musicien pour une annonce donnée, le prix de l'annonce est mis à jour et l'annonce passe au statut "vendue" exactement au même moment (dans la même transaction) en base de données.
  -  Sans agrégat : Si l'application plante pendant l'acceptation de la proposition, le prix pourrait être mis à jour et la proposition acceptée, mais l'annonce resterait toujours disponible (générant une incohérence).
 
 -->


---
layout: image-right
image: ../assets/drums.jpg
---

<div class="relative z-10">

<br>
<br>

## The Aggregate

<br>
<br>
<br>

<h3 v-click>secure multi-object invariants</h3>
<h3 v-click>consistency everywhere, no more defensive code</h3>
<h3 v-click>easier to test, easier to maintain</h3>
</div>

<!--
@Bastien - 1h32min

L'entité gère ses propres invariants, mais dès qu'une règle métier dit "Si l'entité A fait ceci, alors l'entité B doit faire cela", c'est l'agrégat qui prend le relais.
Eg. Lorsqu'une offre est acceptée, toutes les autres sont refusées

Plus de code défensif éparpillé partout pour valider les contraintes. C'est l'aggrégat qui s'en charge.
Eg. Plus "if not null" -> on a toujours un état cohérent

Résultat: plus facile à tester et maintenir
-->
