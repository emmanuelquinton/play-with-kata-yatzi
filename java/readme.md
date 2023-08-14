
This project contains my developments for the Yatzy kata
The final result is on this [branch](https://github.com/emmanuelquinton/play-with-kata-yatzy) but all the steps are in different branches.
My steps are described above.

# Refactoring steps

## Step 1 -  Structure and technical changes
I only
* created package equinton.dev.kata.yatzy
* changed java version
* used junit5 and Assertj

https://github.com/emmanuelquinton/play-with-kata-yatzy/tree/step-1-technical-changes
## Step 2 - clean code

### My objectives
In order to keep the original tests, I decided not to modify the contracts in the Yatzy class.
Eventually, the Yatzy class will simply call another class in which all the code will be placed.

### Process

- I've changed the name of the arguments
    - d1 to dice1...
- I homogenized the code in several steps by :
    - Renaming arguments in an understandable way Ex d1 to dice1 then using var arg
    - Giving the same name to variables with the same concept: result, r...become score
    - Modifying tests when they don't have the right method names Ex three_of_kind called four_of_kind
- creating private methods to group together the different ways of calculating scores:
    - sum of faces
    - grouping by face value
    - define if it's a straight.


https://github.com/emmanuelquinton/play-with-kata-yatzy/tree/step-2-clean-code

## Step 3 - Refactoring

### My objectives
In this step, my main objective was to extract all the code from the Yatzy class and use a strategy to calculate the score.
All new classes were added to the "domain" package.
TDD was used for coding.

In this step, the code was initially duplicated to preserve old tests and compare them with new ones.
At the end of this stage, the initial test class (YatzyTest) changed little or not at all.
The yatzi class was modified only within the methods, so that the YatzyTest class remains valid.


### Process
#### step3-1
- Creation of an enum to define the various categories to be defined.
- Creation of the CalculateYatzyScoreUseCase class and addition of a chance case.

#### step3-2
- Creating a parameterized test
    - I've added a Game class to define a throw and the expected score.
    - I've added a provider class for each category
- I added all the cases to the CalculateYatzyScoreUseCase class.

#### step3-3
- From CalculateYatzyScoreUseCase, I created an enum-based strategy (ScoreCalculator);
- I renamed the CalculateYatzyScorTest test to CalculateYatzyScoreUseCaseTest

https://github.com/emmanuelquinton/play-with-kata-yatzy/tree/step-3-refactoring


## Step 4 - Add DDD principle
#### step4-1
In this step I applied the  value object  principles:
-  2 Records has been created Score and Roll

#### step4-2
- In this step I continued to apply the principles od DDD with by creating
  - Die value object 
  - Specifications. RollNotNullSpecification and CategoryNotNullSpecification. 
  For your information: I haven't created specifications for validating the value of a die or validating that a roll contains only six dice,as these tests are internal to the value objects and are not used in other classes. 

- I rename some classes or variables
  - DiceRoll to Roll
  - diceValues to dice
  - YatziRollException to NumberDiceRollException

- I have created tests to verify the value of die or roll at instantiation.