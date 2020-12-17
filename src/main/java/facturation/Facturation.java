package facturation;

import java.util.ArrayList;
import java.util.Scanner;

import facturation.Client.TypeClient;

public class Facturation {
    
    boolean running = false;
    Scanner scanner = new Scanner(System.in);

    ArrayList<Client> clients = new ArrayList<Client>();
    ArrayList<Produit> produits = new ArrayList<Produit>();
    ArrayList<Facture> factures = new ArrayList<Facture>();

    TypeProduit typeProduit = new TypeProduit(0.2, "TVA 20%");

    public void run(){
        running = true;

        while (running) {
            
            System.out.println("##############");
            System.out.println("-----Menu-----");
            System.out.println("1 - Ajout client");
            System.out.println("2 - List client");
            System.out.println("3 - Ajout produit");
            System.out.println("4 - List produits");
            System.out.println("5 - Crée facture");
            System.out.println("6 - List facture");
            System.out.println("x - Quitter");

           switch (scanner.next()) {
                case "x":
                    running = false;
                    break;
                case "1":
                    ajoutClient();
                    break;
                case "2":
                    listClients();
                    break;
                case "3":
                    ajoutProduits();
                    break;
                case "4":
                    listProduits();
                    break;
                case "5":
                    addFacture();
                    break;
                case "6":
                    listFacture();
                    break;
           }
          
        }

        
    }

    //------------------------------facture

    private void addFacture() {

        System.out.println("________ Crée une facture _______");

        System.out.println("_______ Choix du clients _______");
        int index = 0;
        for (Client client : clients) {
            System.out.println("------- Client n°" + (index++) + " ------");
            System.out.println(client.info());
            System.out.println("-------------");
        }
        System.out.println("N° du client :");
        String idClients = scanner.next();

        factures.add(new Facture(factures.size(), clients.get(Integer.parseInt(idClients))));


        System.out.println("_______ Ajouts du ou des produits _______");
        boolean ajoutProduit = true;

        while(ajoutProduit){

            System.out.println("-----------------");
            System.out.println("1 - Ajouter un produit");
            System.out.println("2 - Retirer un produit");
            System.out.println("x - Fin");

           switch (scanner.next()) {
                case "x":
                    ajoutProduit = false;
                    break;
                case "1":
                    ajoutProduitFacture();
                    break;
                case "2":
                    suppProduitFacture();
                    break;
                
            
            }

        }

    }

    private void ajoutProduitFacture() {

        listProduits();
        System.out.println("N° du Produit à ajouter :");
        String idProduit = scanner.next();
        System.out.println("Quantité :");
        String nbProduit = scanner.next();

        factures.get(factures.size() - 1).ajouterProduit(produits.get(Integer.parseInt(idProduit)), Integer.parseInt(nbProduit));

    }

    private void suppProduitFacture() {

        listProduits();
        System.out.println("N° du Produit à supprimer :");
        String idProduit = scanner.next();
        System.out.println("Quantité à supprimer:");
        String nbProduit = scanner.next();

        factures.get(factures.size() - 1).RetirerProduit(produits.get(Integer.parseInt(idProduit)), Integer.parseInt(nbProduit));;

    }

    private void listFacture(){

        System.out.println("_______ Liste des factures _______");

        int index = 0;
        for (Facture facture : factures) {
            System.out.println("------- Facture n°" + (index++) + " ------");
            facture.print();
            System.out.println("--------------");
        }

    }

    //------------------------------produit

   

    private void ajoutProduits() {

        System.out.println("______________");
        System.out.println("Ref produit :");
        String code = scanner.next();
        System.out.println("Libelle produit :");
        String libelle = scanner.next();

        int prix = demandePrixProduit();

        produits.add(new Produit(Integer.parseInt(code), libelle, prix, typeProduit));

    }

    private int demandePrixProduit(){

        boolean checkPrix = true;
        while(checkPrix){

            System.out.println("Prix HT produit(ex : 10.00) :");
            String prixtemp = scanner.next();
           
            String[] parts = prixtemp.split("\\.");

            if (Integer.parseInt(parts[0] + parts[1]) == 0) {
                System.out.println("pas de zero");
            } else {
                return Integer.parseInt(parts[0] + parts[1]);
            }
            
        }
        return 1;

    }

    private void listProduits(){

        System.out.println("_______ Liste des produits _______");

        int index = 0;
        for (Produit produit : produits) {
            System.out.println("------- Produit n°" + (index++) + " ------");
            System.out.println(produit.info());
            System.out.println("--------------");
        }

    }

    //--------------------------------client

    private void ajoutClient() {

        System.out.println("______________");
        System.out.println("Nom client :");
        String nom = scanner.next();

        System.out.println("Mail client :");
        String mail = scanner.next();
        
        boolean type = true;
        TypeClient typeClient = null;
        while (type) {
          
        
            System.out.println("Type client (0-particulier / 1-professionnel) :");
            switch (scanner.next()) {
                case "0":
                    typeClient = TypeClient.PARTICULIER;
                    type = false;
                    break;
                case "1":
                    typeClient = TypeClient.PROFESSIONNEL;
                    type = false;
                    break;
            }

        }

        clients.add(new Client(nom, mail, typeClient));

    }

    private void listClients(){

        System.out.println("_______ Liste des clients _______");
        int index = 0;
        for (Client client : clients) {
            System.out.println("------- Client n°" + (index++) + " ------");
            System.out.println(client.info());
            System.out.println("-------------");
        }

    }

}
