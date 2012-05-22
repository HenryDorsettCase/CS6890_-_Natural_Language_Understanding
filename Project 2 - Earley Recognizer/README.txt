READ ME

CS6890 - NLP
Christopher H Weber
Earley Recognizer



1) Use the version of sample_grammar1.txt from the enclosed file.

	Differences from Dr. Kulyukin's file:
		Variables for the terminals + and * are included.
		Lexical rules are written for these variable/terminal
 			tuples.
		Terminal "*" has been replaced with "x".


	Explanation: the command line in my IDE would not accept the
 		asterisk on its own. When given an "*", the command
 		line args become a list of all the project files. Thus I
 		changed the symbol to "x".

	Note: Dr. Kulyukin in class Monday evening said that altering
 		the sample_grammar1.txt was ok.



2) To run the program:

	Insert the grammar file into the project folder.
	Use these command line arguments: 
		<grammar_file.txt> <string to parse>

	For example:
		grammar.txt  ( ( ) )
		sample_grammar2.txt Book that flight.
		sample_grammar1.txt  a + a x a



3) Further considerations:

	-In order to accept sentences for sample_grammar2.txt as
 	described in the slides, the input string is altered within
 	the program:
	
		-If the first word of the input string has a 				
		capitalized first letter, it is changed to lowercase.
		-If the last word closes with a ".", this period is 		
		removed from the last word.

	Point: This could conceivably alter other grammars...

	-The size of the chart is EXACTLY the number of args from the 
	command line.

4) All the above points have been alternatively handled in beta versions
    of this program:
        -* can be dealt with by enclosing the input string in "".  Then
            the # of cl args becomes 2 and parsing the input string
            becomes a different routine.
        -No capitalization or period check is technically required.
        -A method was written to replace all terminals mixed with variable
            on the rhs of a rule with a new variable name, and then adding
            a lexical rule for the new var name ::= terminal to the
            list of rules.
   However, as none of these points are requirements for the program, I have
   not included them in this final version.




 