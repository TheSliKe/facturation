package facturation;

public class TypeProduit {

    private double tva;
    private String type;

    public TypeProduit(double tva, String type){

        this.tva = tva;
        this.type = type;

    }

    public double getTva() {
        return tva;
    }

    public String getType() {
        return type;
    }

}
