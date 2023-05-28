package stamps.outils;

public class GestionnaireIdentifiants {
    private static GestionnaireIdentifiants instance = new GestionnaireIdentifiants() ;
    public static GestionnaireIdentifiants getInstance() { return instance; }

    private int idPizzas;
    private GestionnaireIdentifiants() {
        this.idPizzas = 0;
    }
    public int getIdPizzas(){
        return idPizzas++;
    }
}
