package org.example;

public class Frame {
    final private int firstRollPins;
    private int secondRollPins = -1;

    public Frame(int firstRollPins) {
        this.firstRollPins = firstRollPins;
    }

    public int getFirstRollPins() {
        return firstRollPins;
    }

    public int getSecondRollPins() {
        return secondRollPins;
    }

    public void setSecondRollPins(int secondRollPins) {
        this.secondRollPins = secondRollPins;
    }

    public int getPins() {
        return Math.max(firstRollPins, 0) + Math.max(secondRollPins, 0);
    }

    public int getScore() {
        return getPins();
    }

    public boolean isOpen() {
        return secondRollPins < 0;
    }

    public boolean isSpare() {
        return getPins() == 10;
    }

    public boolean isStrike() {
        return getFirstRollPins() == 10;
    }

    @Override
    public String toString() {
        if (isStrike()) {
            return String.format("%-3s", "X -");
        }
        else if (isSpare()) {
            return String.format("%-3s", firstRollPins + " /");
        }
        else {
            return String.format("%-3s", firstRollPins + " " + secondRollPins);
        }
    }

    public String toString(int frameNr) {
        if (isStrike() && frameNr > 8) {
            return String.format("%-3s","X ");
        }
        else if (isSpare()) {
            return String.format("%-3s",firstRollPins + " / ");
        }
        else if (frameNr > 9) {
            return String.format("%-3s",firstRollPins + " ");
        }
        else {
            return String.format("%-3s",firstRollPins + " " + secondRollPins+ " ");
        }
    }
}


//// todo: !!!
//class LastFrame extends Frame {
//
//    public LastFrame(int firstRollPins) {
//        super(firstRollPins);
//    }
//
//    @Override
//    public String toString() {
//        return "X " + super.toString();
//    }

//}