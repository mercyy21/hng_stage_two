# Official Documentation for this Repository

<b>Author - <b>Mercy Awopetu Tolulope</b>

This documentation provides instructions on how to use and interact with the API endpoints created

## Endpoints

### 1. Get Person by Name

-   **URL:** `/api/{name}`
-   **Method:** `GET`
-   **Description:** Retrieves details of a person by their name.
-   **Request Parameters:** `{name}` (String) -Name of the person
-   **Sample Request:** <code>curl -X GET http://localhost:8080/api/john</code>
-   **Expected Response (200 OK):**

```json
[
	{
		"id": 1,
		"name": "John Doe"
	}
]
```

### 2. Get Person by ID

-   **URL:** `/api/{user_id}`
-   **Method:** `GET`
-   **Description:** Retrieves details of a person by their ID.
-   **Request Parameters:** `{user_id}` (Long) -User ID of the person
-   **Sample Request:** <code>curl -X GET http://localhost:8080/api/1</code>
-   **Expected Response (200 OK):**

```json
[
	{
		"id": 1,
		"name": "John Doe"
	}
]
```

### 3. Create Person

-   **URL:** `/api/`
-   **Method:** `POST`
-   **Description:** Creates a new person.
-   **Request Body:** JSON object with `name` (String)
-   **Sample Request:** <code>curl -X POST -H "Content-Type: application/json" -d '{"name": "Alice Johnson"}' http://localhost:8080/api</code>
-   **Expected Response (201 Created):**

```json
[
	{
		"id": 4,
		"name": "Alice Johnson"
	}
]
```

### 4. Update person

-   **URL:** `/api/{user_id}`
-   **Method:** `PUT`
-   **Description:** Updates details of an existing person by their ID.
-   **Request Parameters:** `{id}` (Long) - ID of the person.
-   **Request Body:** JSON object with updated `name` (String).
-   **Sample Request:** <code>curl -X PUT -H "Content-Type: application/json" -d '{"name": "Alice Smith"}' http://localhost:8080/api/4</code>
-   **Expected Response (200 OK)**

```json
{
	"id": 4,
	"name": "Alice Smith",
	"age": 26
}
```

### 5. Delete Person

**URL:** `/api/{user_id}`

-   **Method:** `DELETE`
-   **Description:** Deletes details of a person by their ID.
-   **Request Parameters:** `{id}` (Long) - ID of the person.
-   **Sample Request:** <code>curl -X DELETE http://localhost:8080/api/4</code>
-   **Expected Response (204 No Content)**: No response body
    <br></br>

## Limitations and Assumptions

-   Error handling and validation for other use cases are not extensively covered in this API but should be implemented for a production-ready API
-   The name property is not sufficient enough to describe a person, other properties should be added on in the future.
    <br></br>

## Setting up and Deploying the API

To set up and deploy the API follow these steps:

1. Clone the GitHub Repository: [Link to Repository](https://github.com/mercyy21/hng_stage_two.git).
2. Navigate to the project directory.
3. Configure your database connection in `application.properties`.
4. Build the project using maven or your preferred build tool.
5. Run the application.
6. Your API should be accessible at <link>http://localhost:8080/api</link>

For more detailed instructions on how to interact with the endpoints, please refer to the README.md in the repository
<br></br>

**Live Link to the API:** [Link]()

**A link to the UML Class Diagram can also be found here:**
[UML Diagram](https://drive.google.com/file/d/1wIGht3h9LrMZklhveeegIzSvQIdHVUzn/view?usp=sharing)
