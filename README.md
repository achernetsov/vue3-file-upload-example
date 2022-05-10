# Overview

Example of uploading file from Vue 3 frontend app (typescript, composition API) and JS Fetch API.

How to run:
1. Start backend (inside backend directory): ```./mvnw quarkus:dev```
2. Install front dependencies (inside frontend directory): ```npm i```
3. Start frontend (inside frontend directory): ```npm run dev```
4. Fill description and attach file and click "Send", you'll see server response with description and file size.

# Frontend

Initialized using vitejs, see https://vitejs.dev/guide/

```shell
$ npm create vite@latest
✔ Project name: … frontend
✔ Select a framework: › vue
✔ Select a variant: › vue-ts
```