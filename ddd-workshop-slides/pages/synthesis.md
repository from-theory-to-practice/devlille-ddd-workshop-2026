---
layout: center
class: text-center
---

## Wrap-up

<!--
@François - 1h35min

Ok, we only scratched the surface, we didn't even talk about domain services, repositories or events.
But that would be for another workshop (maybe season 2)

-->

---
layout: image-left
image: ../assets/guitar.jpg
---
<div class="relative z-10">

<br>
<br>

## Domain Driven Design

<br>
<br>
<br>

<h3 v-click>Not a framework...</h3>
<h3 v-click>More like a toolbox</h3>
<h3 v-click>Not only code</h3>
<h3 v-click>Iterative</h3>
</div>

<!--
@François - 1h35min

DDD is not a framework, but more like a toolbox, with patterns at different levels of abstraction,
not only in code but also in the way we work together, as a culture.

This is not a silver bullet (CRUD can be more relevant)

Iterative, as it models the business understanding, and business evolves, and understanding evolve.
So we have to discuss with business experts, and build our model with them.
And a model is not only in the code...

-->

---
layout: image
image: ../assets/event-storming.png
backgroundSize: contain
---

<!--
@François - 1h39min

Everything was here, for example in an event storming workshop.
This is where the strategic patterns shine. To make the domain explicit, and model it together.
-->

---
layout: image-left
image: ../assets/drums.jpg
---
<div class="relative z-10">

<br>
<br>

## Takeaways 

<br>
<br>
<br>

<h3 v-click>Explicit the knowledge</h3>
<h3 v-click>Focus on core domain</h3>
<h3 v-click>Start with simple patterns</h3>
<h3 v-click>Move invariants</h3>

</div>
<!--
@François - 1h40min

So what can you take away from this workshop?

- Explicit the knowledge, and make it explicit for everyone with ubiquitous langage. "Make the implicit explicit".
- Identify your bounded contexts. Focus on the core domain, and don't be afraid to start with a small part of it.
- Don't try to use all the patterns at once. You can start with value objects, and then move forward. 
Value objects give you a better testability, with less code and less accidental complexity.
- Move invariants. Using entities prevents from having anemic objects, 
with a better consistency and less defensive code.
- Keep in mind that DDD is a journey.

-->
