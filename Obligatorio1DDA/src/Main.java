import Cancha.Cancha;
import Cancha.Deporte;
import Reserva.Reserva;
import Socio.Socio;
import Cancha.Tarifa;
import Cancha.Extra;

import java.time.LocalDate;
import java.time.LocalTime;

import static Cancha.Cancha.agregarCancha;
import static Cancha.Deporte.agregarDeporte;
import static Cancha.Extra.agregarExtra;
import static Cancha.Tarifa.agregarTarifa;
import static Menu.Menu.MenuPrincipal;
import static Reserva.Reserva.agregarReserva;
import static Socio.Socio.agregarSocio;

public class Main {
    public static void main(String[] args) {
        DatosDePrueba();
        MenuPrincipal();
    }

    public static void DatosDePrueba(){
        // --- Deporte ---
        Deporte futbol = new Deporte(1, "Fútbol");
        Deporte basquet = new Deporte(2, "Básquet");
        agregarDeporte(futbol);
        agregarDeporte(basquet);

        // --- Socio ---
        Socio socio1 = new Socio(1, "Juan", "Pérez", "González", "12345678", LocalDate.of(1990,1,15), "099123456", "Uruguay");
        Socio socio2 = new Socio(2, "María", "Rodríguez", "López", "87654321", LocalDate.of(1992,5,20), "098765432", "Uruguay");
        agregarSocio(socio1);
        agregarSocio(socio2);

        // --- Cancha ---
        Cancha cancha1 = new Cancha(1, "Cancha Central", futbol, true, 22,  "Iluminación, césped sintético");
        Cancha cancha2 = new Cancha(2, "Cancha Secundaria", basquet, false, 10, "Sin iluminación, piso de madera");
        agregarCancha(cancha1);
        agregarCancha(cancha2);

        // --- Tarifa ---
        Tarifa tarifa1 = new Tarifa(1, 500.0, LocalDate.of(2025,10,1), cancha1);
        Tarifa tarifa2 = new Tarifa(2, 300.0, LocalDate.of(2025,10,10), cancha2);
        agregarTarifa(tarifa1);
        agregarTarifa(tarifa2);

        // --- Reserva ---
        LocalDate fecha = LocalDate.of(2025, 10, 1);
        LocalDate fecha2 = LocalDate.of(2025, 10, 10);
        Reserva reserva1 = new Reserva(1, socio1, cancha1, "Reserva matutina", fecha, LocalTime.of(10,0),null , false);
        Reserva reserva2 = new Reserva(2, socio2, cancha2, "Reserva nocturna", fecha2, LocalTime.of(22,0), tarifa2, false);
        agregarReserva(reserva1);
        agregarReserva(reserva2);

        Extra extra1 = new Extra(1, "conos", 200);
        Extra extra2 = new Extra(2, "arcos", 500);
        agregarExtra(extra1);
        agregarExtra(extra2);
    }
}