import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class VasyaClerk {
    public static void main(String[] args) throws Exception {
        System.out.println(Tickets(new int[] {25, 25, 50, 50, 100}));
    }
    public static String Tickets(int[] client) {
        int ticketPrice = 25;
        int total = 0;
        TreeMap < Integer, Integer > registerMoney = new TreeMap < Integer, Integer > ();
        Map < Integer, Integer > clientChange = new HashMap < Integer, Integer > ();
        registerMoney.put(client[0], 1);
        total = client[0];

        for (int i = 1; i < client.length; i++) {
            int clientMoney = client[i];

            if (registerMoney.containsKey(clientMoney)) {
                int c = registerMoney.get(clientMoney);
                registerMoney.put(clientMoney, c+1);
                total += clientMoney;
            } else {
                registerMoney.put(clientMoney, 1);
                total += clientMoney;
            }

            TreeMap < Integer, Integer > sortHash = sortByKey(registerMoney);
            registerMoney = sortHash;

            int change = clientMoney - ticketPrice;
            if ((total - change) < 0) {
                return "NO";
            }
            System.out.println("Dinero cliente "+clientMoney);
            System.out.println("Cambio "+change);
            System.out.println("Total "+total);

            if (change > 0) {
                for (Map.Entry < Integer, Integer > entry: registerMoney.descendingMap().entrySet()) {
                    int bill = entry.getKey();
                    int amount = entry.getValue();

                    System.out.println("Billete de "+bill+" x "+amount);
                    int x = 1;
                    while ((change - bill) >= 0 && x <= amount) {
                        change -= bill;
                        amount-=1;
                        clientChange.put(bill, x);
                        x++;
                    }

                    if (change == 0) {
                        break;
                    }

                }

                if (change != 0) {
                    return "NO";
                }

                for (Map.Entry < Integer, Integer > entry: clientChange.entrySet()) {
                    int bill=entry.getKey();
                    int amountRegister= registerMoney.get(bill);
                    int amountChange= entry.getValue();

                    registerMoney.put(bill,amountRegister-amountChange );
                    System.out.println("Cambio cliente "+entry.getKey()+" x "+entry.getValue());

                }



            }
            System.out.println(". . . ");
        }

        return "YES";
    }

    public static TreeMap < Integer, Integer > sortByKey(TreeMap < Integer, Integer > mapToSort) {
        TreeMap < Integer, Integer > sortedMap = new TreeMap < > ();
        sortedMap.putAll(mapToSort);
        return sortedMap;
    }

}
