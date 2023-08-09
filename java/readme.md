



# Refactoring steps

## Step 1 -  Structure and technical changes

* create package equinton.dev.kata.yatzy
* change java version
* use junit5 and Assertj

## Step 2 - clean code

### My objectives
In order to keep the original tests, I decided not to modify the contracts in the Yatzy class.
Eventually, the Yatzy class will simply call another class in which all the code will be placed.

### Process

- I change the name of arguments 
  - d1 to dice1...
- Homogenize code in several steps:
    - Rename arguments in an understandable way Ex d1 to dice1 then use var arg
    - Give the same variable name for the same concept: result, r...become score
    - Modify tests when they didn't have the right method names Ex three_of_kind called in four_of_kind
- creation of private methods to group together the different ways of calculating scores:
  - sum of faces
  - grouping by face value
  - define if it's a straight.

## Step 3 - Refactoring

### My objectives
In this Step my main goal is to extract all code from Yatzy classe and use strategy to calculate the score
All new classes will be add in the package 'domain'
TDD will be used to code.

In first part of this step, the code will be duplicated to keep the old tests and new and compare tests.


### Process

- Creationg interface or enum to define the different Category to define 
- Creation of the class CalculateYatzyScoreUseCase