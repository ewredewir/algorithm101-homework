
# [CMPE223/242](https://www.tedu.edu.tr/en/node/22460) - Programming Homework 4

This repository contains the solution to **Programming Homework 4** for the CMPE223/242 course, Spring 2024. The assignment focuses on efficient data structure implementations using heap-based priority queues for two different tasks.

## Overview

### Task 1: Median Age Calculation
In this task, we implement an efficient algorithm to calculate the **median age** of users dynamically for the Exxen streaming platform. We use two heaps:
- **Max-Heap**: Stores the smaller half of the ages.
- **Min-Heap**: Stores the larger half of the ages.

The algorithm ensures efficient insertion and retrieval of the median after each new user signs up.

#### Example Usage
```java
MedianOfAges medianOfAges = new MedianOfAges();
medianOfAges.insertNum(22);
medianOfAges.insertNum(35);
System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());

medianOfAges.insertNum(30);
System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());

medianOfAges.insertNum(25);
System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());
```

#### Example Output
```
The recommended content will be for ages under: 28.5
The recommended content will be for ages under: 30.0
The recommended content will be for ages under: 27.5
```

### Task 2: Priority-Based Task Scheduling
In this task, we create a **heap-based priority queue** to manage task scheduling based on deadlines and durations, simulating a real-world logistics problem. The system handles task execution based on priority and advances the internal time variable accordingly.

#### Example Input (sampleinput1.txt)
```
schedule shipmentA 1300 30
schedule shipmentB 7200 2300
schedule shipmentC 2359 300
run 2400
```

#### Example Output
```
0: adding shipmentA with deadline 1300 and duration 30
0: adding shipmentB with deadline 7200 and duration 2300
0: adding shipmentC with deadline 2359 and duration 300
0: busy with shipmentA with deadline 1300 and duration 30
30: done with shipmentA
30: busy with shipmentC with deadline 2359 and duration 300
330: done with shipmentC
330: busy with shipmentB with deadline 7200 and duration 2300
2400: adding shipmentB with deadline 7200 and duration 230
```

## Project Structure

- `Shipment.java`: Defines the **Shipment** object with properties such as name, deadline, and duration. It also includes an overridden `toString()` method for printing shipment details.
- `ShipmentComparator.java`: Implements the `Comparator<Shipment>` interface to compare and sort shipments based on their deadlines.
- `ShipmentTracking.java`: Manages the shipment process with methods such as `scheduleShipment()`, `startShipment()`, `completeShipment()`, and `runTime()`.
- `TXTReader.java`: Reads input files and processes the shipment tasks accordingly.
- `Task2Tester.java`: A tester class that uses `TXTReader` to load and test different input files such as `sampleinput1.txt` and `sampleinput2.txt`.
- `sampleinput1.txt`: A sample input file used for testing the task scheduling system.
- `README.md`: Project documentation.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/ewredewir/algorithm101-homework.git
   ```
2. Compile all the Java files:
   ```bash
   javac Shipment.java ShipmentComparator.java ShipmentTracking.java TXTReader.java Task2Tester.java
   ```
3. Run **Task 2** with the sample input:
   ```bash
   java Task2Tester
   ```

By default, the `Task2Tester.java` uses the `sampleinput1.txt` file, but you can test other inputs by creating new `.txt` files and providing their paths to the `TXTReader` as shown:
```java
TXTReader txtReader = new TXTReader();
txtReader.readTxtFile(new File("your_input_file.txt"));
```

## Features

- **Dynamic Median Calculation**: Efficient median age retrieval using two heaps for dynamic user data.
- **Priority-Based Task Scheduling**: Simulated logistics scheduling using custom heap-based priority queues.

## License

This project is for educational purposes and is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
