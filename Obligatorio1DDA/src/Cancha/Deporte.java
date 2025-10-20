package Cancha;

import java.util.ArrayList;

public class Deporte {
    private static ArrayList<Deporte> listaDeportes = new ArrayList<>();
    private int idDeporte;
    private String nombre;

    public int getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        this.idDeporte = idDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "idDeporte=" + idDeporte +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Deporte(int idDeporte, String nombre) {
        this.idDeporte = idDeporte;
        this.nombre = nombre;
    }

    public static boolean agregarDeporte(Deporte deporte){
        if (deporte != null){ //demas validaciones como id y demas
            listaDeportes.add(deporte);
            return true;
        } else{
            return false;
        }
    }

    public static boolean eliminarDeporte(Deporte deporte){
        if (deporte !=null){ //vuelvo a validar por las dudas
            listaDeportes.remove(deporte);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Deporte> getListaDeportes(){
        return listaDeportes;
    }

    public static Deporte buscarDeporte(int idDeporte){
        for (Deporte deporte : listaDeportes){
            if (deporte.idDeporte == idDeporte){
                return deporte;
            }
        }
        return null;
    }

    public static int proximoIdDeporte(){
        int proximoId = 0;
        for (Deporte deporte : listaDeportes){
            if (deporte.idDeporte > proximoId){
                proximoId = deporte.idDeporte;
            }
        }
        return proximoId+1;
    }
}
