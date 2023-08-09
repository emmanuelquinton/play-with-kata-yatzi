



# Refactoring steps

## Step 1 -  Structure and technical changes

* create package equinton.dev.kata.yatzy
* change java version
* use junit5 and Assertj

## Step 2 - clean code

### My objectives

Afin de garder les tests originaux je me suis imposé de ne pas modifier les contrats la classe Yatzy .
A terme la classe Yatzy ne fera qu'appeler une autre classe dans laquelle tout le code sera placé.

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