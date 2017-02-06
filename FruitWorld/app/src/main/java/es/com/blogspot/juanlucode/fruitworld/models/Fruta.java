package es.com.blogspot.juanlucode.fruitworld.models;

/**
 * Created by juanluis on 6/02/17.
 */

public final class Fruta {
    private String nombre;
    private String origen;
    private int icono;

    public Fruta(String nombre, String origen, int icono) {
        this.nombre = nombre;
        this.origen = origen;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }


}
