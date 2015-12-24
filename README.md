#Fuckboi

A basic programming language for the millennials.

##Introduction
2015 has been quite a great year, but it has also been the sudden, and not so great rise of the Fuckbois. This programming language is dedicated to those *specific people* who are just Fuckbois by nature.

##Hello World
	NETFLIX
	IS IT TOO LATE NOW TO SAY SORRY? "Hello World"
	CHILL

##Quick Start

	wget http://virenmohindra.me/Fuckboi.jar
	echo -e "NETFLIX\nIS IT TOO LATE NOW TO SAY SORRY? \"Hello World\"\nCHILL" > hello.fuckboi
	java -jar Fuckboi.jar hello.fuckboi
	java hello

To create some "audible" output you can try the -declaim option:

	java -jar Fuckboi.jar -declaim hello.fuckboi

This will create a .wav file which is playable on any computer:

![Please reload the page to see the image or go to the extras folder to see the screenshot.](https://github.com/VirenMohindra/Fuckboi/extras/audible.png "Supports Audible Input")

##Brief overview of the keywords

Check the [wiki](https://github.com/VirenMohindra/Fuckboi/wiki) for more details.

Keywords 						| Fuckboi Keywords
--------------------------------|------------------------------------------------------
BeginMain                       | `NETFLIX`
EndMain                         | `CHILL`
SetInitialValue                 | `ASL?`
DeclareInt                      | `YO`
Return                          | `LONG TIME...`
Print                           | `IS IT TOO LATE NOW TO SAY SORRY?`
ReadInteger                     | `WHAT DO YOU MEAN?`
AssignVariable                  | `HEY`
SetValue                        | `TINDER`
EndAssignVariable               | `BYE`
False	                        | `I LIED`
True                            | `FINALLY THE TRUTH`
If                              | `PLEASE?`
EndIf                           | `YOU HAVE NO RESPECT FOR ME`
Else                            | `BAE`
While                           | `STICK AROUND`
EndWhile                        | `G2G` 
PlusOperator                    | `ADD ME`
MinusOperator                   | `DON'T DELETE ME`
MultiplicationOperator          | `MULTIPLY`
DivisionOperator                | `DIVIDE AND CONQUER`
ModuloOperator                  | `DON'T LEAVE ME`
EqualTo                         | `B'FUL`
GreaterThan                     | `YOU LIFT?`
Or                              | `DAMN GIRL`
And                             | `KNOCK KNOCK`
DeclareMethod                   | `LISTEN TO ME VERY CAREFULLY`
NonVoidMethod                   | `SMILE MORE`
MethodArguments                 | `MMHMM`
EndMethodDeclaration            | `SRY BBY`
CallMethod                      | `SNAP`
AssignVariableFromMethodCall    | `GET YOUR ASS HERE`
ParseError                      | `Nope, not my problem.`

##Motivation and Inspiration
Mostly boredom. Heavily inspired by [ArnoldC](https://github.com/lhartikk/ArnoldC) - the Arnold Schwarzenegger programming language.

##Features
1. file extension of .fuckboi
	example = HelloWorld.fuckboi
2.SublimeText Support for keywords.
3. Passed ArithmeticTests, BranchStatementTests, FeatureTests, FuckboiGeneratorTests, InputTests, LogicalTests, and MethodTests.

##SublimeText 3 Support
1. Download the markup in the extras folder `fuckboi.tmLanguage`

Mac folder
~/Users/YOUR_NAME/Library/Application Support/Sublime Text 3/Packages

Linux folder
~/.config/sublime-text-v/Packages/Fuckboi

Windows folder
%APPDATA%\Sublime Text v\Packages\Fuckboi

##Limitations
1. Variables can only be 16bit signed integers.
2. Its pretty shitty code and don't expect to make software with this. Please don't make software with this.

##Advanced Installation or [How To Create your own programming language using this base]
1. > `brew install sbt` | [SBT](http://www.scala-sbt.org/download.html) is a CLI build tool which is absolutely amazing.
2. `cd` into Fuckboi-master
3. > `sbt` 
4. > `compile` Will concatenate all Scala files and run through them to see if there are any errors.
5. > `assembly` This will compile the .jar file which is essentially the programming language.
6. Replacekeywords you want. Rename folder structures and any other `fuckboi` specific code you might see lying around.
7. Remove any and all tests, because they *will* fail. 
7. > `~ compile` will automatically recompile your code whenever you save a source file. More information [here](http://www.scala-sbt.org/0.13/tutorial/Running.html). This will help when you're switching out the code.

##To Do List
1. Switch Case Statement
2. [Euler's Tests](https://projecteuler.net/)
3. Comments. //pretty important because anything written in Fuckboi will be practically unreadable to a normal human being.
4. Nicer syntax errors (?)
5. Read Input
6. Continue/ Next
7. Delete objects
8. Break/ NULL/ Static
9. Random numbers
10. FOR LOOP