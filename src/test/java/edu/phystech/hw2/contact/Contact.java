package edu.phystech.hw2.contact;

import org.jetbrains.annotations.NotNull;

public record Contact(String username, String email) implements Comparable<Contact> {
    public static final String UNKNOWN_EMAIL = "UNKNOWN_EMAIL";
    public static final String UNKNOWN_USERNAME = "UNKNOWN_NAME";
    public static final String EMPTY_USERNAME = "username";
    public static final String EMPTY_EMAIL = "email";

    public Contact(String username) {
        this(username, UNKNOWN_EMAIL);
    }

    public Contact(String username, String email) {

        if (username == null || username.trim().isEmpty()) {
            throw new InvalidContactFieldException(EMPTY_USERNAME);
        }

        if ((email == null || !email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@gmail.com")) &&
                (email != null &&!email.equals(UNKNOWN_EMAIL))) {
            throw new InvalidContactFieldException(EMPTY_EMAIL);
        }

        this.username = username;
        this.email = email;
    }

    @Override
    public int compareTo(@NotNull Contact o) {
        return Integer.compare(this.username.length(), o.username.length());
    }
}
