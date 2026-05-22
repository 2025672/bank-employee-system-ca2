# Applicants_Form.txt — Data format

## CSV columns

| Column | Example | Used in CA for |
|--------|---------|----------------|
| First name | Kate | Full name (with Last name) |
| Last name | Summer | Full name |
| Gender | Female | Stored / display (optional in search) |
| Email | ksummer@... | Stored |
| Salary | 20000.00 | Stored |
| Department | IT Development | **Department** (search result) |
| Position | senior | Seniority level (intern, junior, middle, senior) |
| Job title | Manager | **Manager type** (search result) |
| Company | TechInnovators | Organisation / bank branch label |

## How the program maps fields

| CA requirement | Source in CSV |
|----------------|---------------|
| Person name (sort & search) | `First name` + `" "` + `Last name` → e.g. `Kate Summer` |
| Manager Type | `Job title` (Manager, Senior Manager, Team Lead, Head Manager, Assistant Manager, …) |
| Department | `Department` column |

**Note:** Some rows have an empty `Position` but a filled `Job title` (e.g. Sales + Manager). Parser must handle empty fields between commas.

## Record count

- **45 employees** (+ 1 header row) — enough for binary tree (minimum 20).

## Duplicate names

Several people share first/last names (e.g. multiple John, Emma, Sophia). Search should match the **full name** string; binary search may return the **first match** unless you extend the design (document in report if needed).

## File locations

| Path | Purpose |
|------|---------|
| `Applicants_Form.txt` (project root) | User types filename when running from project folder |
| `src/main/resources/Applicants_Form.txt` | Copy bundled with Maven / NetBeans |

Keep both in sync when updating data.

## Bank menu departments (for ADD validation)

From this file, valid departments include:

- IT Development
- Sales
- HR
- Finance
- Marketing
- Accounting
- Operations
- Technical Support
- Customer Service

## Manager types (Job title) for ADD validation

Examples from data:

- Manager
- Senior Manager
- Assistant Manager
- Head Manager
- Team Lead
- (plus non-manager roles: QA, backend, Clerk, … if you allow all job titles or only management roles — define in validation commit)

For **search return**, use whatever is in `Job title` for that person.
