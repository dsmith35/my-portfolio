// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function getEmoji() {
    const responseFromServer = await fetch('/emoji');
    const emoji_list = await responseFromServer.json()
    rand_num = Math.floor(Math.random() * emoji_list.length);
    
    const container = document.getElementById('emoji-container');
    container.innerText = String.fromCodePoint(emoji_list[rand_num]);
}

async function getGalleryPhotos() {
    const responseFromServer = await fetch('/gallery');
    const container = document.getElementById('gallery-container');
    const photos = await responseFromServer.json()
    for (let i = 0; i < photos.length; i++) {
        const newImg = document.createElement("img");
        newImg.src = "../images/gallery/"+photos[i];
        newImg.width = 300;
        newImg.height = 400;
        container.appendChild(newImg);
    }
}

async function getMessages() {
    const responseFromServer = await fetch('/list-messages');
    const container = document.getElementById('messages-container');
    const entries = await responseFromServer.json()
    for (let i = 0; i < entries.length; i++) {
        const newMsg = document.createElement("div");
        newMsg.classList.add("message")
        newMsg.textContent = entries[i].msg;
        container.appendChild(newMsg);
    }
}

function redirectToSplashPage() {
    location.href="pages/Splash.html"
}