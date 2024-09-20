//-----------------------------------------------------
// Title: TXT Reader
// Author: Mahmut Emre Demir
// ID: 59344436266
// Section: 2
// Assignment: 4
// Description: This class reads the input file and processes the shipments accordingly.
//-----------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TXTReader {

    public void readTxtFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            // Reading the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Splitting the line by spaces
                String[] words = line.split("\\s+");
                // Checking the first word to determine the operation
                if (words[0].equals("schedule")) {
                    ShipmentTracking.scheduleShipment(new Shipment(words[1], Long.parseLong(words[2]), Long.parseLong(words[3])));
                } else {
                    ShipmentTracking.runTime(Long.parseLong(words[1]));
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
