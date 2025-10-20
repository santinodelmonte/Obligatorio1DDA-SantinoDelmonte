package Cancha;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tarifa {
    private static ArrayList<Tarifa> listaTarifas = new ArrayList<>();
    private int idTarifa;
    private double precio;
    private LocalDate fechaVigencia;
    private Cancha cancha;

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "idTarifa=" + idTarifa +
                ", precio=" + precio +
                ", fechaVigencia=" + fechaVigencia +
                ", id cancha=" + cancha.getId() +
                ", nombre cancha=" + cancha.getNombre() +
                '}';
    }

    public Tarifa(int idTarifa, double precio, LocalDate fechaVigencia, Cancha cancha) {
        this.idTarifa = idTarifa;
        this.precio = precio;
        this.fechaVigencia = fechaVigencia;
        this.cancha = cancha;
    }

    public static boolean agregarTarifa(Tarifa tarifa){
        if (tarifa != null){ //demas validaciones como id y demas
            listaTarifas.add(tarifa);
            return true;
        } else{
            return false;
        }
    }

    public static boolean eliminarTarifa(Tarifa tarifa){
        if (tarifa !=null){ //vuelvo a validar por las dudas
            listaTarifas.remove(tarifa);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Tarifa> getListaTarifas(){
        return listaTarifas;
    }

    public static Tarifa buscarTarifa(int idTarifa){
        for (Tarifa tarifa : listaTarifas){
            if (tarifa.idTarifa == idTarifa){
                return tarifa;
            }
        }
        return null;
    }

    public static Tarifa ultimaTarifaCancha(Cancha cancha){
        LocalDate hoy = LocalDate.now();
        LocalDate ultimaFecha = LocalDate.MIN;
        Tarifa tarifaEncontrada = null;
        for (Tarifa tarifa : listaTarifas){
            LocalDate fechaTarifa = tarifa.getFechaVigencia();
            if (!fechaTarifa.isAfter(hoy) && fechaTarifa.isAfter(ultimaFecha) && tarifa.cancha.getId() == cancha.getId()) {
                ultimaFecha = fechaTarifa;
                tarifaEncontrada = tarifa;
            }
        }
        return tarifaEncontrada;
    }

    public static int proximoIdTarifa(){
        int proximoId = 0;
        for (Tarifa tarifa : listaTarifas){
            if (tarifa.idTarifa > proximoId){
                proximoId = tarifa.idTarifa;
            }
        }
        return proximoId+1;
    }
}
