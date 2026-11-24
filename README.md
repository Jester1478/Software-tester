# Task 2: Test Case Design - GradeCalculator

## Requirements

| ID | ข้อกำหนด |
|:--:|:--|
| R1 | 80-100 → "A", 75-79 → "B+", 70-74 → "B", 65-69 → "C+" |
| R2 | 60-64 → "C", 55-59 → "D+", 50-54 → "D", 0-49 → "F" |
| R3 | score < 0 หรือ > 100 → throw IllegalArgumentException |

## Equivalence Partitioning (EP)

| คลาส | ช่วงคะแนน | Expected | ตัวแทน |
|:--:|:--:|:--:|:--:|
| Invalid ต่ำ | < 0 | IllegalArgumentException | -10 |
| F | 0-49 | F | 25 |
| D | 50-54 | D | 52 |
| D+ | 55-59 | D+ | 57 |
| C | 60-64 | C | 62 |
| C+ | 65-69 | C+ | 67 |
| B | 70-74 | B | 72 |
| B+ | 75-79 | B+ | 77 |
| A | 80-100 | A | 90 |
| Invalid สูง | > 100 | IllegalArgumentException | 150 |

## Test Cases

| TC ID | Technique | score | Expected return | เป้าหมาย | Actual | Status |
|:--:|:--:|:--:|:--:|:--|:--:|:--:|
| TC1 | EP | -10 | IllegalArgumentException | EP: invalid ต่ำ (< 0) | | Not run |
| TC2 | EP | 25 | F | EP: คลาส F (0-49) | | Not run |
| TC3 | EP | 52 | D | EP: คลาส D (50-54) | | Not run |
| TC4 | EP | 57 | D+ | EP: คลาส D+ (55-59) | | Not run |
| TC5 | EP | 62 | C | EP: คลาส C (60-64) | | Not run |
| TC6 | EP | 67 | C+ | EP: คลาส C+ (65-69) | | Not run |
| TC7 | EP | 72 | B | EP: คลาส B (70-74) | | Not run |
| TC8 | EP | 77 | B+ | EP: คลาส B+ (75-79) | | Not run |
| TC9 | EP | 90 | A | EP: คลาส A (80-100) | | Not run |
| TC10 | EP | 150 | IllegalArgumentException | EP: invalid สูง (> 100) | | Not run |
| TC11 | BVA | -1 | IllegalArgumentException | ใต้ขอบล่างสุด | | Not run |
| TC12 | BVA | 0 | F | ขอบล่างสุดของช่วงที่ใช้ได้ | | Not run |
| TC13 | BVA | 1 | F | เหนือขอบ 0 | | Not run |
| TC14 | BVA | 49 | F | ขอบบนของ F | | Not run |
| TC15 | BVA | 50 | D | ขอบล่างของ D | | Not run |
| TC16 | BVA | 51 | D | เหนือขอบ D | | Not run |
| TC17 | BVA | 54 | D | ขอบบนของ D | | Not run |
| TC18 | BVA | 55 | D+ | ขอบล่างของ D+ | | Not run |
| TC19 | BVA | 56 | D+ | เหนือขอบ D+ | | Not run |
| TC20 | BVA | 59 | D+ | ขอบบนของ D+ | | Not run |
| TC21 | BVA | 60 | C | ขอบล่างของ C | | Not run |
| TC22 | BVA | 61 | C | เหนือขอบ C | | Not run |
| TC23 | BVA | 64 | C | ขอบบนของ C | | Not run |
| TC24 | BVA | 65 | C+ | ขอบล่างของ C+ | | Not run |
| TC25 | BVA | 66 | C+ | เหนือขอบ C+ | | Not run |
| TC26 | BVA | 69 | C+ | ขอบบนของ C+ | | Not run |
| TC27 | BVA | 70 | B | ขอบล่างของ B | | Not run |
| TC28 | BVA | 71 | B | เหนือขอบ B | | Not run |
| TC29 | BVA | 74 | B | ขอบบนของ B | | Not run |
| TC30 | BVA | 75 | B+ | ขอบล่างของ B+ | | Not run |
| TC31 | BVA | 76 | B+ | เหนือขอบ B+ | | Not run |
| TC32 | BVA | 79 | B+ | ขอบบนของ B+ | | Not run |
| TC33 | BVA | 80 | A | ขอบล่างของ A | | Not run |
| TC34 | BVA | 81 | A | เหนือขอบ A | | Not run |
| TC35 | BVA | 99 | A | ใต้ขอบบนสุด | | Not run |
| TC36 | BVA | 100 | A | ขอบบนสุดของช่วงที่ใช้ได้ | | Not run |
| TC37 | BVA | 101 | IllegalArgumentException | เหนือขอบบนสุด | | Not run |

## หลัก F.I.R.S.T. ที่ใช้กับเทสต์ (JUnit)

| อักษร | ความหมาย | การนำไปใช้ |
|:--:|:--|:--|
| F | Fast | เทสต์เป็นการคำนวณล้วน ไม่มี I/O รันเสร็จในมิลลิวินาที |
| I | Independent | แต่ละ @Test ไม่พึ่งกัน ไม่แชร์ state (สร้าง/ใช้ GradeCalculator แบบ stateless) |
| R | Repeatable | ผลเหมือนเดิมทุกครั้ง ทุกเครื่อง ไม่พึ่งเวลา/สุ่ม |
| S | Self-validating | ใช้ assertEquals / expected exception ผ่านหรือไม่ผ่านชัดเจน |
| T | Timely | เขียนเทสต์ก่อนโค้ด (RED → GREEN → REFACTOR) |
