package org.example.pages.playerSearch;

public enum Players {

    NATHAN("Nathan"), MACKINNON("MacKinnon"), NATHAN_MACKINNON("Nathan MacKinnon");

    private String value;

    Players(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
