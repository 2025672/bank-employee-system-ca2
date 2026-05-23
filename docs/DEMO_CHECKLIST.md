# Demo checklist (integration test)

Run `CA_2.Main` in NetBeans and follow this order for the assignment demo.

| Step | Menu | Expected result |
|------|------|-----------------|
| 1 | 1 + Enter | File read, 45 records loaded |
| 2 | 2 | First 20 names A–Z, sorted flag Yes |
| 3 | 3 + `Jessica Lee` | Found with Manager Type and Department |
| 4 | 3 + `Unknown Person` | Not found message |
| 5 | 4 + new employee | Added + listed under new records |
| 6 | 5 | Tree created, 46 nodes (if one added) |
| 7 | 6 | Level-order list, height, node count |
| 8 | 7 | Exit |

Invalid input tests: menu `99`, search empty name, file name with `../`.
