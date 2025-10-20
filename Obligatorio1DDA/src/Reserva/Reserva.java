package Reserva;
import Cancha.Cancha;
import Socio.Socio;
import Cancha.Tarifa;
import Cancha.Extra;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    private static ArrayList<Reserva> listaReservas = new ArrayList<>();
    private int idReserva;
    private Socio socio;
    private Cancha cancha;
    private String observaciones;
    private LocalDate fecha;
    private LocalTime hora;
    private Tarifa tarifa;
    private ArrayList<Extra> listaExtras;
    private boolean pago; //true si fue paga junto con los extras

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public ArrayList<Extra> getListaExtras() {
        return listaExtras;
    }

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", id socio=" + socio.getIdSocio() +
                ", nombre socio=" + socio.getNombre() + socio.getApellidoPaterno()+
                ", id cancha=" + cancha.getId() +
                ", nombre cancha=" + cancha.getNombre() +
                ", observaciones='" + observaciones + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", id tarifa=" + tarifa.getIdTarifa() +
                ", listaExtras=" + listaExtras +
                ", pago=" + pago +
                '}';
    }

    public Reserva(int idReserva, Socio socio, Cancha cancha, String observaciones, LocalDate fecha, LocalTime hora, Tarifa tarifa, boolean pago) {
        this.idReserva = idReserva;
        this.socio = socio;
        this.cancha = cancha;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.hora = hora;
        this.tarifa = tarifa;
        this.pago = pago;
        this.listaExtras = new ArrayList<Extra>();
    }

    public static boolean agregarReserva(Reserva reserva) {
        if (reserva != null) { //demas validaciones como id y demas
            listaReservas.add(reserva);
            return true;
        } else {
            return false;
        }
    }

    public static boolean eliminarReserva(Reserva reserva) {
        if (reserva != null) { //vuelvo a validar por las dudas
            listaReservas.remove(reserva);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public static Reserva buscarReserva(int idReserva) {
        for (Reserva reserva : listaReservas) {
            if (reserva.idReserva == idReserva) {
                return reserva;
            }
        }
        return null;
    }

    public static ArrayList<LocalTime> ArrayHoras() {//genera un arrayList de horas en punto desde las 08:00-23:00
        ArrayList<LocalTime> horas = new ArrayList<>();
        horas.add(LocalTime.of(8, 0));
        horas.add(LocalTime.of(9, 0));
        horas.add(LocalTime.of(10, 0));
        horas.add(LocalTime.of(11, 0));
        horas.add(LocalTime.of(12, 0));
        horas.add(LocalTime.of(13, 0));
        horas.add(LocalTime.of(14, 0));
        horas.add(LocalTime.of(15, 0));
        horas.add(LocalTime.of(16, 0));
        horas.add(LocalTime.of(17, 0));
        horas.add(LocalTime.of(18, 0));
        horas.add(LocalTime.of(19, 0));
        horas.add(LocalTime.of(20, 0));
        horas.add(LocalTime.of(21, 0));
        horas.add(LocalTime.of(22, 0));
        horas.add(LocalTime.of(23, 0));

        return horas;
    }

    public static ArrayList<LocalTime> ListarHorasDisponibles(LocalDate fecha) {//dado una fecha retorno las horas disponibles
        ArrayList<Reserva> reservasDelDia = reservasFecha(fecha);
        ArrayList<LocalTime> horasDisponibles = ArrayHoras();
        for (Reserva reserva : reservasDelDia) {
            horasDisponibles.remove(reserva.hora);
        }
        return horasDisponibles;
    }

    public static ArrayList<Reserva> reservasFecha(LocalDate fecha) { //dado una fecha retorno las reservas del día
        ArrayList<Reserva> reservasDelDia = new ArrayList<>();
        for (Reserva reserva : listaReservas) {
            if (reserva.fecha == fecha) {
                reservasDelDia.add(reserva);
            }
        }
        return reservasDelDia;
    }

    public static LocalTime seleccionarHoraDisponible(ArrayList<LocalTime> horasDisponibles) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una hora (de 8 a 23): ");
        int horaIngresada = scanner.nextInt();

        if (horaIngresada < 8 || horaIngresada > 23) {
            System.out.println("Hora fuera de rango. Debe ser entre 8 y 23.");
            return null; // Retorna null si está fuera del rango
        }

        LocalTime horaBuscada = LocalTime.of(horaIngresada, 0);
        if (horasDisponibles.contains(horaBuscada)) {
            System.out.println("Hora disponible: " + horaBuscada);
            return horaBuscada; // Retorna la hora si está disponible
        } else {
            System.out.println("La hora " + horaIngresada + ":00 no está disponible.");
            return null; // Retorna null si la hora esta reservada
        }
    }

    public static int proximoIdReserva(){
        int proximoId = 0;
        for (Reserva reserva : listaReservas){
            if (reserva.idReserva > proximoId){
                proximoId = reserva.idReserva;
            }
        }
        return proximoId+1;
    }

    public boolean agregarExtra(Extra extra) {
        if(extra != null) { //demas validaciones como id y demas
            this.listaExtras.add(extra);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Reserva> reservasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin){
        ArrayList<Reserva> reservasEntreFechas = new ArrayList<>();
        for (Reserva reserva : listaReservas) {
            LocalDate fechaReserva = reserva.getFecha();
            if ((fechaReserva.isAfter(fechaInicio) || fechaReserva.isEqual(fechaInicio)) &&
                    (fechaReserva.isBefore(fechaFin) || fechaReserva.isEqual(fechaFin))) {
                reservasEntreFechas.add(reserva);
            }
        }
        return reservasEntreFechas;
    }




}
