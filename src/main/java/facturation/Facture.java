package facturation;

import java.util.Date;
import java.util.HashMap;


public class Facture {
    
    private int montantTTC;
    private int montantHT;
    private HashMap<Produit, Integer> listProduits;
    private int id;
    private Date date;
    private Client client;

    public Facture(int id, Client client){

        this.montantHT = 0;
        this.montantTTC = 0;
        this.listProduits = new HashMap<Produit, Integer>();
        this.id = id;
        this.date = new Date();
        this.client = client;

    }

    public void ajouterProduit(Produit produit, int nb){

        if (listProduits.containsKey(produit)) {
            listProduits.put(produit, listProduits.get(produit) + nb);
        } else {
            listProduits.put(produit, nb);
        }

        calculMontantFacture();

    }

    public void RetirerProduit(Produit produit, int nb){


        listProduits.put(produit, listProduits.get(produit) - nb);

        calculMontantFacture();

    }

    private void calculMontantFacture(){

        montantHT = 0;
        montantTTC = 0;

        for(HashMap.Entry<Produit, Integer> entry : listProduits.entrySet()) {
            Produit key = entry.getKey();
            Integer value = entry.getValue();
        
            montantHT += key.getPrixHT() * value;

            montantTTC += key.getPrixTTC() * value;

        }

    }

    public void print() {

        System.out.println("########## Facture ##########");
        System.out.println("ID de facture : " + id);
        System.out.println(client.info());
        System.out.println("Date de la Facture : " + date);
        System.out.println("_______ Liste Produits ______");
        for(HashMap.Entry<Produit, Integer> entry : listProduits.entrySet()) {
            Produit key = entry.getKey();
            Integer value = entry.getValue();
        
            System.out.println(key.info());
            System.out.println("Quantité : " + value);
            System.out.println("~~~~~~~~~~");

        }
        System.out.println("__________ Montants _________");
        System.out.println("Montant HT : " + (double) montantHT / 100 + "€");
        System.out.println("Montant TTC : " + (double) montantTTC / 100 + "€");
    }

}
