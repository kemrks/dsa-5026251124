package lw01.unguided;

public class LaptopRental extends Rental {
    
    LaptopRental(String id, int pages){
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        return super.getDays() * 40000;
    }

    @Override
    String label() {
        return "Laptop";
    }
}
