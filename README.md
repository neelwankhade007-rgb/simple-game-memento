# 🎮 Turn-Based Battle Game (Memento Pattern)

## 📌 Overview
This project is a **console-based turn-based battle game** implemented in Java.  
It demonstrates the use of the **Memento Design Pattern** to capture and restore the complete game state, including dynamic objects like opponents.

The player progresses through multiple levels by defeating enemies. The game allows saving progress and restoring it later using checkpoints.

---

## 🧠 Design Pattern Used

### Memento Pattern

The Memento pattern is used to implement the **save/load functionality** without exposing internal game state.

#### Components:
- **Originator** → `Game` (creates and restores state)
- **Memento** → `GameState` (stores snapshot of game state)
- **Caretaker** → `SaveManager` (manages saved states)

---

## 🎯 Features

- ⚔️ Turn-based combat system  
- 👾 Randomly generated opponents (Types A–E)  
- 📈 Level progression up to Level 3  
- 💾 Save game at any point  
- 🔄 Restore previous game state  
- 🧠 Deep copy of opponent objects (ensures correct restoration)  
- ☠️ Game ends when player health reaches zero  

---

## 🕹️ Gameplay

1. Start a new game  
2. Fight opponents turn-by-turn  
3. Choose to:
   - Attack enemies  
   - Save current progress  
   - View status  
4. Load a previously saved game  
5. Progress through levels until completion or defeat  

---

## 🛠️ How to Run

### Compile
```bash
javac *.java