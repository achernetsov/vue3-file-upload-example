<script setup lang="ts">
import { ref } from 'vue';

const description = ref('')
const file = ref()

const serverResponse = ref('')

function send() {
  console.log(`sending file ${file.value} with description=${description.value}...`)

  const formData = new FormData();
  formData.append("description", description.value)
  formData.append("file", file.value.files[0])

  var requestOptions = {
    method: 'POST',
    body: formData
  };

  fetch('/api/file', requestOptions)
    .then(response => response.text())
    .then(data => {
      console.log(data)
      if (data!=null){
          serverResponse.value = data
      }
    })
    .catch(err => console.error(err))
}
</script>

<template>
  <label>description:</label>
  <input v-model="description" />
  <br />
  <label>file:</label>
  <input ref="file" type="file" />
  <br />
  <button @click="send">Send</button>
  <br>
  <p><label>Server response: </label>{{serverResponse}}</p>
</template>
