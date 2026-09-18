# Tic-Tac-Toe AOP System

A Java 21 command-line Tic-Tac-Toe application that demonstrates Aspect-Oriented Programming (AOP) with AspectJ.

The project separates game rules, input validation, turn management, and game-end evaluation into focused components. AspectJ is used to intercept player input and coordinate post-move behavior while keeping the main game loop small and readable.

## Features

- Two-player Tic-Tac-Toe on a 3×3 board
- Random assignment of the first player
- `X` and `O` player symbols
- Win detection for rows, columns, and diagonals
- Draw detection
- Numeric and boundary validation for moves
- Occupied-cell validation without losing the current turn
- `exit` support during player and move input
- Restart support after completed games
- Optional reuse of player names between games
- AspectJ-based input interception, referee evaluation, and turn switching
- Maven build and AspectJ compile-time weaving
- JUnit 5 tests for board behavior and game rules

## Architecture

The application combines object-oriented design with Aspect-Oriented Programming to separate core game behavior from cross-cutting concerns.

### Application Flow

`Main` owns the application-level restart loop, while `TicTacToe` performs game setup and runs the move loop.

A typical move follows this flow:

```text
TicTacToe
    |
    v
InputHandler.getPlayerMove()
    |
    | intercepted by InputAspect
    v
InputValidator.getValidMove()
    |
    v
Board.setMove()
    |
    +--> RefereeAspect --> Referee --> GameRules
    |
    +--> TurnAspect
```

`AspectOrder` gives `RefereeAspect` precedence over `TurnAspect`. This ensures the board is evaluated before the active player changes, preserving the correct player context when a winner is announced.

### Core Classes

#### `Main`

Application entry point. Starts games and catches `RestartRequested` when the user chooses to play again.

#### `TicTacToe`

Coordinates player setup, symbol assignment, initial board display, and the main game loop.

#### `Board`

Encapsulates the 3×3 board state, applies moves, renders the board, and provides read-only access to board data. Complete board state is exposed through a defensive copy.

#### `Player`

Represents a player with an immutable name and an assigned game symbol.

#### `GameRules`

Pure, stateless rule engine responsible for:

- Row wins
- Column wins
- Diagonal wins
- Draw detection

The rule engine contains no console input/output or application state, allowing it to be tested independently.

### Input Handling

#### `InputHandler`

Provides the symbolic interception point used by AspectJ and owns the shared console scanner.

#### `InputValidator`

Handles console move input and validates:

- Numeric values
- Positions from 1 through 3
- Occupied cells
- Exit requests

#### `InputAspect`

Intercepts calls to `InputHandler.getPlayerMove(Board)` and delegates input collection and validation to `InputValidator`.

The placeholder method in `InputHandler` fails fast if AspectJ weaving is not active.

### Game Evaluation and Turn Management

#### `RefereeAspect`

Runs after successful calls to `Board.setMove(...)`. It displays the updated board and delegates game-end evaluation to `Referee`.

Rejected moves do not trigger board rendering or referee evaluation.

#### `Referee`

Uses `GameRules` to detect wins and draws and begins the post-game restart workflow when the game ends.

#### `TurnAspect`

Switches the active players only after a successful move.

#### `AspectOrder`

Declares `RefereeAspect` before `TurnAspect`, ensuring game-end evaluation occurs before the active player changes.

### Restart and Session Management

#### `RestartGame`

Handles the post-game decision to restart or exit.

#### `PlayerSession`

Stores player names between games and supports one-time reuse of those names after a restart.

#### `RestartRequested`

A control-flow exception used to unwind the current game loop and return control to `Main` when another game is requested.

## Repository Structure

```text
tic-tac-toe-aspect-oriented-java/
├── LICENSE
├── README.md
├── pom.xml
└── src/
    ├── main/
    │   ├── aspectj/
    │   │   └── game_aspects/
    │   │       ├── AspectOrder.aj
    │   │       ├── InputAspect.aj
    │   │       ├── RefereeAspect.aj
    │   │       └── TurnAspect.aj
    │   └── java/
    │       └── tictactoe/
    │           ├── Board.java
    │           ├── GameRules.java
    │           ├── InputHandler.java
    │           ├── InputValidator.java
    │           ├── Main.java
    │           ├── Player.java
    │           ├── PlayerSession.java
    │           ├── Referee.java
    │           ├── RestartGame.java
    │           ├── RestartRequested.java
    │           └── TicTacToe.java
    └── test/
        └── java/
            └── tictactoe/
                ├── BoardTest.java
                └── GameRulesTest.java
```

## Testing

The project currently contains **13 JUnit 5 tests** covering the board and pure game-rules engine.

Automated coverage includes:

- Empty-board initialization
- Successful move placement
- Rejection of occupied cells
- Protection against unintended cell changes
- Defensive copying of board state
- Row wins
- Column wins
- Both diagonal wins
- Draw detection
- Incomplete-board handling
- Full-board winner handling

Run the automated test suite with:

```bash
mvn clean test
```

The interactive CLI and AspectJ orchestration are verified separately through manual end-to-end testing, including input validation, turn behavior, win/draw handling, restart behavior, player reuse, and exit paths.

## Build and Run

### Prerequisites

- Java 21
- Maven 3.8 or later

Verify your environment:

```bash
java -version
mvn -version
```

### Build and Test

```bash
mvn clean test
```

### Package

```bash
mvn clean package
```

### Run

```bash
mvn exec:java
```

The application runs entirely in the terminal and guides the players through setup, move entry, game completion, and restart or exit.

## AspectJ Build Notes

The Maven build performs AspectJ weaving for both production and test compilation.

During a successful build, AspectJ reports the join points advised by the project's aspects. Depending on the Maven and AspectJ plugin versions, the build may also report nonfatal plugin or unmatched-advice warnings during test compilation.

These warnings do not prevent a successful build or indicate that production weaving failed. Production weave information can be seen in the Maven build output.

## Technologies

- Java 21
- Maven
- AspectJ
- JUnit 5

## What This Project Demonstrates

This project is intentionally a command-line application rather than a GUI project. Its focus is the underlying software design, particularly:

- Aspect-Oriented Programming with AspectJ
- Separation of concerns
- Compile-time aspect weaving
- Object-oriented domain modeling
- Encapsulation and defensive copying
- Pure, independently testable business rules
- Input validation
- Explicit application and restart control flow
- Maven-based Java project structure
- Automated unit testing

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.