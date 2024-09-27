# Maximum Number of Releases in a Sprint

## Problem Description

Bob, a QA in the company "Corporation", works in a team following Agile principles with 2-week sprints (10 working days). Bob's goal is to deliver as many releases as possible within each sprint. However, with multiple releases and different delivery times, Bob needs help to make the best choice.

### Task

Write a program that helps Bob select the **maximum number of releases** possible within a sprint (10 working days) under the following limitations:

- Each release is delivered on a specific day (1-10).
- Any selected release must be completed before the sprint ends (Day 10).
- Bob can only work on one release at a time and cannot handle parallel releases.

### Input

A file named `releases.txt` contains multiple lines. 
Each line represents a release with two integers separated by a space:
- **First integer**: the day of the sprint (1-10) when the release is delivered.
- **Second integer**: the number of days required to validate the release.

### Output

A file named `solution.txt` in folder: resouce/output
- The first line contains the maximum number of releases, Bob can deliver within the sprint.
- The next lines contain two integers representing the **first** and **last day** Bob works on each release.

### Approach
The solution is based on the **greedy algorithm** approach, where releases are selected based on their completion time, ensuring Bob maximizes the number of non-overlapping releases he can work on.

### Steps:
1. **Sort releases by their completion day**: This ensures Bob can prioritize those releases that finish earlier.
2. **Validate releases**: For each release, if it can fit into the sprint without overlapping previously selected releases, Bob validates it.

## Instructions for Running the Program

### Prerequisites:
- Ensure you have **Java** installed.
- Use an IDE like **IntelliJ IDEA** or build from the command line.
- The input file `releases.txt` should be in the resouce/input folder.

### Running the code:
- Import the code base into an IDE.
- Right click ApplicationRun class and run the main method.

### Example
#### Input: releases.txt
```
1 1
2 1
3 1
9 1
10 4
10 2
9 5
10 3
4 5
```

#### Output: solution.txt
```
5
1 1
2 2
3 3
4 8
9 9
```
  
