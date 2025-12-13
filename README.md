# Modular Tic Tac Toe Engine with Aspect-Oriented Architecture

## Overview
This project implements a two-player Tic Tac Toe game in Java with a strong emphasis on modular backend design and separation of concerns. Aspect-Oriented Programming (AOP) is used to isolate cross-cutting behavior—such as turn sequencing, input handling, and referee evaluation—from the core game logic.

The result is a maintainable, extensible console-based game engine where each component has a clear and focused responsibility.

---

## Key Objectives
- Design a clean and maintainable backend architecture
- Apply Aspect-Oriented Programming to manage cross-cutting concerns
- Enforce reliable input validation and error handling
- Maintain clear separation between game state, rules, and execution flow

---

## System Architecture

### Core Classes
- **Board** — Maintains the game grid and move availability
- **Player** — Represents player identity and symbol
- **Referee** — Evaluates win and draw conditions
- **InputHandler** — Coordinates user input
- **InputValidator** — Validates move correctness
- **RestartGame** — Handles replay logic
- **TicTacToe / Main** — Orchestrates overall game execution

### Aspect-Oriented Components
- **TurnAspect** — Manages player turn sequencing
- **InputAspect** — Injects input acquisition and validation logic
- **RefereeAspect** — Triggers game-state evaluation after each move
- **AspectOrder** — Controls aspect execution order

Aspects remove duplicated logic from the core classes, improving readability and maintainability.

---

## Features
- Console-based two-player gameplay
- Validated user input with re-prompting
- Automatic win and draw detection
- Clean turn-based execution flow
- Restartable game sessions

---

## Technologies Used
- Java
- AspectJ
- Eclipse IDE
- Console I/O

---

## Design Focus
This project emphasizes:
- Backend system structure
- Separation of concerns
- Maintainable object-oriented design
- Practical use of Aspect-Oriented Programming

It intentionally excludes graphical interfaces, networking, and persistence layers to maintain focus on architecture and logic.

---

## Repository Contents
- Java source files for core game logic
- AspectJ files defining cross-cutting behavior
- Supporting documentation and instructions

---

## License
© 2025 James Stevens. All rights reserved.

This source code is provided for educational, evaluation, and portfolio review purposes.
Permission is granted to clone and run the code locally for non-commercial review.

No permission is granted to copy, modify, redistribute, or use this code in
commercial or production systems without explicit written consent from the author.
