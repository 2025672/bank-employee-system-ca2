# Bank Employee Management System

**CCT College Dublin — HDip in Computing (Sept 2025)**  
**Assignment:** System Modelling & Build (integrated)  
**Modules:** Algorithms & Constructs (60%) · Software Development Fundamentals (55%)  
**Package:** `CA_2` · **Build:** NetBeans Maven Java project

## Organisation chosen

**Bank** — matches the assignment examples (Customer Service, Foreign Exchange, HR, Manager types).

## What this repo contains (code focus)

Console program for **Algorithms & Constructs**:

- Read `Applicants_Form.txt`
- **Recursive** sort (Merge Sort) — show first 20 names A–Z
- **Recursive** search (Binary Search) on sorted list
- Add employee with validation (name, manager type, department)
- Employee hierarchy **binary tree** (≥20 records, level-order insert & traversal)
- Menu driven by **Enums**

**SDF deliverables** (use cases, UML PDF, user stories) are separate — not in this repo.

## Requirements

- JDK 17+
- Maven 3.6+ (NetBeans includes Maven)

## Run in NetBeans

1. File → Open Project → select this folder (Maven project).
2. Run `CA_2.Main`.

## Run from terminal

```powershell
cd "c:\Users\Lenovo\Desktop\Facul\DevFund n AlgoCons"
mvn compile exec:java
```

## Project layout

```
pom.xml
src/main/java/CA_2/
    Main.java
    Employee.java, Manager.java, Department.java   (parent classes)
    ... (menu enums, file handler, algorithms, tree — added per commit)
src/main/resources/
    Applicants_Form.txt
docs/
    PROJECT_PLAN.md
```

## Algorithms (for report — max 500 words)

| Task | Algorithm | Why (summary) |
|------|-----------|----------------|
| Sort names | **Recursive Merge Sort** | Stable, O(n log n), suits file-based lists; good for recursion LO |
| Search name | **Recursive Binary Search** | List is sorted first; efficient lookup by name |

## GitHub

- 10–15 commits while building
- Add lecturer as collaborator
- Put repo link in Word report (Algorithms module)

## Author

- Name: [Your Name]
- Student ID: [Your ID]

See `docs/PROJECT_PLAN.md` for commit stages and full CA mapping.
