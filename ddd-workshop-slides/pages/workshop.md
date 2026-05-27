---
layout: center
class: text-center
---

<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## Hands-on


<!--
@François - 8min

We did a quick introduction to one of the pillar of DDD, the strategic part. 
But today we want to code, and for this we have the tactical part, with many technical concepts.

As we don't want to enumerate them, we are going to take a naive approach in order to showcase some patterns.
-->

---
layout: center
class: text-center
---

<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>


## Architecture

<!--
@François - 8min

So fo this, we are going to take some simple use cases to go to the point.
We have a limited time, so we are going to intentionally leave some aspects aside. Notably the infrastructure part.

Show the code architecture :
- layered vs hexagonal architecture
- Ubiquitous langage: instrument has a different form on the two BCs.
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

An entity is an object with an identity and a lifecycle.
It is mutable, with a state that can evolve over time.

This is not a Hibernate entity, we are not talking about persistence here. This is not a data container. 
We are talking about a domain entity, with behavior and invariants that express the business intention.

The invariants part is very important, as it guarantees the cohesion of the state.
There are no setters, the only way to alter the state of the entity, is by using its behavior methods.
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

A valu Object is an object defined by its value. Two VO with the same value are equal.

They are immutables. We can't modify a vo, we need to create another one with the new value.

They don't have a lifecyle nor do they have their own identity. They only exist in the context of another entity.
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
