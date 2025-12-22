# Tic-Tac-Toe AOP System

## Overview
The Tic-Tac-Toe AOP System is a modular Java command-line backend application that implements a complete two-player Tic-Tac-Toe game with robust input handling, deterministic game rules, and clean separation of concerns.
The project emphasizes backend engineering principles such as domain modeling, testable business logic, build tooling, and the use of Aspect-Oriented Programming (AOP) to modularize cross-cutting concerns. Rather than embedding validation and rule enforcement directly into the game loop, these responsibilities are cleanly separated using AspectJ.
This project is designed as a backend-focused case study, not a UI exercise.

---

## Features
- Two-player Tic-Tac-Toe game with a 3×3 board
- Deterministic win and draw detection
- Centralized, testable rules engine
- Aspect-Oriented Programming for input interception and rule enforcement
- Graceful exit support at all user input points
- Clean restart flow without nested game loops
- Optional reuse of player names between games
- Maven-based build with AspectJ weaving
- Automated unit tests for core game rules
- Runnable command-line application

---

## Architecture Overview
The system follows a layered, object-oriented architecture with AspectJ-based cross-cutting concerns.

### Controller / Application Layer
#### TicTacToe
- Orchestrates game setup, player flow, and the main game loop
- Handles player name input and restart behavior
- Delegates move input and rule evaluation to specialized components

### Domain Model  

#### Board
- Represents the 3×3 game grid
- Encapsulates board state and rendering logic

#### Player
Represents a player with a name and assigned symbol (`X` or `O`)

### Game Rules Engine
#### GameRules
- Pure, stateless rules engine
- Determines:
- - Win conditions
- - Draw conditions
- Completely decoupled from I/O and UI logic
- Fully unit-tested
This separation allows game rules to be tested independently of user interaction or AOP behavior.
 
### Validation & Cross-Cutting Concerns (AOP)
AspectJ is used to modularize cross-cutting concerns without polluting core game logic.
#### InputAspect
- Intercepts calls to InputHandler.getPlayerMove
- Redirects input handling to centralized validation logic
#### RefereeAspect
- Triggers rule evaluation after each move
- Delegates win/draw detection to GameRules
This design enforces correctness consistently while keeping the core game loop simple and readable.
 
### Restart & Session Management
#### RestartGame
- Handles end-of-game prompts
- Ensures clean restarts without recursive or nested loops
#### PlayerSession
- Stores last-used player names
- Allows optional reuse of players on restart
- Keeps session state explicit and controlled

---

## Repository Structure  
The project follows the standard Maven directory layout:
```bash
tic-tac-toe-aspect-oriented-java/
├── pom.xml
├── README.md
├── LICENSE
└── src/
    ├── main/
    │   ├── java/
    │   │   └── tictactoe/
    │   │       ├── Board.java
    │   │       ├── GameRules.java
    │   │       ├── InputHandler.java
    │   │       ├── InputValidator.java
    │   │       ├── Player.java
    │   │       ├── PlayerSession.java
    │   │       ├── Referee.java
    │   │       ├── RestartGame.java
    │   │       └── TicTacToe.java
    │   └── aspectj/
    │       └── game_aspects/
    │           ├── AspectOrder.aj
    │           ├── InputAspect.aj
    │           ├── RefereeAspect.aj
    │           └── TurnAspect.aj
    └── test/
        └── java/
            └── tictactoe/
                └── GameRulesTest.java
```
#### Notes:
- Production code lives under src/main/java
- AspectJ aspects live under src/main/aspectj
- Tests live under src/test/java and run with mvn test

---

## Error Handling Strategy
The system enforces correctness and resilience through:

- Defensive validation of all user input
- Graceful handling of invalid moves
- Explicit exit support during:
- - player name entry
- - row input
- - column input
- Fail-fast behavior if AspectJ weaving is not active
- Clean termination paths without orphaned input loops

Invalid input never crashes the application and is always handled safely.

---

## Build & Run
The project is a static site and does not require a backend or build step.

### Prerequisites
- Java 17+  
- Maven 3.8+

### Build  
```bash
mvn clean package  
```

### Run 
```bash
mvn exec:java  
```

The application runs entirely in the terminal and guides the user through:
- Player setup
- Turn-based move entry
- Win/draw detection
- Restart or exit flow 

---

## Tools & Technologies  
- **Language**: Java 17  
- **Build Tool**: Maven  
- **Aspect-Oriented Programming**: AspectJ  
- **Testing**: JUnit 5  
- **Architecture Style**: Layered backend architecture  
- **Execution Model**: Command-line application

---

## Purpose  
This project serves as a backend engineering case study demonstrating:
- Separation of concerns using Aspect-Oriented Programming
- Clean domain modeling and testable business logic
- Deterministic rule evaluation independent of UI flow
- Defensive input handling
- Proper build tooling and dependency management
- Incremental refactoring and architectural improvement

---

## License
This project is licensed under the MIT License.
See the [LICENSE](LICENSE) file for details.

---

