package Cancha;

import java.util.ArrayList;

public class Extra {
    private static ArrayList<Extra> listaExtras = new ArrayList<>();
    private int idExtra;
    private String tipo;
    private double precio;

    public int getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(int idExtra) {
        this.idExtra = idExtra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "idExtra=" + idExtra +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }

    public Extra(int idExtra, String tipo, double precio) {
        this.idExtra = idExtra;
        this.tipo = tipo;
        this.precio = precio;
    }
    public static boolean agregarExtra(Extra extra){
        if (extra != null){
            listaExtras.add(extra);
            return true;
        } else{
            return false;
        }
    }

    public static boolean eliminarExtra(Extra extra){
        if (extra !=null){
            listaExtras.remove(extra);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Extra> getListaExtras(){
        return listaExtras;
    }

    public static Extra buscarExtra(int idExtra){
        for (Extra extra : listaExtras){
            if (extra.idExtra == idExtra){
                return extra;
            }
        }
        return null;
    }

    public static int proximoIdExtra(){
        int proximoId = 0;
        for (Extra extra : listaExtras){
            if (extra.idExtra > proximoId){
                proximoId = extra.idExtra;
            }
        }
        return proximoId+1;
    }

}
