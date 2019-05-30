# Weather App

Web App. which will return current weather data from OpenWeatherMap.org, based on a city chosen by the user.

Supported cities:
- London
- Hong Kong

## Getting Started

The application is located in a GitHub repository: 

```
https://github.com/pilarHdez/globantApplication
```

### Prerequisites

in order to get a copy of the project and run the app, you must have:

* Git
* Maven 
* Java 1.8

### Installing

Download the project or clone via GitHub:

```
git clone https://github.com/pilarHdez/globantApplication.git
```

Inside the project directory, you can build the project executing maven 'package' command

```
mvn clean package
```

Run the app executing maven 'spring-boot:run' command

```
mvn spring-boot:run
```

## Running the tests

Execute Unit tests with maven command

```
mvn clean test
```

## Deployment

Run the app executing maven 'spring-boot:run' command

```
mvn spring-boot:run
```

The application will start in the embedded spring-boot server at localhost on 8080 port, so you can go to the app by this url:

```
http://localhost:8080/
```

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - Elected Java Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Junit](https://junit.org/junit5/) - Unit Testing framework

# Personal notes

It was relatively easy to adopt Spring Boot coming from classic Spring. It really helps a lot in project setup.
The backbone of the application is implemented with Spring MVC, Spring Web and Spring REST, meanwhile the UI is built with the help of Thymeleaf.

The minimal unit tests to verify functionability were builded.

TO DO:

More tests can be added to improve the functionability. The more specific they are, the better the code quality is.

Use the more appropiated annotations provided by Spring Boot to reduce verbosity in the the codebase.

## Author

* **María del Pilar Hernández Bastida**

pilarhdezbst91@gmail.com
