## Main classes:
- Game
- Board
- Player
- Cell
- Symbol (X / O)
- WinningStrategy (optional, advanced)

### Relationships:
- Game has-a Board ✅ (composition)
- Game has-a Players ✅
- Board has-a Cells ✅
- Player has-a Symbol ✅

Apply Solid and Design Principles:

### SRP (Single Responsibility)

- Board → manages board state

- Player → player info

- Game → game flow

- Cell → individual cell state

### OCP + Strategy Pattern (for win logic)

- WinningStrategy interface

### Encapsulation

- Hide board internals

### Composition > Inheritance

- Board contains cells