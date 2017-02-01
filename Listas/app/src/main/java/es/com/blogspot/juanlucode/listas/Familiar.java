package es.com.blogspot.juanlucode.listas;

/**
 * Created by juanluis on 1/02/17.
 */

public final class Familiar {
    private String nombre;
    private String parentesco;

    public Familiar(String nombre, String parentesco) {
        this.nombre = nombre;
        this.parentesco = parentesco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
