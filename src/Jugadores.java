public class Jugadores {
    private int id;
    private int edad;
    private String nombre;
    private float rendimineto;
    private String posicion;

    public Jugadores(int id, int edad, String nombre, float rendimineto, String posicion) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.rendimineto = rendimineto;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getRendimineto() {
        return rendimineto;
    }

    public void setRendimineto(float rendimineto) {
        this.rendimineto = rendimineto;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugadores" +
                "id:" + id + '\''+
                ", edad:" + edad + '\''+
                ", nombre:'" + nombre + '\'' +
                ", rendimineto:" + rendimineto +
                ", posicion:'" + posicion + '\'';
    }
}
