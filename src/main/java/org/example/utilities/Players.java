package org.example.utilities;

public enum Players {

    NATHAN("Nathan"), MACKINNON("MacKinnon"), NATHAN_MACKINNON("Nathan MacKinnon"),
    MIKKO("Mikko"), RANTANEN("Rantanen"), MIKKO_RANTANEN("Mikko Rantanen");

    private String value;

    Players(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
