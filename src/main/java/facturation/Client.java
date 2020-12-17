package facturation;

public class Client {
    
    enum TypeClient { 
        PARTICULIER, PROFESSIONNEL
    };


    private String nom;
    private String mail;
    private TypeClient typeClient;

    public Client(String nom, String mail, TypeClient typeClient){

        this.nom = nom;
        this.mail = mail;
        this.typeClient = typeClient;

    }

    public String info(){
        return "Nom : " + nom + "\nMail : " + mail + "\n" + typeClient;
    }

}
