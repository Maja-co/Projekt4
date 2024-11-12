package Model;

import OrdreSystem.PladsType;

public class Plads {
    private int row;
    private int seatNumber;
    private int price;
    private PladsType pladsType;

    public Plads(int row, int seatNumber, int price, PladsType pladsType) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.price = price;
        this.pladsType = pladsType;
    }


    public int getRow() {
        return row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public PladsType getPladsType() {
        return pladsType;
    }

    @Override
    public String toString() {
        return "Plads{" +
                "row=" + row +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                ", pladsType=" + pladsType +
                '}';
    }

    public void add(Plads plads) {
    }
}
