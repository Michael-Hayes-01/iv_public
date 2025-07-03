package iv;

/*
Pad for Michael Hayes - Senior Software Engineer

Sarah rents a car for the trip - she pays $400 for the car, which is used by Alice, John, Bob and herself. Later in the trip, John went out and bought groceries for $100, which was used only by Alice and Bob.
Now, the trip is over and everyone wants to get paid back what they are owed.
Print out the list of transactions that would settle everyone's debts.

Answer:
John -> Sarah: $100
Bob -> Sarah: $100
Alice -> Sarah: $100
Alice -> John $50
Bob -> John $50
*/

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {

    class Payment {
        String payer;
        String recipient;
        double amount;
    }
    final Map<String, Payment> payments = new TreeMap<>();

    private void calculatePayment(String payer, List<String> recipients, double total) {
        double count = recipients.size();
        double perPerson = total / count;
        for(String person : recipients){
            if(!person.equals(payer))
                System.out.println(person + " -> " + payer + ": $" + perPerson);
        }
    }


    public static void main(String[] args) {
        final App app = new App();
        app.calculatePayment("Sarah", List.of("Alice", "John", "Bob", "Sarah"), 400);
    }
}
