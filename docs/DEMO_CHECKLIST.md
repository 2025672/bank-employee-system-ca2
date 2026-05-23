# Demo checklist

Run `CA_2.Main` in NetBeans (or `mvn compile exec:java`) and test in this order.

| Step | Menu | Expected result |
|------|------|-----------------|
| 1 | 1 | File read; record count shown (e.g. 45 loaded) |
| 2 | 2 | First 20 names A–Z; sorted flag Yes |
| 3 | 3 + `Jessica Lee` | Found — Manager Type and Department displayed |
| 4 | 3 + `Unknown Person` | Not found message |
| 5 | 4 + new employee | Employee added and listed |
| 6 | 5 | Binary tree created (run after option 1) |
| 7 | 6 | Level-order traversal, height, node count |
| 8 | 7 | Program exits |

**Extra checks:** menu `99` (invalid), search with empty name, file path containing `../` (rejected).
