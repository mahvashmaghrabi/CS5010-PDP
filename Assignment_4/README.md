#Random Sentence Generator
This tool focuses on generating random sentences for the given grammar files.
#Entry Point
The application will kickstart from EntryPoint class. Run the class using small triangle option 
beside main method of EntryPoint class in IntelliJ, then application will start loading and wait for user input
at certain point of time. Insert your input as suggested in UI, user will see random sentence 
generated. User can continue or else quit the application as and when needed.
#Project Description
The approach for this project is that a grammar file will only be parsed on user selection. Once 
grammar file is selected, following classes will parse and deserialize it.
1. Grammar Deserializer class : This class will use Gson to parse and deserialize the grammar file
into respective custom class. This class contains main logic for deserializing the file into custom class.
It will parse lines into following order: first it will expect a Non-Terminal node, then a
Punctuation node, and it will assume a series of word is a Terminal node splitting that series of
word into given whitespaces.
2. Grammar Class : This is the custom class that into which grammar file will be deserialized.
3. Node interface : Provides generateString method to other node classes.
4. Terminal Node Class : Terminal node class with string.
5. Non-Terminal Node Class : This Class will have non-terminal node name.
6. Non-Terminal Node Definition Class : This class contains rules for all the non-terminal nodes.
7. Punctuation Node Class : This contains a Punctuation.
8. UIInteraction Class : This class takes user input and calls other classes for action.
9. Entry Point Class : From this class, application will start calling UIInteraction and other methods.
#Build Status
The project is building correctly with the use of some external third party files which are defined below.
#Tech/Framework used
Java 8 and Gradle. Also, please add Apache Commons-CLI and Google Gson to your build-gradle
#How to run
To run the project click small triangle option in main method of Entry class, in IntelliJ, 
then application will start loading and wait for user input
at certain point of time. Insert your input as suggested in UI, user will see random sentence
generated. User can continue or else quit the application as and when needed.
#Steps to ensure correctness
For correct sentences, the series of words is split into next immediate whitespace and add that whitespace
as a Punctuation Node followed by word. 
