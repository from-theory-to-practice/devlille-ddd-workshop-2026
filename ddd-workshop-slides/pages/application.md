---
layout: image
image: ../assets/backgrounds/background_2.svg
backgroundSize: contain
---

<style>
.speaker-tag {
  font-family: 'Montserrat', sans-serif;
  background-color: #222;
  color: white;
  padding: 0.4rem 1.2rem;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 0.05em;
  clip-path: polygon(2% 0%, 93% 5%, 100% 25%, 100% 79%, 85% 98%, 5% 100%, 0% 75%, 0% 21%);
}
</style>

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

### <v-click> Apply a discount</v-click>

### <v-click> Make a price proposal</v-click>

### <v-click> Place an alert</v-click>

### <v-click> Pay</v-click>

</div>

<!--
@François - 2min

First thing first, what are the business concepts that we talked about?

-->
--- 
class: text-center
layout: center
---

<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## UBIQUITOUS LANGUAGE


<!--
@Thomas - 4min

Ce qu'on vient de faire, c'est commencer à construire un langage commun entre nous, développeurs, et les experts métiers.

Le language ubiquitaire.

-->
    

--- 
class: text-center
layout: center
---

![ubiquitous-language.png](../assets/ubiquitous-language.png)

<!--
@Thomas - 4min

What we've just done here is establish a common language between us, developers, and the business experts.
We call this the ubiquitous language.

We need to put explicit definitions to terms we use. When we're having a conversation, it can happen that we
don't understand words the same way the person we're talking to understands.
For instance, when we talk about a transaction, what do we mean by this ? A money transfer ? Goods ? Favors ?

It can also happen that the same meaning has different words ! (talk about adeo example)

As developers we can also introduce technical terms that don't mean much to non technical teams.

So what we want is alignment about vocabulary : strict and explicit definitions of the terms we use.
This alignment must be shared across all the people that interact with the domain.


-->



---
class: text-center
layout: center
---
<div class="absolute inset-0" style="background-image: url('../assets/backgrounds/background_4.svg'); background-size: cover;"></div>

## Bounded Context

<!--
@Bastien - 6min

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
@Bastien - 7min

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
