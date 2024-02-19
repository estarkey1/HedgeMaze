package edu.wctc;

class BasicRoom extends Room {
    public BasicRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You are in the hedge maze. Walls of leaves surround you. The blue sky shines above you.";
    }
}
