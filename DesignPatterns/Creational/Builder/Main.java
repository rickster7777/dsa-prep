class User {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String phone;
    private final String address;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String phone;
        private String address;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Main {

    public static void main(String[] args) {

        User user = new User.Builder()
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .email("john@gmail.com")
                .build();

        System.out.println(user);
    }
}