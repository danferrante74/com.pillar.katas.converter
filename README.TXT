- This was written and designed in eclipse not intelliJ, but test cases and driver can be run from either IDE.
- To run the test cases, use the TestRomanNumeralConverter class.
- To run the application, use the RomanNumeralConverterDriver class.

- A little background:

- I followed a MVC pattern so that model data doesn't intermix with view data.  
- I utilited a factory pattern to create the converter class.
- I utilized a command pattern with type safe return results to return the data.

The help in the application is:

Hello and welcome to the Roman Numeral Converter!
I'm glad you've decided to try me out.  Now...
Little help here...
Enter [1] at the Conv> cmd prompt to convert from Arabic Numbers to Roman Numerals.
Enter [2] at the Conv> cmd prompt to convert from Roman Numerals to Arabic Numbers.
Enter [quit] at Conv> cmd prompt to exit the application.  Why do that though?
Enter [help] at Conv> cmd prompt to print this message again.
