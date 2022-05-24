package assignment_2.question_1;

/*import highlight where we might be using null in the case that we dont want to use null
 it is used in our class2 class in the countWords method*/
import org.jetbrains.annotations.NotNull;

/*import used to be able to store the information entered into the console.
  We are using it to store the string entered by the user into a variable so that we can count the words*/
import java.util.Scanner;

//as per the spec the program should have 2 classes, this is class1 being declared
public class class1 {

    //this is the main method inside class1, this is where program execution happens.
    public static void main(String[] args) {

        //Declaration of a variable that will store the number of words in the sentence.
        int totalWords;

        //Declaration of our scanner object to read information from the cli.
        Scanner consoleIn = new Scanner(System.in);

        /*Declaration of our class2 object as per the spec, class1 had to have class2 inside it:
        * (reference to the assignment booklet)
        * The first class should be named class1, this class will have the following:
        *
        * • The main method (starting point) (5)
        * • The object of class2 (5)    <-------
        * • Should also call the get method count_words(String str) (5)
        * */
        class2 wordCounter = new class2();

        //requesting that the user inputs a string for the program to count.
        System.out.print("Please enter a sentence: ");

        //using our scanner object to read the string and store it in our to count variable.
        String strToCount = consoleIn.nextLine();


        /* using our class2 object count words method to
        return the amount of words in the string*/
        totalWords = wordCounter.countWords(strToCount);

        /*printing out the total number of words*/
        System.out.print("Total number of words are " + totalWords);
    }

    //declaration of our class2 object
    public static class class2 {

        //declaring counter variable that will store the word count.
        int wordCount;

        //declaring constructor for our class 2 variable that initializes wordCount to 0
        public class2(){
            this.wordCount = 0;
        }

        /*declaring the method that will return the amount of words in the user supplied sentence.
        * it accepts a string as an argument and uses the string.length() method as its controller*/
        public int countWords(@NotNull String str){

            //if the user just presses enter instead of typing a sentence, return 0
            if(str.length() == 0){
                return 0;
            }

            /*if we are at this point in the function it means the user definitely entered at least one
            * word and that means we can increment the wordCount variable*/
            this.wordCount++;

            /*We use a for loop here to be able to iterate through each letter in the sentence,
            * we use the variable i as our iterator, starting at 0, all the way through to the strings length - 1,
            * we have to -1 otherwise we will get an error trying to index the string */
            for(int i=0; i<=str.length()-1; i++){

                /* str.charAt returns the character at the specified index in the string, we then use that to
                * check whether the character at the index is an open space and also the next character is
                * not equal to an open space */
                if(str.charAt(i) == ' ' && str.charAt(i+1)!=' '){

                    //incrementing our wordCount
                    this.wordCount++;
                }
            }

            //returning wordCount to the calling program.
            return this.wordCount;
        }

    }
}
