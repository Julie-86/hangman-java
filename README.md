# Hangman Java Project 🏷️🎮

A fun, step-by-step journey building a **Java Hangman game**, versioning with Git, and containerizing with Docker.  
This README covers **Day 1 & Day 2** of the learning project.

---

## 🌟 Day 1 – Java App + Git 📝💻

**Goal:** Create a Java Hangman application and track it with Git.

**Key Learnings:**  
- 🏷️ Java: classes, objects, main method  
- 🔄 Git: commits, branches, basic workflow  
- 📂 Project structure:

```

Hangman/
├── src/
│   └── application/
│       ├── App.java        // Main class to launch the game
│       ├── Hangman.java    // Handles game loop, input & logic
│       └── RandomWord.java // Manages random word selection
└── bin/ (compiled classes)

````

**Git Commands Used:**
```bash
git init
git add .
git commit -m "Initial commit – Java Hangman game"
git branch -M main
git remote add origin <my-repo-url>
git push -u origin main
````

**Run Locally:**

```bash
javac -d bin src/application/*.java
java -cp bin application.App
```

**Example Gameplay:**

```
Tries remaining: 5
_ _ _ _ _ _
Enter your guess: a
Tries remaining: 5
_ a _ _ _ _
Enter your guess: t
Tries remaining: 4
_ a t _ _ _
...
```

**Possible Future Improvements:**

* Validate input (lowercase letters only) ✅
* Track previous guesses ✅
* Scoring system or hints 🎯
* GUI (JavaFX/Swing) 🎨

---

## 🌟 Day 2 – Dockerize App 🐳🚀

**Goal:** Run the Java app inside Docker for consistent environments.

**Key Learnings:**

* 🐳 Docker images & containers
* ⚡ Multi-stage builds (Dev vs Prod)
* 🔧 Containerized compilation & execution

---

### 🔹 Docker Dev Version – `Dockerfile.dev`

Compiles Java **inside the container** for testing.

```dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
RUN mkdir -p src/application
COPY src/application/*.java src/application/
RUN javac src/application/*.java
CMD ["java", "-cp", "src", "application.App"]
```

**Commands:**

```bash
docker build --no-cache -t hangman-java-dev -f Dockerfile.dev .
docker run -it --rm hangman-java-dev
```

---

### 🔹 Docker Prod Version – `Dockerfile.prod`

Professional version with **pre-compiled classes**.

# Production stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY bin/ ./bin/
CMD ["java", "-cp", "bin", "application.App"]


**Commands:**

```bash
docker build -t hangman-java-prod -f Dockerfile.prod .
docker run -it --rm hangman-java-prod
```

**Notes:**

* Dev container: compiles inside ✅
* Prod container: pre-compiled `.class` ✅

---

## 📊 Mini Docker Flow Diagram

```
          +-----------------+
          |   Source Code    |
          +-----------------+
                   |
           +-------v--------+
           | Docker Dev      |
           | javac inside    |
           +----------------+
                   |
           +-------v--------+
           | Docker Prod     |
           | Precompiled .class |
           +----------------+
                   |
           +-------v--------+
           | Run Container   |
           +----------------+
```

---

## ✅ Takeaways

* 🎮 Java app works
* 🔄 Git versioned
* 🐳 Dockerized (Dev & Prod)
* ⚡ Ready for CI/CD next (Day 3)

---

## 🔮 Next Steps – Day 3

* ⚙️ Configure **GitHub Actions CI/CD**
* 🛠️ Automate Docker build & test
* 🚀 Deploy Prod container automatically
* 📊 Add monitoring & logging later

