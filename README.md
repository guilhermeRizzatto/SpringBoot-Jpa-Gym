# SpringBoot-Jpa-Gym
<strong>(If you see any problems with this text, talk to me, I want to write all in English to training and improve my English)</strong>

This project is made in Java using Spring Boot and JPA. It's an API for a gym.

How it works?

This is made for a gym, so you can **ADD, GET, UPDATE**, and **DELETE** </strong> a *member (GymMembership)*, and your *Registration*, also a *Trainer* with your *WorkLoad* and your *Work Days (WEEKDAYS ENUM)*,
And there exists a *Workout* that connects them (*GymMembership* and the *trainer* who made the *Workout* for him). The *Workout* has the *Exercise* (association class) which contains a number of Sets and interval time in seconds, and to finish *ExerciseType* which has muscle group and the name of the exercise.

All the Classes you can **ADD, GET, UPDATE, and DELETE**, less the *Registration* and *WorkLoad* which are deleted together with *GymMembership(to Registration)* or *Trainer(to WorkLoad)*.

**UPDATES I WANT TO DO IN THIS PROGRAM:<br>**
- [x] Implements GET ALL in all Classes with a Pagination system.<br>
- [x] Deploy the DataBase in Cloud<br>
- [x] Deploy the program in any cloud system, for example AWS.<br>
- [ ] Refactor some parts of the code, to make it more clean to read.<br>
- [x] Exceptions Handling
- [ ] Make the documentation in Swagger

**CHALLENGINGS I HAVE FOUNDED DURING DEVELOPMENT:<br>**
* I used the option: jpa-open-in-view = false, this made my development very hard to get the entities with your association, and the way I decided to solve this, is to make **JPQL** and **Native SQL** queries in each Classes Repositories. It is not the best and prettiest code to read, but it works and I want to improve this code in the future.<br>
* Made a DataBase in a Virtual Machine (Oracle Linux) and connect the program because most courses don't teach us how to connect to a database that is not on your localHost.I had never done it before, so it was challenging for me.<br>
* Making the diagram of the Classes, is difficult but I learned a lot from it because it makes me think more about the program structure and how the classes would connect.<be>


**How to use:**
<br>
* unfortunately, it's not possible to use more, it was hosted on AWS, but they charged me. I don't want to spend money on hosting a testing project, sorry.

### METHODS AND YOUR RESPONSES (click on "Methods Documentation") ↴
<details>
  <summary>Methods Documentation</summary>
<br>
				
**IMPORTANT** <br>
`To post Registration, first need to post GymMembership, the same to WorkLoad and Trainer, and Workout needs to have GymMembership and Trainer already posted
Exercise needs ExerciseType and Workout posted first also`

***PLEASE DO NOT POST ANY ENTITIES WITH ANY PARAMETERS EMPTY, THIS WILL BREAK SOME METHODS*** 

To delete GymMembership, deletes your Workout associated
<br>

-----------------------------------------------------------------------------------------------------------
<details>
	<summary>GymMembership</summary>
	
### GET GymMembership
  ```http
  GET /gymMembers
  ```
  ```http
  GET /gymMembers/{id} (id basically is a number, example: 7 , so /gymMembers/7)
  ```


  **Response**
  ```javascript
  {
    "id" : long,
    "name" : string,
    "phone" : string
    "age" : int
    "weight" : double
    "height" : double
  }
  ```

 ### GET GymMembership with your Workout:
  ```http
  GET /gymMembers/withWorkout
  ```
  ```http
  GET /gymMembers/withWorkout/{id}
  ```

**Response**
```javascript
  {
    "id" : long,
    "name" : string,
    "phone" : string
    "age" : int
    "weight" : double
    "height" : double
    "workout": {
        "id": long,
        "description": string,
        "trainer": {
            "id": long,
            "name": string,
            "email": string
        },
        "exercises": [
            {
                "exerciseType": {
                    "id": long,
                    "name": string,
                    "muscleGroup": string
                },
                "sets": int,
                "reps": int,
                "intervalSeconds": int
            }
	]
    }
  }
  ```

  ```http
  POST /gymMembers
  ```
  To post send this json: 
  
  ```javascript
  {
    "name" : string,
    "cpf" : string,
    "phone" : string,
    "age" : int,
    "weight" : double,
    "height" : double
  }
  ```
  ```http
  PATCH /gymMembers/patch/{id}
  ```
  To patch send a json with the part which you want to update

  ```http
  DELETE /gymMembers/delete/{id}
  ```

  
 
</details>

<details>
	<summary>Registration</summary>
	
### GET Registration

  ```http
  GET /registrations/
  ```
  ```http
  GET /registrations/{id}
  ```
 **Response**
  ```javascript
  {
    "id": long,
    "registrationDate": date (example: "2023-07-19"),
    "monthlyPeriod": int,
    "price": double,
    "installment": int,
    "valid": boolean,
    "installmentPrice": double,
    "gymMembership": {
        "id": long,
        "name": string,
        "cpf": string,
        "phone": string
    }
  }
  ```
  ```http
  POST /registrations
  ```
  To post send this json: 
  
  ```javascript
  {   
    "registrationDate" : dateTime (example: "2023-12-22T10:56:57"),
    "monthlyPeriod" : int,
    "price" : double,
    "installment" : int,
    "gymMembership" : {
        "id" : long
    }
  }
  ```
  ```http
  PATCH /registrations/patch/{id}
  ```
  To patch send a json with the part which you want to update

 `When you delete a GymMembership, your Registration associated deletes together`


</details>


<details>
	<summary>WorkLoad</summary>

### GET WorkLoad
  ```http
  GET /workLoads/
  ```
  ```http
  GET /workLoads/{id}
  ```
  **Response**
  ```javascript
  {
    "id": long,
    "entryTime": time (example: 11:00:00),
    "departureTime": time,
    "trainer": {
        "id": long,
        "name": string,
        "email": string
    },
    "days": [
	WeekDays Enums (example:)
        "MONDAY",
        "SUNDAY",
        "THURSDAY"
    ]
  }
  ```
  ```http
  POST /workLoads
  ```
  To post send this json: 
  
  ```javascript
  {
   
    "entryTime" : time (example: 11:00:00),
    "departureTime" : time,
    "trainer" : {
        "id" : long
    },
    "days" : [
        WeekDays Enums
    ]
}
  ```
  ```http
  PATCH /workLoads/patch/{id}
  ```
  To patch send a json with the part which you want to update

 `When you delete a Trainer, your WorkLoad associated deletes together`

 
</details>


<details>
  <summary>Trainer</summary>
  
  ### GET Trainer
  ```http
  GET /trainers/
  ```
  ```http
  GET /trainers/base/{id}
  ```
  **Response**
  ```javascript
  {
    "id": long,
    "name": string,
    "email": string
  }
  ```
  
  ### GET Trainer with your WorkLoad and Workout
  ```http
  GET /trainers/full
  ```
  ```http
  GET /trainers/full/{id}
  ```
  **Response**
  ```javascript
  {
    "id": long,
    "name": string,
    "email": string,
    "workLoad": {
        "id": long,
        "entryTime": time (example: 11:00:00),
        "departureTime": time,
        "days": [
            WeekDays Enums
        ]
    }
    "workouts": [
        {
            "id": long,
            "description": string,
            "gymMembership": {
                "id": long,
                "name": string,
                "phone": string,
                "age": int,
                "weight": double,
                "height": double
            }
        }]
  }
  ```
  ```http
  POST /trainers
  ```
  To post send this json: 
  
  ```javascript
  {
    "name": string,
    "email": string
  }
  ```
  
  ```http
  PATCH /trainers/patch/{id}
  ```
  To patch send a json with the part which you want to update
  
  ```http
  DELETE /trainers/delete/{id}
  ```


</details>


  <details>
    <summary>Workout</summary>
    
  ### GET Workout
  ```http
  GET /workouts/
  ```
  ```http
  GET /workouts/base/{id}
  ```
  **Response**
  ```javascript
    {
        "id": long,
        "description": string,
        "gymMembership": {
            "id": long,
            "name": string,
            "phone": string,
            "age": int,
            "weight": double,
            "height": double
        },
        "trainer": {
            "id": long,
            "name": string,
            "email": string
        }
    }
  ```
  ### GET Workout with your GymMembership, Trainer and Exercises
  ```http
  GET /workouts/full/
  ```
  ```http
  GET /workouts/full/{id}
  ```
   **Response**
  ```javascript
    {
        "id": long,
        "description": string,
        "gymMembership": {
            "id": long,
            "name": string,
            "phone": string,
            "age": int,
            "weight": double,
            "height": double
        },
        "trainer": {
            "id": long,
            "name": string,
            "email": string
        },
        "exercises": [
            {
                "exerciseType": {
                    "id": long,
                    "name": string,
                    "muscleGroup": string
                },
                "sets": int,
                "reps": int,
                "intervalSeconds": int
            }
        ]
    }
  ```

  ```http
  POST /workouts
  ```

  To post send this json: 
  
  ```javascript
  {
	"description" : string,
	"gymMembership" : {
        "id" : long
    },
	"trainer" : {
        "id" : long
    }
  }
  ```

  ```http
  PATCH /workouts/patch/{id}
  ```
  To patch send a json with the part which you want to update
  
  ```http
  DELETE /workouts/delete/{id}
  ```
  </details>


  <details>
    <summary>Exercise</summary>
    
  ```http
  GET /exercises/byWorkout/{workoutId} (you can only get all the exercises that are in this workout, because they are linked to the workout that has them)
  ```

  **Response**
  ```javascript
  [
    {
        "exerciseType": {
            "id": long,
            "name": string,
            "muscleGroup": string
        },
        "sets": int,
        "reps": int,
        "intervalSeconds": int
    }
  ]
  ```

  ```http
  POST /exercises
  ```

  To post send this json: 
  
  ```javascript
  {
    "exerciseType" : {
        "id" : long
    },
    "workout" : {
        "id" : long
    },
    "sets" : int,
    "reps" : int,
    "intervalSeconds" : int
  }
  ```
  ```http
  PATCH /exercises/patch/workout/{workoutId}/exerciseType/{exerciseTypeId}
  ```
  To patch send a json with the part which you want to update, example:
  ```javascript
  {
    "sets" : 3,
    "reps" : 8
  }
  ```
  
  ```http
  DELETE /exercises/delete/workout/{workoutId}/exerciseType/{exerciseTypeId}
  ```
  </details>

<details>
<summary>ExerciseType</summary>
	
### GET ExerciseType
  ```http
  GET /exerciseTypes/
  ```
  ```http
  GET /exerciseTypes/{id}
  ```
  **Response**
  ```javascript
  {
    "id": long,
    "name": string,
    "muscleGroup": string
  }
  ```
  ```http
  POST /exerciseTypes
  ```
  To post send this json: 
  
  ```javascript
  {
    "name": string,
    "muscleGroup": string
  }
  ```

  ```http
  PATCH /exerciseTypes/patch/{id}
  ```
  To patch send a json with the part which you want to update
  
  ```http
  DELETE /exerciseTypes/delete/{id}
  ```
</details>





</details>







-------------------------------------------------------------------

Follow the diagram of the classes below:

![Classe UML - GYM ATUALIZADO](https://github.com/guilhermeRizzatto/SpringBoot-Jpa-Gym/assets/126302322/5d3de174-bea8-4d82-984a-d50ddaceb6af)



-------------------------------------------------------------------
<p>🚀 Technologies used: </p>
<p>Spring Boot Web</p>
<p>JPA</p>
<p>Postgres SQL</p>
<p>ORACLE Linux (used to host the test database)</p>
<p>SupaBase to host Postgres Database</p>
<p>AWS to deploy</p>
------------------------------------------------------------------- <br>
<p>🔧 Tools used: </p>
<p>Spring Tool Suite 4</p>
<p>Dbeaver</p>
<p>Postman</p>
<p>VMware</p>
