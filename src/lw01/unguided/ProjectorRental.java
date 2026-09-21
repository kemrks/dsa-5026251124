package lw01.unguided;

public class ProjectorRental extends Rental{
    
    ProjectorRental(String id, int pages){
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int days = super.getDays();
        if (days > 3){
            days -= 3;
            return (3 * 60000) + (days * 45000) + 10000;
        } else {
            return days * 60000 + 10000;
        }
    }

    @Override
    String label() {
        return "Projector";
    }
    
}
