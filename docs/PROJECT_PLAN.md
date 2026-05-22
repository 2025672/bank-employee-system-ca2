# Project Plan — Bank Employee Management System

**Assignment:** System Modelling & Build  
**Package:** `CA_2` · **Maven / NetBeans** · **Console only (no GUI)**

---

## Scope split

| Module | Deliverable | Where |
|--------|-------------|--------|
| **Algorithms & Constructs** | Java code + Word report + GitHub (10–15 commits) | This repo |
| **Software Development Fundamentals** | PDF: use cases, 2 UML types, requirements, user stories, 3 unit tests | Moodle SDF only — later |

**You asked to focus on code first** — this plan covers the Java program only.

---

## CA code requirements (checklist)

| Requirement | Marks area |
|-------------|------------|
| Organisation: **Bank** | — |
| 3 **parent** classes: `Manager`, `Department`, `Employee` | Core |
| ≥3 **subtypes** of each parent (later commit) | Extra marks |
| Menu using **Enums** | 10% |
| Read `Applicants_Form.txt` | Sort/Search |
| **Recursive** sort → show **first 20** names A–Z | 25% |
| **Recursive** search → Manager Type + Department | 25% |
| Add employee: name + manager + department + **validation** | 20% |
| **Binary tree**: ≥20 records, **level-order insert**, traversal, **height**, **node count** | 20% |
| No Swing/JavaFX/GUI | Restriction |

---

## Algorithms chosen

### Sorting: Recursive Merge Sort
- Sort applicant/employee **names** alphabetically.
- Display only the **first 20** after sort.
- **Justification (report):** efficient for larger lists from file; stable ordering; natural fit for **recursion** (divide list, merge sorted halves). Better than bubble/selection for growing data.

### Searching: Recursive Binary Search
- Search by **name** on the **sorted** list.
- Return **Manager Type** and **Department** (and related fields from file/memory).
- **Justification (report):** after sorting, binary search is faster than linear scan; recursive implementation matches assignment; scales if employee list grows.

---

## Class model (planned)

### Parent classes (required)
- `Employee`
- `Manager`
- `Department`

### Subtypes (≥3 each — later)
| Parent | Examples |
|--------|----------|
| Manager | `HeadManager`, `AssistantManager`, `TeamLead` |
| Department | `CustomerService`, `ForeignExchange`, `HR`, `Finance`, `IT` |
| Employee | `FullTimeEmployee`, `PartTimeEmployee`, `ContractEmployee` |

### Support classes (by commit)
- `MenuOption` (enum)
- `ManagerType` (enum)
- `DepartmentType` (enum)
- `ApplicantRecord` or `BankEmployee` — name + manager + department for list/tree
- `FileHandler` — read `Applicants_Form.txt`
- `RecursiveSorter` — merge sort
- `RecursiveSearcher` — binary search
- `TreeNode`, `EmployeeBinaryTree` — level-order insert, traversal, height, count

---

## Data file

`Applicants_Form.txt` — **CSV** with header:

`First name, Last name, Gender, Email, Salary, Department, Position, Job title, Company`

- **45 records** (enough for binary tree ≥20)
- **Full name** = First + Last (for sort/search)
- **Manager Type** = `Job title` column
- **Department** = `Department` column

See `docs/DATA_FORMAT.md` for full mapping.

---

## Suggested commits (12 — within 10–15 required)

| # | Message | Work |
|---|---------|------|
| 1 | `Initial Java Maven project setup with CA_2 package` | pom.xml, Main, 3 parents, README, sample txt |
| 2 | `Add menu enums and console navigation` | `MenuOption`, loop, switch |
| 3 | `Read Applicants_Form.txt and parse records` | `FileHandler`, list in memory |
| 4 | `Add employee record model and ArrayList storage` | record class, display helpers |
| 5 | `Implement recursive merge sort and display top 20` | `RecursiveSorter` |
| 6 | `Implement recursive binary search by name` | `RecursiveSearcher` |
| 7 | `Add new employee with input validation` | add + validate enums |
| 8 | `Implement binary tree with level-order insertion` | `TreeNode`, tree class |
| 9 | `Display tree traversal height and node count` | level-order print, stats |
| 10 | `Add manager department and employee subtypes` | 3+ subclasses each |
| 11 | `Improve validation and error handling` | robust Scanner/menu |
| 12 | `Final integration and code cleanup` | wire menu, comments, test |

---

## Demo flow (Q&A / video)

1. Run program → read file success message  
2. Sort → see 20 alphabetical names  
3. Search → found / not found with manager + department  
4. Add employee → validation if invalid manager/department  
5. Build tree (20+ records) → level-order display, height, count  
6. Exit  

---

## Next step

**Commit 1** — test with `mvn compile exec:java`, then commit.  
When you send the real `Applicants_Form.txt`, we adjust the parser in commit 3.
