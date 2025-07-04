package iv;

/*
Pad for Michael Hayes - Senior Software Engineer

Sarah rents a car for the trip - she pays $400 for the car, which is used by Alice, John, Bob and herself. Later in the trip, John went out and bought groceries for $100, which was used only by Alice and Bob.
Now, the trip is over and everyone wants to get paid back what they are owed.
Print out the list of transactions that would settle everyone's debts.

Answer:
Alice -> Sarah: $100
Alice -> John $50
Bob -> Sarah: $100
Bob -> John $50
John -> Sarah: $100

Answer:
Alice -> Sarah: $150
Bob -> Sarah: $150

Bob -   sarah/john 150
alice   sarah/john 150

Alice   Bob     John    Sarah
-100                    100
-50             50
        -100            100
        -50     50
                -100    100
*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Payment {

    class PaymentSummary {
        String person;
        double amount = 0;

        public PaymentSummary(String person) {
            this.person = person;
        }

        @Override
        public String toString() {
            return "[" +person + " " + amount + "] ";
        }
    }
    final Map<String, PaymentSummary> payments = new TreeMap<>();

    private void calculateSinglePayment(String payer, List<String> recipients, double total) {
        double count = recipients.size();
        double perPerson = total / count;
        for(String person : recipients){
            if(!person.equals(payer))
                System.out.println(person + " -> " + payer + ": $" + perPerson);
        }
    }

    public PaymentSummary getPut(String name){
        PaymentSummary summary = payments.get(name);
        if(summary == null) {
            summary = new PaymentSummary(name);
            payments.put(name, summary);
        }
        return summary;
    }

    public void addPayment(String payerName, List<String> recipients, double total) {
        double count = recipients.size();
        double perPerson = total / count;

        final PaymentSummary payer = getPut(payerName);
        for (String recipient : recipients) {
            final PaymentSummary receiver = getPut(recipient);
            if (!recipient.equals(payer)){
                payer.amount += perPerson;
                receiver.amount -= perPerson;
            }
        }
    }

    public void aggregatePayments(String john, List<String> alice, int i) {

    }

    public static void main(String[] args) {
        final Payment payment = new Payment();

        // test case 1
        payment.calculateSinglePayment("Sarah", List.of("Alice", "John", "Bob", "Sarah"), 400);
        payment.calculateSinglePayment("John", List.of("Alice", "Bob"), 100);

        // test case 2
        payment.addPayment("Sarah", List.of("Alice", "John", "Bob", "Sarah"), 400);
        System.out.println(Arrays.toString(payment.payments.values().toArray()));
        payment.addPayment("John", List.of("Alice", "Bob"), 100);
        System.out.println(Arrays.toString(payment.payments.values().toArray()));

    }
}
