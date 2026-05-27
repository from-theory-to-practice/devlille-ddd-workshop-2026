---
# try also 'default' to start simple
theme: default
# random image from a curated Unsplash collection by Anthony
# like them? see https://unsplash.com/collections/94734566/slidev
background: ./assets/backgrounds/title.svg
# some information about your slides (markdown enabled)
title: Adeo dev summit - DDD Workshop
info: |
  ## Slides from the DDD Workshop

# apply UnoCSS classes to the current slide
class: text-center
# https://sli.dev/features/drawing
drawings:
  persist: false
# slide transition: https://sli.dev/guide/animations.html#slide-transitions
transition: slide-left
# enable MDC Syntax: https://sli.dev/features/mdc
mdc: true

---


<div class="talk-card">
  <div class="talk-card__title-wrapper">
    <div class="talk-card__title-line">
      <span class="talk-card__title-highlight">DDD</span>
    </div>
    <div class="talk-card__title-word">HANDS-ON</div>
  </div>
  <div class="talk-card__subtitle">From theory to practice</div>
</div>  


 <style>

.talk-card__title-wrapper {
  font-family: 'Montserrat', sans-serif;
  font-weight: 800;
  line-height: 1;
  letter-spacing: -1px;
}

.talk-card__title-line {
  margin-bottom: 0.15em;
}

.talk-card__title-highlight {
  background: #9b6ee0;
  color: #fff;
  padding: 0.12em 0.3em;
  display: inline-block;
  font-size: clamp(48px, 8vw, 88px);
  text-transform: uppercase;
}

.talk-card__title-word {
  color: #fff;
  font-size: clamp(48px, 8vw, 88px);
  text-transform: uppercase;
}

.talk-card__subtitle {
  font-family: 'Montserrat', sans-serif;
  font-weight: 800;
  font-size: clamp(18px, 2.5vw, 30px);
  color: #c0c8d8;
  text-transform: uppercase;
  letter-spacing: 3px;
  margin-top: 1.2rem;
  text-align: center;
}

@font-face {
  font-family: 'Montserrat';
  src: url('./assets/fonts/Montserrat-VariableFont_wght.ttf') format('woff2');
  font-weight: 100 900;
  font-style: normal;
}
 h2 {
    font-family: 'Montserrat', sans-serif;
    display: inline-block;
    background-color: #222; 
    color: white;
    padding: 0.8rem 2rem;
    font-size: 2.5rem; 
    font-weight: 900; 
    text-transform: uppercase; 
    letter-spacing: 0.05em;
    clip-path: polygon(
        2% 0%,   /* Point en haut à gauche */
        93% 5%,  /* Point en haut à droite */
        100% 25%, /* Point milieu-droit (haut) */
        100% 79%, /* Point milieu-droit (bas) */
        85% 98%, /* Point en bas à droite */
        5% 100%,  /* Point en bas à gauche */
        0% 75%,  /* Point milieu-gauche (bas) */
        0% 21%   /* Point milieu-gauche (haut) */
    );
  }
 h3 {
    font-family: 'Montserrat', sans-serif;
  }
 h1 {
    font-family: 'Montserrat', sans-serif;
  }
 p {
    font-family: 'Montserrat', sans-serif;
  }
 span {
    font-family: 'Montserrat', sans-serif;
    font-size: 1.2rem;
  }
  </style>

<!--
Are there any musicians in the room?

We love music and instruments, and today we are going to talk about an app we thought about: backstage

-->

---
src: ./pages/application.md
hide: false
---

---
src: ./pages/workshop.md
hide: false
---

---
src: ./pages/synthesis.md
hide: false
---

---
layout: image
image: ../assets/backgrounds/thankyou.svg
class: text-center
---

<div class="absolute inset-0 flex flex-col items-center gap-10 z-10" style="padding-top: 13%;">

<p style="font-family: 'Montserrat', sans-serif; font-weight: 800; font-size: 2rem; text-transform: uppercase; letter-spacing: 3px; color: #fff; margin: 0;">To go further</p>

<div class="flex gap-24 justify-center items-start mt-6">
  <div class="flex flex-col items-center gap-4">
    <h3>Resources</h3>
    <img src="./assets/resources_qr_code.svg" class="w-44 h-44" />
  </div>
  <div class="flex flex-col items-center gap-4">
    <h3>Quiz</h3>
    <img src="./assets/quiz_qr_code.svg" class="w-44 h-44" />
  </div>
</div>

</div>

<!--
@Thomas - 1h28min

-->
