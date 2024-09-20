//-----------------------------------------------------
// Title: Tester for Task 2
// Author: Mahmut Emre Demir
// ID: 59344436266
// Section: 2
// Assignment: 4
// Description: This class is a tester for Task2. To test the program with different inputs, you can change the file name in the main method.
// sampleInput1.txt is provided to test the program as default. To test with different inputs simply uncomment the line 17.
// You can also create your own input files to test the program.
//-----------------------------------------------------

import java.io.File;

public class Task2Tester {
    public static void main(String[] args) {
        TXTReader txtReader = new TXTReader();
        txtReader.readTxtFile(new File("sampleinput1.txt"));
        //txtReader.readTxtFile(new File("sampleinput2.txt"));

    }
}