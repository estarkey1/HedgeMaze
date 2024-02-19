package edu.wctc;

class ExitableRoom extends Room implements Exitable {
    public ExitableRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You see an opening in the walls, leading out into rolling green hills. This is your chance to escape.";
    }

    @Override
    public String exit(Player player) {
        return "You found your way out!";
    }
}
