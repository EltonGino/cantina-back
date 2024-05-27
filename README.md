# Cantina Back

This is a backend service for a restaurant application, built with Java and Spring Boot.

## Features

- User Authentication and Authorization with Spring Security
- Data persistence with Spring Data MongoDB
- RESTful API endpoints for managing orders and shopping carts

## Prerequisites

- Java 17
- MongoDB

## Getting Started

1. Clone the repository:

git clone https://github.com/EltonGino/cantinaback.git

2. Navigate to the project directory:

cd cantinaback

3. Run the application:

./gradlew build

4. Run the application:

./gradlew bootRun

## API Endpoints

- `/orders/**`: Endpoints for managing orders. Requires authentication.
- `/carts/**`: Endpoints for managing shopping carts. Requires authentication.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
