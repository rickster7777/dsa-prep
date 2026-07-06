

interface Notification {
    void send();
}

// Concrete implementations:

class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Email");
    }
}

class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS");
    }
}

// Client code:

public class Problem {

    public static void main(String[] args) {
        Notification notification = new EmailNotification();
        notification.send();

        /*
        What's the problem ?
        If tomorrow you want to send an SMS instead of an email, you have to change the client:
        Notification notification = new SMSNotification();
        The client is tightly coupled to concrete classes.
        */
    }
}

