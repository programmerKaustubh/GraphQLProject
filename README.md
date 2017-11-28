# GraphQLProject
-----------------------

**What can it do**
--------------
Fetching a data from Facebook's sample GraphQL schema and the local database of Star Wars objects to display in RecyclerView(Grids) using fragments and Activity.

The Star Wars GraphQL API includes queries for the following objects, all of which directly inherits from the 'Node' Object:

 - List item
 - Film
 - Person
 - Planet
 - Species
 - Vehicle
 - Starship

Displaying the information using standard Master/detail flow. Master View displays a grid of Film objects using RecyclerView, while the detail view is displayed using DialogFragments.

**Technology/Libraries Used:**
--
 1. Apollo client: https://github.com/apollographql/apollo-client
 2. Butter Knife 2.0: https://github.com/JakeWharton/butterknife
 3. GraphQl: http://graphql.org/
 4. (For Local Data-base): https://github.com/graphql/swapi-graphql
 5. npm (package manager): https://www.npmjs.com/

**How To Run this projects**
---
(Make sure you have npm installed to install and run Star Wars Swapi-API)

 1. Download this project to your computer
 2. Download Facebook's Star Wars Swapi-API: https://github.com/graphql/swapi-graphql (check some previous issues, if you having same issue(s) while running this project on window operating system)
 3. In Node.js command prompt change directory to downloaded Star Wars directory
 4. Install Star Wars on your computer by running following command in npm: 
> `npm install`

 5. And run with:
> `npm run`

 6. copy and paste link displayed in your Node.js command prompt to Apollo Client's BASE_URL
    (check your IP address to replace with the localhost text in your Android project)
> `http://localhost:3000/graphql`

 7. Run the Android project

**Getting Started**
-------------------
This sample uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio.

**Bugs**
----

**Screenshots**
---------------
<img src="https://user-images.githubusercontent.com/25395705/33304682-3170b8d8-d3d8-11e7-8a2b-633838c2ed74.png" width="50%" height="50%">
<img src="https://user-images.githubusercontent.com/25395705/33304683-31f83f1a-d3d8-11e7-8957-e5da8b0b44fb.png" width="50%" height="50%">
<img src="https://user-images.githubusercontent.com/25395705/33304684-3211027a-d3d8-11e7-9cac-5316580cb184.png" width="50%" height="50%">
<img src="https://user-images.githubusercontent.com/25395705/33304685-322a20f2-d3d8-11e7-8659-99c38542b3b1.png" width="50%" height="50%">

![ezgif com-video-to-gif 3](https://user-images.githubusercontent.com/25395705/33102881-dd8fd248-ceec-11e7-80c9-51dc6bab494c.gif)
![ezgif com-video-to-gif 7](https://user-images.githubusercontent.com/25395705/33103712-f46b0d2a-cef1-11e7-9f13-37da17da4918.gif)
![ezgif com-video-to-gif 6](https://user-images.githubusercontent.com/25395705/33103713-f4858f92-cef1-11e7-8077-818368fe1ac7.gif)
![ezgif com-video-to-gif 4](https://user-images.githubusercontent.com/25395705/33103714-f4a0129a-cef1-11e7-816b-45b1ca4a130a.gif)



**Find More Information on**
------------------------

 - kaustubhmemane.com


