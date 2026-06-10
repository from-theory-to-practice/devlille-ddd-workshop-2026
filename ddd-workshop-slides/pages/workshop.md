---
layout: center
class: text-center
---

<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## Hands-on


<!--
@François - 13min

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
@François - 18min

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

<div class="absolute inset-0 w-1/2" style="background-image: url('../assets/backgrounds/background_3.svg'); background-size: cover;"></div>

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
@Thomas - 40min

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
@Thomas - 50min

A value Object is an object defined by its value. Two VO with the same value are equal.

They are immutables. We can't modify a vo, we need to create another one with the new value.

They don't have a lifecyle nor do they have their own identity. They only exist in the context of another entity.

TODO : take away (slide dédiée) + property archi
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
@Bastien - 60min

Poser la question: proposal est-il une entité ou un VO?

Temps de code : 20min

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
<h3 v-click>guarantees consistency</h3>
<h3 v-click>defines transactional & structural boundaries</h3>
</div>

<!--
@Bastien - 1h20min

An Aggregate is a cluster of Entities and Value Objects (VOs) that form a cohesive unit.

The Aggregate Root is responsible for its business rules (invariants). It guarantees the consistency of the entire group.

It defines both transactional and structural boundaries.

- structural boundary: 
  - It acts as the single entry point to access any internal Entity or VO.
  - if you remove the Ad, the proposals are removed to. 
  - You do not access the proposal directly: you need to ask the Ad.
- transactional boundary:
  - Immediate consistency: everything or nothing
  - when you accept a musician proposal for a given ad, the ad price is updated and the Ad is sold, in the exact same time in your database.
  - without aggregate: if the application crashes while accepting the proposal, the price would be updated; proposal accepted but Ad would still be available.
 
No more defensive code scattered everywhere to check rules—the Aggregate handles it all.

The result: Easier to test, easier to maintain.

TODO : take away (slide dédiée) + property archi

-->
