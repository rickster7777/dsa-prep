class javaHashmap{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline after integer

        Map<String, String> phoneBook = new HashMap<>();

        // Read n entries
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();   // name may contain spaces
            String phone = sc.nextLine();  // read phone number
            phoneBook.put(name, phone);
        }

        // Read queries until EOF
        while (sc.hasNextLine()) {
            String query = sc.nextLine();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        sc.close();
    }
}