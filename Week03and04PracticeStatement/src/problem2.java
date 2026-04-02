import java.util.Arrays;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore;
    }
}

public class problem2 {

    // Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] clients) {
        int n = clients.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Ascending): " + Arrays.toString(clients));
        System.out.println("Total swaps: " + swaps);
    }

    // Insertion Sort (Descending by riskScore, then accountBalance)
    public static void insertionSort(Client[] clients) {
        int n = clients.length;

        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;

            while (j >= 0 && compare(clients[j], key) < 0) {
                clients[j + 1] = clients[j];
                j--;
            }
            clients[j + 1] = key;
        }

        System.out.println("Insertion Sort (Descending): " + Arrays.toString(clients));
    }

    // Compare for DESC riskScore, then accountBalance
    private static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return Integer.compare(c1.riskScore, c2.riskScore);
        }
        return Double.compare(c1.accountBalance, c2.accountBalance);
    }

    // Get top N highest risk clients
    public static void topRisks(Client[] clients, int topN) {
        System.out.print("Top " + topN + " risks: ");
        for (int i = 0; i < Math.min(topN, clients.length); i++) {
            System.out.print(clients[i].name + "(" + clients[i].riskScore + ")");
            if (i < topN - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // Bubble Sort
        Client[] bubbleArray = Arrays.copyOf(clients, clients.length);
        bubbleSort(bubbleArray);

        // Insertion Sort
        Client[] insertionArray = Arrays.copyOf(clients, clients.length);
        insertionSort(insertionArray);

        // Top 3 risks
        topRisks(insertionArray, 3);
    }
}