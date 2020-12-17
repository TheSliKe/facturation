package facturation;

public class Produit {
    
    private int code;
    private String libelle;
    private int prixHT;
    private int prixTTC;
    private TypeProduit typeProduit;

    public Produit(int code, String libelle, int prixHT, TypeProduit typeProduit){
        
        this.code = code;
        this.libelle = libelle;
        this.typeProduit = typeProduit;
        this.prixHT = prixHT;
        this.prixTTC = (int) (prixHT * (1 + this.typeProduit.getTva()));

    }

    public int getPrixHT() {
        return prixHT;
    }

    public int getPrixTTC() {
        return prixTTC;
    }

    public String info(){

        return "Ref : "+ code + " Nom : " + libelle + "\nPrixHT : " + prixHT / 100.00  + "€ PrixTTC : " + prixTTC / 100.00 + "€";

    }

}
