---
layout: image
image: ../assets/backgrounds/background_2.svg
backgroundSize: contain
---

<div class="flex flex-col justify-center items-center h-full gap-16">
  <img src="../assets/backstage_no_background.png" class="max-h-46 object-contain" />
  <div class="flex gap-24 items-center">
    <div class="flex flex-col items-center gap-2">
      <img src="../assets/francois.jpg" class="w-28 h-28 rounded-full object-cover" />
      <span class="speaker-tag">François 🎸</span>
    </div>
    <div class="flex flex-col items-center gap-2">
      <img src="../assets/bastien.jpg" class="w-28 h-28 rounded-full object-cover" />
      <span class="speaker-tag">Bastien 🎸 🥁</span>
    </div>
    <div class="flex flex-col items-center gap-2">
      <img src="../assets/thomas.png" class="w-28 h-28 rounded-full object-cover" />
      <span class="speaker-tag">Thomas 🎸🎤</span>
    </div>
  </div>
</div>

<!--
@François - 0min

An app for musicians. An app that would allow to showcase your studio, with your instruments, your sound presets, your amp configuration.

We thought that would be a great idea. 
But then we thought we could go further, and maybe add a marketplace around the studios.
Allowing musicians to publish ads to sell instruments. With a nice system to negotiate the prices (applying discount or making price proposal).
Maybe place an alert to be notified when your dream instrument is on sale.
And of course a secure payment system to finalize the deal.

Ok that's sounds like a great idea, with a great name, great features. And today we have great people to implement it for us.

So why don't we use the DDD methodology to do it?
-->

---
layout: image-right
image: ../assets/mixer.jpg
--- 


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

### <v-click> Apply a discount</v-click>

### <v-click> Make a price proposal</v-click>

### <v-click> Place an alert</v-click>

### <v-click> Pay</v-click>

</div>

<!--
@François - 7min

First thing first, what are the business concepts that we talked about?

-->
--- 
class: text-center big-title
layout: center
---


## UBIQUITOUS LANGUAGE


<!--
@Thomas - 9min

What we've just done here is establish a common language between us, developers, and the business experts. We call this the ubiquitous language.

-->
    

--- 
class: text-center
layout: center
---

![ubiquitous-language.png](../assets/ubiquitous-language.png)

<!--
@Thomas - 9min


We need to put explicit definitions to terms we use. When we're having a conversation, it can happen that we
don't understand words the same way the person we're talking to understands.
For instance, when we talk about a transaction, what do we mean by this ? A money transfer ? Goods ? Favors ?

It can also happen that the same meaning has different words ! (talk about adeo example)

As developers we can also introduce technical terms that don't mean much to non technical teams.

So what we want is alignment about vocabulary : strict and explicit definitions of the terms we use.
This alignment must be shared across all the people that interact with the domain.


-->



---
class: text-center big-title
layout: center
---

## Bounded Context

<!--
@Bastien - 11min

Comme l'a dit Thomas, un même mot peut avoir différentes définitions et modèles de données, en fonction du context.

Prenons l'exemple d'un livre
- Editeur (Contexte de Vente): C'est un produit commercial: ISBN, titre, auteur, prix, genre, date de publication.
- Transporteur (Context de Logistique): C'est un produit physique, un colis. L'histoire ne compte pas.  poids, dimensions, tracking barcode, palette de destination.
- Ecrivain (Contexte de Création): C'est un Manuscrit: nombre de mots, chapitres, personnages, état de progression  (brouillon, edité, approuvé).

C'est pour ça qu'on définit les Bounded Contexts.
Un Bounded Context c'est la frontière explicite à l'intérieur de laquelle un modèle de données spécifique et Ubiquitous Language s'appliquent.

➔ Le but: plus de "God Objects"—C'est énorme modèle de données dans lequel on veut tout faire rentrer de force.

-->

---
class: text-center
layout: center
---

<div class="absolute inset-0 flex items-center justify-center">
<img src="../assets/bounded-context.jpg" alt="bounded-context" class="h-full w-auto object-contain" />
</div>

<!--
@Bastien - 13min

Le context c'est important !

Toujours pas convaincu ?
-->
