# MockaAPI

msbautista/mockapi is an application for creating endpoints with customizable json responses.
It's a tool when you need to mock an API for your frontend applications.

This app was built with Java Spring Boot for the Backend and Vue.js for the Frontend.

![image](https://user-images.githubusercontent.com/57375735/166621604-07552efa-9a45-4c9d-b7bc-c1542bed4ad0.png)

![image](https://user-images.githubusercontent.com/57375735/166621738-8f1fde36-264d-4b54-b955-f5b196db1487.png)

# Backend

## Requirements

* Java 11
* Intellij IDEA
* Postman for tests

## Run

Import project in Intellij IDEA u other editor and execute MockapiApplication.java.
You can also generate the project package `mvn package` and run with `java -jar target/mockapi-0.0.1-SNAPSHOT` .

## API

Create an endpoint [POST] `http://localhost:8000/addEndpoint`

```json
{
    "name": "anything/1",
    "body": {
        ...
    },
    "method": "POST"
}
```

* **name**: Corresponds to the path to call
* **body**: It is a json object to return when you call the path
* **method**: Request type to use. It can be GET or POST.

And ready! You can call the path and it will return configured object.

## Example

Send this request.


```json
{
"name": "GetCars/All/",
"body": {
    "cars": [
        {
        "id": 1,
        "name": "Ford"
        }
      ]
    },
"method": "POST"
}
```

This request generates this endpoint `http://localhost:8000/GetCars/All/` and when you send a POST, the application returns the following response:

```json
{
  "cars": [
    {
      "id": 1,
      "name": "Ford"
    }
  ]
}
 ```
 
# Frontend
 
## Requirements

 * Node.js and NPM
 
## Run

Open a terminal in the Frontend folder and enter `npm i` and then `npm run serve`.
you can also build index.html via `npm run build`.` .
 
