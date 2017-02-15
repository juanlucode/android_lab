package juanlucode.github.com.fruitworld2.models;

/**
 * Created by juanluis on 15/02/17.
 */

public final class Fruta {

    private String nombre;
    private String descripcion;
    private int imagen;
    private int icono;
    private int cantidad;

    public Fruta(   String nombre,
                    String descripcion,
                    int imagen,
                    int icono,
                    int cantidad) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.icono = icono;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
