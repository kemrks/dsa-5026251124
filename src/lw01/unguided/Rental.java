package lw01.unguided;

public abstract class Rental implements Chargeable {

    private String id;
    private int days;

    Rental(String id, int days){

        if(days <= 0){
            throw new IllegalArgumentException("It must not be negative!");
        }

        this.id = id;
        this.days = days;
    }

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if(units <= 0){
            throw new IllegalArgumentException("It must not be negative!");
        }
        return units * calculateCharge();
    }

     String label(){
        return "Rental";
    }

    String summary(){
        return this.id + " | " + label() + " | " + calculateCharge();
    }

}