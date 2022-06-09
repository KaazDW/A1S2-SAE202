/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Groupes.Groupe12;

/**
 * Class repertoriant les données d'un aéroport.
 * @author maelgalland
 */
public class Aeroport {
   private String code;
    private String nom_ville;
    private String latitude_min;
    private String latitude_sec ;
    private String latitude_hemi ;
    private String latitude_degree;
    private String longitude_min;
    private String longitude_sec ;
    private String longitude_degree;
    private String longitude_orientation;

    /**
     * Constructeur de la class Aeroport définissant ces diférrents paramètres
     * @param nom_ville variable enregistrant le nom de la ville de l'aéroport
     * @param latitude_min variable enregistrant la latitude en minutes de l'aéroport
     * @param latitude_sec variable enregistrant la latitude en seconde de l'aéroport 
     * @param latitude_hemi variable enregistrant l'hemisphère de l'aéroport (N/S)
     * @param latitude_degree variable enregistrant la latitude en degree de l'aéroport 
     * @param longitude_min variable enregistrant la longitude en minutes de l'aéroport
     * @param longitude_sec variable enregistrant la longitude en secondes de l'aéroport
     * @param longitude_degree variable enregistrant la longitude en degree de l'aéroport
     * @param longitude_orientation variable enregistrant l'orientation de l'aéroport (E/O)
     */
    public Aeroport(String nom_ville, String latitude_min, String latitude_sec, String latitude_hemi, String latitude_degree, String longitude_min, String longitude_sec, String longitude_degree, String longitude_orientation) {
        this.nom_ville = nom_ville;
        this.latitude_min = latitude_min;
        this.latitude_sec = latitude_sec;
        this.latitude_hemi = latitude_hemi;
        this.latitude_degree = latitude_degree;
        this.longitude_min = longitude_min;
        this.longitude_sec = longitude_sec;
        this.longitude_degree = longitude_degree;
        this.longitude_orientation = longitude_orientation;
    }
    /**
     * Constructeur par défaut
     */
    public Aeroport() {
    }
    /**
     * Accesseur de la classe
     * @return code de l'aéroport
     */
    public String getCode() {
        return code;
    }
/**
 * Mutateurs de la classe
 * @param code de l'aeroport
 */
    public void setCode(String code) {
        this.code = code;
    }
/**
 * Accesseur de la classe
 * @return nom_ville de l'aéroport
 */
    public String getNom_ville() {
        return nom_ville;
    }
/**
 * Mutateur de la classe
 * @param nom_ville nom_ville de l'aéroport
 */
    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }
/**
 * Accesseur de la classe
 * @return latitude de l'aéroport en minutes
 */
    public String getLatitude_min() {
        return latitude_min;
    }
/**
 * Mutateur de la classe
 * @param latitude_min latitude de l'aéroport en minutes 
 */
    public void setLatitude_min(String latitude_min) {
        this.latitude_min = latitude_min;
    }
/**
 * Accesseur de la classe
 * @return latitude de l'aéroport en secondes
 */
    public String getLatitude_sec() {
        return latitude_sec;
    }
/**
 * Mutateur de la classe
 * @param latitude_sec latitude de l'aéroport en secondes
 */
    public void setLatitude_sec(String latitude_sec) {
        this.latitude_sec = latitude_sec;
    }
/**
 * Accesseur de la classe
 * @return hemisphère de l'aéroport (N/S)
 */
    public String getLatitude_hemi() {
        return latitude_hemi;
    }
/**
 * Mutateur de la classe
 * @param latitude_hemi hemisphère de l'aérport (N/S)
 */
    public void setLatitude_hemi(String latitude_hemi) {
        this.latitude_hemi = latitude_hemi;
    }
/**
 * Accesseur de la classe
 * @return latitude de l'aéroport en degrees
 */
    public String getLatitude_degree() {
        return latitude_degree;
    }
/**
 * Mutateur de la classe
 * @param latitude_degree latitude de l'aéroport en degrees
 */
    public void setLatitude_degree(String latitude_degree) {
        this.latitude_degree = latitude_degree;
    }
/**
 * Accesseur de la classe
 * @return longitude de l'aéroport en minutes 
 */
    public String getLongitude_min() {
        return longitude_min;
    }
/**
 * Mutateur de la classe
 * @param longitude_min longitude de l'aéroport en minutes
 */
    public void setLongitude_min(String longitude_min) {
        this.longitude_min = longitude_min;
    }
/**
 * Accesseur de la classe
 * @return longitude de l'aéroport en secondes
 */
    public String getLongitude_sec() {
        return longitude_sec;
    }
/**
 * Mutateur de la classe
 * @param longitude_sec longitude de l'aéroport en secondes
 */
    public void setLongitude_sec(String longitude_sec) {
        this.longitude_sec = longitude_sec;
    }
/**
 * Accesseur de la classe
 * @return longitude de l'aéroport en degrees
 */
    public String getLongitude_degree() {
        return longitude_degree;
    }
/**
 * Mutateur de la classe
 * @param longitude_degree longitude de l'aéroport en degrees
 */
    public void setLongitude_degree(String longitude_degree) {
        this.longitude_degree = longitude_degree;
    }
/**
 * Accesseur de la classe
 * @return l'orientation de l'aéroport (E/O)
 */
    public String getLongitude_orientation() {
        return longitude_orientation;
    }
/**
 * Mutateur de la classe
 * @param longitude_orientation orientation de l'aéroport (E/O)
 */
    public void setLongitude_orientation(String longitude_orientation) {
        this.longitude_orientation = longitude_orientation;
    }

    


}
