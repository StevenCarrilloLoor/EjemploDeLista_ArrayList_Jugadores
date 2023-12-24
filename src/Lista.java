import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lista {
    private List<Jugadores> equipo;

    public Lista() {
        equipo=new ArrayList<Jugadores>();
    }
    public void ordenarPorRendimiento() {
        Collections.sort(equipo, Comparator.comparing(Jugadores::getRendimineto));
    }

    public List<Jugadores> getEquipo() {
        return equipo;
    }

    public void ingresar(Jugadores dato){
        equipo.add(dato);
    }
    public String listarJugadores(){
        String impresion="";
        for (Jugadores j :equipo) {
            impresion+=equipo.toString();
        }
        return equipo.size()>0?impresion:"No hay elementos";
    }

    public boolean actualizar(Jugadores dato){
        for (Jugadores j:equipo) {
            if (j.getId()==dato.getId()){
                j.setNombre(dato.getNombre());
                j.setPosicion(dato.getPosicion());
                j.setRendimineto(dato.getRendimineto());
                return true;
            }

        }
        return false;
    }
    private float sumaDeRendimietos(int indice, String posicion){
        if(indice==equipo.size()){
            //caso base
            return 0;
        }else{
            //caso general
            if (!equipo.get(indice).getPosicion().equals(posicion)){
                return sumaDeRendimietos(indice+1,posicion);
            }else{
                return equipo.get(indice).getRendimineto()+sumaDeRendimietos(indice+1,posicion);
            }
        }

    }
    public float suma(String posicion){
        return sumaDeRendimietos(0,posicion);
    }
}
