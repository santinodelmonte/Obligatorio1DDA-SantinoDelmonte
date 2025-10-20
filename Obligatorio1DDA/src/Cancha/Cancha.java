package Cancha;

import java.util.ArrayList;
import java.util.List;

public class Cancha {
    private static ArrayList<Cancha> listaCanchas = new ArrayList<>();
    private int idCancha;
    private String nombre;
    private Deporte deporte;
    private boolean cubierta; //true cubierta, false descubierta
    private int capacidad;
    private String caracteristicas;

    public int getId() {
        return idCancha;
    }

    public void setId(int idCancha) {
        this.idCancha = idCancha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getCubierta() {
        return cubierta;
    }

    public void setCubierta(boolean cubierta) {
        this.cubierta = cubierta;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "Cancha{" +
                "idCancha=" + idCancha +
                ", nombre='" + nombre + '\'' +
                ", id deporte=" + deporte.getIdDeporte() +
                ", nombre deporte=" + deporte.getNombre() +
                ", cubierta=" + cubierta +
                ", capacidad=" + capacidad +
                ", caracteristicas='" + caracteristicas + '\'' +
                '}';
    }

    public Cancha(int idCancha, String nombre, Deporte deporte, boolean cubierta, int capacidad, String caracteristicas) {
        this.idCancha = idCancha;
        this.nombre = nombre;
        this.deporte = deporte;
        this.cubierta = cubierta;
        this.capacidad = capacidad;
        this.caracteristicas = caracteristicas;
    }

    public static boolean agregarCancha(Cancha cancha){
        if (cancha != null){
            listaCanchas.add(cancha);
            return true;
        } else{
            return false;
        }
    }

    public static boolean eliminarCancha(Cancha cancha){
        if (cancha !=null){
            listaCanchas.remove(cancha);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Cancha> getListaCanchas(){
        return listaCanchas;
    }

    public static Cancha buscarCancha(int idCancha){
        for (Cancha cancha : listaCanchas){
            if (cancha.idCancha == idCancha){
                return cancha;
            }
        }
        return null;
    }

    public static int proximoIdCancha(){
        int proximoId = 0;
        for (Cancha cancha : listaCanchas){
            if (cancha.idCancha > proximoId){
                proximoId = cancha.idCancha;
            }
        }
        return proximoId+1;
    }

    public static ArrayList<Cancha> CanchaPorDeporte(Deporte deporte){
        ArrayList<Cancha> canchasPorDeporte = new ArrayList<>();
        for(Cancha cancha : listaCanchas){
            if (cancha.deporte.getIdDeporte() == deporte.getIdDeporte()){
                canchasPorDeporte.add(cancha);
            }
        }
        return canchasPorDeporte;
    }

    public static ArrayList<Cancha> CanchaPorNombre(String nombre){
        ArrayList<Cancha> CanchaPorNombre = new ArrayList<>();
        for(Cancha cancha : listaCanchas){
            if (cancha.getNombre().equalsIgnoreCase(nombre)){
                CanchaPorNombre.add(cancha);
            }
        }
        return CanchaPorNombre;
    }

    public static ArrayList<Cancha> CanchaPorCondicion(boolean cubierta){
        ArrayList<Cancha> CanchaPorCondicion = new ArrayList<>();
        for(Cancha cancha : listaCanchas){
            if (cancha.getCubierta() == cubierta){
                CanchaPorCondicion.add(cancha);
            }
        }
        return CanchaPorCondicion;
    }
}
