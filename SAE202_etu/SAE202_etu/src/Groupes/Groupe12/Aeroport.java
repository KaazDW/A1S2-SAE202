/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Groupes.Groupe12;

/**
 *
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

    public Aeroport() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }

    public String getLatitude_min() {
        return latitude_min;
    }

    public void setLatitude_min(String latitude_min) {
        this.latitude_min = latitude_min;
    }

    public String getLatitude_sec() {
        return latitude_sec;
    }

    public void setLatitude_sec(String latitude_sec) {
        this.latitude_sec = latitude_sec;
    }

    public String getLatitude_hemi() {
        return latitude_hemi;
    }

    public void setLatitude_hemi(String latitude_hemi) {
        this.latitude_hemi = latitude_hemi;
    }

    public String getLatitude_degree() {
        return latitude_degree;
    }

    public void setLatitude_degree(String latitude_degree) {
        this.latitude_degree = latitude_degree;
    }

    public String getLongitude_min() {
        return longitude_min;
    }

    public void setLongitude_min(String longitude_min) {
        this.longitude_min = longitude_min;
    }

    public String getLongitude_sec() {
        return longitude_sec;
    }

    public void setLongitude_sec(String longitude_sec) {
        this.longitude_sec = longitude_sec;
    }

    public String getLongitude_degree() {
        return longitude_degree;
    }

    public void setLongitude_degree(String longitude_degree) {
        this.longitude_degree = longitude_degree;
    }

    public String getLongitude_orientation() {
        return longitude_orientation;
    }

    public void setLongitude_orientation(String longitude_orientation) {
        this.longitude_orientation = longitude_orientation;
    }

    


}
