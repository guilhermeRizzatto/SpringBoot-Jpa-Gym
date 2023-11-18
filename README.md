# SpringBoot-Jpa-Gym
<strong>(If you see any problems with this text, talk to me, I want to write all in English to training and improve my English)</strong>

This project is made in Java using Spring Boot and JPA. It's an API for a gym.

How it works?

This is made for a gym, so you can **ADD, GET, UPDATE**, and **DELETE** </strong> a *member (GymMembership)*, and your *Registration*, also a *Trainer* with your *WorkLoad* and your *Work Days (WEEKDAYS ENUM)*,
And there exists a *Workout* that connects them (*GymMembership* and the *trainer* who made the *Workout* for him). The *Workout* has the *Exercise* (association class) which contains a number of Sets and interval time in seconds, and to finish *ExerciseType* which has muscle group and the name of the exercise.

All the Classes you can **ADD, GET, UPDATE, and DELETE**, less the *Registration* and *WorkLoad* which are deleted together with *GymMembership(to Registration)* or *Trainer(to WorkLoad)*.

**UPDATES I WANT TO DO IN THIS PROGRAM:<br>**
- [ ] Implements GET ALL in all Classes with a Pagination system.<br>
- [ ] Deploy the DataBase in Cloud<br>
- [ ] Deploy the program in any cloud system, for example AWS.<br>
- [ ] Refactor some parts of the code, to make it more clean to read.<br>
- [x] Exceptions Handling

**CHALLENGINGS I HAVE FOUNDED DURING DEVELOPMENT:<br>**
* I used the option: jpa-open-in-view = false, this made my development very hard to get the entities with your association, and the way I decided to solve this, is to make **JPQL** and **Native SQL** queries in each Classes Repositories. It is not the best and prettiest code to read, but it works and I want to improve this code in the future.<br>
* Made a DataBase in a Virtual Machine (Oracle Linux) and connect the program because don't they teach us how to connect in a database that is not on your localHost.I never do it before, so it was challenging for me.<br>
* Making the diagram of the Classes,is difficult but I learned a lot from it, because it makes me think more about in program structure and how the classes would connect.<br>
-------------------------------------------------------------------

Follow the diagram of the classes below:

![Classe UML - GYM ATUALIZADO](https://github.com/guilhermeRizzatto/SpringBoot-Jpa-Gym/assets/126302322/5d3de174-bea8-4d82-984a-d50ddaceb6af)



-------------------------------------------------------------------
<p>🚀 Technologies used: </p>
<p>Spring Boot Web</p>
<p>JPA</p>
<p>Postgres SQL</p>
<p>ORACLE Linux (used to host the test database)</p>
------------------------------------------------------------------- <br>
<p>🔧 Tools used: </p>
<p>Spring Tool Suite 4</p>
<p>Dbeaver</p>
<p>Postman</p>
<p>VMware</p>
