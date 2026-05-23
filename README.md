# Bank Employee Management System

CCT College Dublin — HDip in Computing  
Assignment: System Modelling & Build · Package `CA_2`  
Student: **2025672**

GitHub: https://github.com/2025672/bank-employee-system-ca2

## Run

**NetBeans:** open as Maven project → run `CA_2.Main`

**Terminal:**

```bash
mvn compile exec:java
```

## Console menu

| # | Action |
|---|--------|
| 1 | Read `Applicants_Form.txt` |
| 2 | Sort employee list (recursive merge sort — first 20 names A–Z) |
| 3 | Search employee by name (recursive binary search) |
| 4 | Add new employee (validation on name, manager type, department) |
| 5 | Create employee hierarchy binary tree (level-order insertion) |
| 6 | Display binary tree (level-order traversal, height, node count) |
| 7 | Exit |

## Data file

`Applicants_Form.txt` — CSV columns: First name, Last name, Gender, Email, Salary, Department, Position, Job title, Company.

Locations: project root and `src/main/resources/`.

## Project structure (`CA_2`)

| Area | Classes |
|------|---------|
| Entry / menu | `Main`, `MenuOption`, `ApplicationController`, `InputValidator` |
| File I/O | `FileHandler`, `ApplicantRecord`, `EmployeeDataStore` |
| Algorithms | `RecursiveMergeSort`, `RecursiveBinarySearch` |
| Binary tree | `EmployeeBinaryTree`, `TreeNode`, `TreeDataStore` |
| Hierarchy | `Employee`, `Manager`, `Department` and subtypes (managers, departments, employment types) |
| Factory | `OrganizationFactory`, `EmployeeTypeRegistry`, `EmployeeInputHandler` |

## Demo order

See `docs/DEMO_CHECKLIST.md` for a step-by-step test run before submission.
