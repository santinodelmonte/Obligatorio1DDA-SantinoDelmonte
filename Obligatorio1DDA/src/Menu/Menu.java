package Menu;
import Cancha.Cancha;
import Cancha.Deporte;
import Cancha.Tarifa;
import Cancha.Extra;
import Reserva.Reserva;
import Socio.Socio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static Cancha.Cancha.*;
import static Cancha.Deporte.*;
import static Cancha.Tarifa.*;
import static Reserva.Reserva.*;
import static Socio.Socio.*;
import static Cancha.Extra.*;


public class Menu {
    public static void MenuPrincipal(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   ¡Bienvenido al Club Deportivo!   ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Cancha");
        System.out.println("2. Deporte");
        System.out.println("3. Tarifa");
        System.out.println("4. Reserva");
        System.out.println("5. Socio");
        System.out.println("6. Extras");
        System.out.println("7. Consultas");
        System.out.println("8. Salir");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println("Has seleccionado la opción: Cancha");
                MenuCancha();
                break;
            case 2:
                System.out.println("Has seleccionado la opción: Deporte");
                MenuDeporte();
                break;
            case 3:
                System.out.println("Has seleccionado la opción: Tarifa");
                MenuTarifa();
                break;
            case 4:
                System.out.println("Has seleccionado la opción: Reserva");
                MenuReserva();
                break;
            case 5:
                System.out.println("Has seleccionado la opción: Socio");
                MenuSocio();
                break;
            case 6:
                System.out.println("Has seleccionado la opción: Extra");
                MenuExtra();
                break;
            case 7:
                System.out.println("Has seleccionado la opción: Consultas");
                MenuConsultas();
                break;
            case 8:
                System.out.println("Saliendo del sistema...");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }

        MenuPrincipal();
    }

    public static void MenuCancha(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("          MENÚ DE CANCHA            ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Alta de Cancha");
        System.out.println("2. Baja de Cancha");
        System.out.println("3. Modificación de Cancha");
        System.out.println("4. Listado de Canchas");
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println(">> Opción seleccionada: Alta de Cancha");
                System.out.println("Escriba el nombre de la cancha: ");
                String nombre = scanner.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede ser vacío");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba el id del deporte: ");
                int idDeporte = scanner.nextInt();
                scanner.nextLine();
                Deporte deporte = buscarDeporte(idDeporte);
                if (deporte == null){
                    System.out.println("Deporte no encontrado");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Deporte seleccionado: "+deporte.toString());
                System.out.println("Digite 1 para confirmar, pulse otro numero para cancelar: ");
                int opcionConfirmar = scanner.nextInt();
                scanner.nextLine();
                if (opcionConfirmar != 1){
                    System.out.println("Cancelando operacion");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Digite 1 si es cubierta, 2 si no: ");
                int opcionCubierta = scanner.nextInt();
                scanner.nextLine();
                if (opcionCubierta != 1 && opcionCubierta != 2){
                    System.out.println("Opcion invalida Digite 1 o 2");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                boolean cubierta = opcionCubierta == 1;
                System.out.println("Escriba la capacidad: ");
                int capacidad = scanner.nextInt();
                scanner.nextLine();
                if (capacidad <= 0){
                    System.out.println("La capacidad debe ser mayor a 0");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba las caracteristicas de la cancha: ");
                String caracteristicas = scanner.nextLine();
                if (caracteristicas.isEmpty()) {
                    System.out.println("Las Caracteristicas no pueden ser vacías");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                int idCancha = proximoIdCancha();
                Cancha nuevaCancha = new Cancha(idCancha, nombre, deporte, cubierta, capacidad, caracteristicas);
                if (agregarCancha(nuevaCancha)){
                    System.out.println("Cancha agregada con éxito");
                } else {
                    System.out.println("Hubo un error al agregar la cancha, intente de nuevo");
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println(">> Opción seleccionada: Baja de Cancha");
                System.out.println("Digite el id de la cancha a eliminar");
                int id = scanner.nextInt();
                scanner.nextLine();
                Cancha cancha = buscarCancha(id);
                if (cancha == null){
                    System.out.println("La cancha que intenta eliminar no existe");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Seguro desea eliminar la cancha: " +cancha.toString());
                System.out.println("Digite 1 para confirmar, Digite 2 para cancelar");
                int confirmar = scanner.nextInt();
                scanner.nextLine();
                if (confirmar == 1){
                    if (eliminarCancha(cancha)){
                        System.out.println("Se eliminó el registro correctamente");
                        System.out.println("Pulse cualquier tecla para continuar...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Hubo un error al eliminar la cancha, intente de nuevo");
                }
                System.out.println("Cancha no eliminada");
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 3:
                System.out.println(">> Opción seleccionada: Modificación de Cancha");
                System.out.print("Escriba el id de la cancha a modificar: ");
                int idCanchaModificar = scanner.nextInt();
                scanner.nextLine();

                Cancha canchaModificar = buscarCancha(idCanchaModificar);
                if (canchaModificar == null) {
                    System.out.println("Cancha no encontrada.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Cancha seleccionada: " + canchaModificar.toString());
                System.out.print("Digite 1 para confirmar, pulse otro número para cancelar: ");
                int opcionConfirmarCancha = scanner.nextInt();
                scanner.nextLine();
                if (opcionConfirmarCancha != 1) {
                    System.out.println("Cancelando operación.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Ingrese los nuevos datos o '0' para mantener el actual.");

                System.out.println("Nombre actual: \"" + canchaModificar.getNombre() + "\"");
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.equals("0")) {
                    if (nuevoNombre.isEmpty()) {
                        System.out.println("El nombre no puede ser vacío.");
                    } else {
                        canchaModificar.setNombre(nuevoNombre);
                    }
                }

                System.out.println("Deporte actual: \"" + canchaModificar.getDeporte() + "\"");
                System.out.print("Nuevo deporte (o '0' para mantener): ");
                String nuevoDeporteStr = scanner.nextLine();
                if (!nuevoDeporteStr.equals("0")) {
                    System.out.println("Escriba el id del deporte: ");
                    int idDeporteModificar = scanner.nextInt();
                    scanner.nextLine();
                    Deporte deporteModificado = buscarDeporte(idDeporteModificar);
                    if (deporteModificado == null){
                        System.out.println("Deporte no encontrado");
                        System.out.println("Pulse cualquier tecla para continuar...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Deporte seleccionado: "+deporteModificado.toString());
                    System.out.println("Digite 1 para confirmar, pulse otro numero para cancelar: ");
                    int opcionConfirmarDeporte = scanner.nextInt();
                    scanner.nextLine();
                    if (opcionConfirmarDeporte != 1){
                        System.out.println("Cancelando operacion");
                        System.out.println("Pulse cualquier tecla para continuar...");
                        scanner.nextLine();
                        break;
                    }
                }

                System.out.println("¿La cancha está cubierta actualmente?: " + (canchaModificar.getCubierta() ? "Sí" : "No"));
                System.out.print("¿Desea cambiar el estado de cubierta? (1: Sí, 0: No): ");
                String opcionCubiertaModificar = scanner.nextLine();
                if (opcionCubiertaModificar.equals("1")) {
                    canchaModificar.setCubierta(!canchaModificar.getCubierta());
                }

                System.out.println("Capacidad actual: \"" + canchaModificar.getCapacidad() + "\"");
                System.out.print("Nueva capacidad: ");
                String nuevaCapacidadStr = scanner.nextLine();
                if (!nuevaCapacidadStr.equals("0")) {
                    try {
                        int nuevaCapacidad = Integer.parseInt(nuevaCapacidadStr);
                        if (nuevaCapacidad <= 0) {
                            System.out.println("La capacidad debe ser un número positivo.");
                        } else {
                            canchaModificar.setCapacidad(nuevaCapacidad);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Capacidad inválida. Debe ser un número entero.");
                    }
                }

                System.out.println("Características actuales: \"" + canchaModificar.getCaracteristicas() + "\"");
                System.out.print("Nuevas características: ");
                String nuevasCaracteristicas = scanner.nextLine();
                if (!nuevasCaracteristicas.equals("0")) {
                    if (nuevasCaracteristicas.isEmpty()) {
                        System.out.println("Las características no pueden estar vacías.");
                    } else {
                        canchaModificar.setCaracteristicas(nuevasCaracteristicas);
                    }
                }

                System.out.println("Modificación completada:");
                System.out.println(canchaModificar.toString());
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 4:
                System.out.println(">> Opción seleccionada: Listado de Canchas");
                ArrayList<Cancha> listaCanchas = getListaCanchas();
                for (Cancha c : listaCanchas){
                    System.out.println(c.toString());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 5:
                System.out.println("Volviendo al menú principal...\n");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
        }


        System.out.println();
        MenuCancha();
    }

    public static void MenuDeporte(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("          MENÚ DE DEPORTE           ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Alta de Deporte");
        System.out.println("2. Baja de Deporte");
        System.out.println("3. Listado de Deportes");
        System.out.println("4. Volver al Menú Principal");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println(">> Opción seleccionada: Alta de Deporte");
                System.out.println("Escriba el nombre del deporte: ");
                String nombre = scanner.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede ser vacío");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                int idDeporte = proximoIdDeporte();
                Deporte nuevoDeporte = new Deporte(idDeporte, nombre);
                if (agregarDeporte(nuevoDeporte)){
                    System.out.println("Deporte agregado con éxito");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                } else {
                    System.out.println("Hubo un error al agregar el deporte, intente de nuevo");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                }
                break;
            case 2:
                System.out.println(">> Opción seleccionada: Baja de Deporte");
                System.out.println("Digite el id del deporte a eliminar");
                int id = scanner.nextInt();
                scanner.nextLine();
                Deporte deporte = buscarDeporte(id);
                if (deporte == null){
                    System.out.println("El deporte que intenta eliminar no existe");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Seguro desea eliminar el deporte: " +deporte.toString());
                System.out.println("Digite 1 para confirmar, Digite 2 para cancelar");
                int confirmar = scanner.nextInt();
                scanner.nextLine();
                if (confirmar == 1){
                    if (eliminarDeporte(deporte)){
                        System.out.println("Se eliminó el registro correctamente");
                        System.out.println("Pulse cualquier tecla para continuar...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Hubo un error al eliminar el deporte, intente de nuevo");
                }
                System.out.println("Deporte no eliminado");
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 3:
                System.out.println(">> Opción seleccionada: Listado de Deportes");
                ArrayList<Deporte> listaDeportes = getListaDeportes();
                for (Deporte d : listaDeportes){
                    System.out.println(d.toString());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 4:
                System.out.println("Volviendo al menú principal...\n");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }

        System.out.println();
        MenuDeporte();
    }

    public static void MenuTarifa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("           MENÚ DE TARIFA           ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Alta de Tarifa");
        System.out.println("2. Listado de Tarifas");
        System.out.println("3. Volver al Menú Principal");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println(">> Opción seleccionada: Alta de Tarifa");
                System.out.println("Escriba el precio por hora: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                if (precio <= 0){
                    System.out.println("El precio debe ser mayor a 0");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba el id de la cancha: ");
                int idCancha = scanner.nextInt();
                scanner.nextLine();
                Cancha cancha = buscarCancha(idCancha);
                if (cancha == null){
                    System.out.println("Cancha no encontrado");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Cancha seleccionada: "+cancha.toString());
                System.out.println("Digite 1 para confirmar, pulse otro numero para cancelar: ");
                int opcionConfirmar = scanner.nextInt();
                scanner.nextLine();
                if (opcionConfirmar != 1){
                    System.out.println("Cancelando operacion");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.print("Ingrese la fecha de entrada en vigencia (formato dd-MM-yyyy): ");
                String entradaUsuario = scanner.nextLine();
                LocalDate fechaVigencia = null;
                try {
                    fechaVigencia = LocalDate.parse(entradaUsuario, formatter);

                } catch (DateTimeParseException e) {
                    System.out.println("Error: El formato de la fecha es incorrecto o la fecha no es válida.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                int idTarifa = proximoIdTarifa();
                Tarifa nuevaTarifa = new Tarifa(idTarifa, precio, fechaVigencia, cancha);
                if (agregarTarifa(nuevaTarifa)){
                    System.out.println("Tarifa agregada con éxito");
                } else {
                    System.out.println("Hubo un error al agregar la tarifa, intente de nuevo");
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println(">> Opción seleccionada: Listado de Tarifas");
                ArrayList<Tarifa> listaTarifas = getListaTarifas();
                for (Tarifa t : listaTarifas){
                    System.out.println(t.toString());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 3:
                System.out.println("Volviendo al menú principal...\n");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
        }

        System.out.println();
        MenuTarifa();
    }

    public static void MenuReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("          MENÚ DE RESERVA           ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Alta de Reserva");
        System.out.println("2. Baja de Reserva");
        System.out.println("3. Pagar Reserva");
        System.out.println("4. Listado de Reservas");
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println(">> Opción seleccionada: Alta de Reserva");

                System.out.println("Escriba el id del socio: ");
                int idSocio = scanner.nextInt();
                scanner.nextLine();
                Socio socio = buscarSocio(idSocio);
                if (socio == null) {
                    System.out.println("Socio no encontrado");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Socio seleccionado: " + socio.toString());
                System.out.println("Digite 1 para confirmar, pulse otro numero para cancelar: ");
                int opcionConfirmar = scanner.nextInt();
                scanner.nextLine();
                if (opcionConfirmar != 1) {
                    System.out.println("Cancelando operacion");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba el id de la cancha: ");
                int idCancha = scanner.nextInt();
                scanner.nextLine();
                Cancha cancha = buscarCancha(idCancha);
                if (cancha == null) {
                    System.out.println("Cancha no encontrado");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Cancha seleccionada: " + cancha.toString());
                System.out.println("Digite 1 para confirmar, pulse otro numero para cancelar: ");
                opcionConfirmar = scanner.nextInt();
                scanner.nextLine();
                if (opcionConfirmar != 1) {
                    System.out.println("Cancelando operacion");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba las observaciones de la reserva: ");
                String observaciones = scanner.nextLine();
                if (observaciones.isEmpty()) {
                    System.out.println("Las observaciones no puede ser vacías");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.print("Ingrese una fecha (formato dd-MM-yyyy): ");
                String entradaUsuario = scanner.nextLine();
                LocalDate fechaReserva = null;
                try {
                    fechaReserva = LocalDate.parse(entradaUsuario, formatter);

                } catch (DateTimeParseException e) {
                    System.out.println("Error: El formato de la fecha es incorrecto o la fecha no es válida.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                ArrayList<LocalTime> horasDisponibles = ListarHorasDisponibles(fechaReserva);
                DateTimeFormatter formatoHoras = DateTimeFormatter.ofPattern("HH:mm");
                System.out.println("Desea listar las horas disponibles para el día?");
                System.out.println("Digite 1 para confirmar, pulse otro numero para ingreso manual: ");
                opcionConfirmar = scanner.nextInt();
                scanner.nextLine();

                if (opcionConfirmar == 1) {
                    System.out.println("Horas disponibles:");
                    for (LocalTime hora : horasDisponibles) {
                        System.out.println(hora.format(formatoHoras));
                    }
                }
                LocalTime horaSeleccionada = seleccionarHoraDisponible(horasDisponibles);
                if (horaSeleccionada == null) {
                    break;
                }

                System.out.println("Desea pagar ahora?");
                System.out.println("Digite 1 para confirmar, pulse otro numero para pagar la seña: ");
                opcionConfirmar = scanner.nextInt();
                scanner.nextLine();
                Tarifa tarifa = null;
                if (opcionConfirmar != 1) {
                    tarifa = ultimaTarifaCancha(cancha);
                    System.out.println("Monto a pagar: " + tarifa.getPrecio());
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                }

                int idReserva = proximoIdReserva();
                Reserva nuevaReserva = new Reserva(idReserva, socio, cancha, observaciones, fechaReserva, horaSeleccionada, tarifa, false);
                if (agregarReserva(nuevaReserva)) {
                    System.out.println("Reserva agregada con éxito");
                } else {
                    System.out.println("Hubo un error al agregar la reserva, intente de nuevo");
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println(">> Opción seleccionada: Baja de Reserva");
                System.out.println("Digite el id de la reserva a eliminar");
                int id = scanner.nextInt();
                scanner.nextLine();
                Reserva reserva = buscarReserva(id);
                if (reserva == null) {
                    System.out.println("La reserva que intenta eliminar no existe");
                    break;
                }
                System.out.println("Seguro desea eliminar la reserva: " + reserva.toString());
                System.out.println("Digite 1 para confirmar, Digite 2 para cancelar");
                int confirmar = scanner.nextInt();
                scanner.nextLine();
                if (confirmar == 1) {
                    if (eliminarReserva(reserva)) {
                        System.out.println("Se eliminó el registro correctamente");
                        break;
                    }
                    System.out.println("Hubo un error al eliminar la reserva, intente de nuevo");
                }
                System.out.println("reserva no eliminada");
                break;
            case 3:
                System.out.println(">> Opción seleccionada: Pagar Reserva");
                System.out.println("Digite el id de la reserva a pagar");
                int idReservaPago = scanner.nextInt();
                scanner.nextLine();
                Reserva reservaPagar = buscarReserva(idReservaPago);
                if (reservaPagar == null) {
                    System.out.println("La reserva que intenta pagar no existe");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                if (reservaPagar.getPago()) {
                    System.out.println("La reserva ya fue paga en su totalidad");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Seguro desea pagar la reserva: " + reservaPagar.toString());
                System.out.println("Digite 1 para confirmar, Digite 2 para cancelar");
                int confirmarPago = scanner.nextInt();
                scanner.nextLine();
                if (confirmarPago == 1) {
                    int idExtra = -1;
                    System.out.println("Digite el id del extra a pagar (0 para finalizar): ");
                    idExtra = scanner.nextInt();
                    scanner.nextLine();

                    while (idExtra != 0) {
                        Extra extra = buscarExtra(idExtra);
                        if (extra == null) {
                            System.out.println("El extra con ID " + idExtra + " no existe. Intente de nuevo.");
                        } else {
                            reservaPagar.agregarExtra(extra);
                            System.out.println("Extra agregado: " + extra.toString());
                        }
                        System.out.println("Pulse cualquier tecla para continuar...");
                        scanner.nextLine();

                        System.out.println("Digite otro id de extra (0 para finalizar): ");
                        idExtra = scanner.nextInt();
                        scanner.nextLine();
                    }

                    double total = 0;
                    System.out.println("Detalle de factura: ");
                    if (reservaPagar.getTarifa() == null){
                        Tarifa ultimaTarifa = ultimaTarifaCancha(reservaPagar.getCancha());
                        if (ultimaTarifa == null){
                            System.out.println("Hubo un error al aplicar la tarifa, intente mas tarde");
                            System.out.println("Pulse cualquier tecla para continuar...");
                            scanner.nextLine();
                            break;
                        }
                        reservaPagar.setTarifa(ultimaTarifa);
                        System.out.println("Tarifa de Cancha: "+reservaPagar.getTarifa().getPrecio());
                        total += reservaPagar.getTarifa().getPrecio();
                    }
                    System.out.println("Costo de extras: ");

                    for (Extra e : reservaPagar.getListaExtras()){
                        System.out.println("Extra :"+e.getTipo()+"Costo: "+e.getPrecio());
                        total += e.getPrecio();
                    }

                    System.out.println("Total a pagar: "+total);
                    reservaPagar.setPago(true);
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("reserva no paga");
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 4:
                System.out.println(">> Opción seleccionada: Listado de Reservas");
                ArrayList<Reserva> listaReservas = getListaReservas();
                for (Reserva r : listaReservas){
                    System.out.println(r.toString());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 5:
                System.out.println("Volviendo al menú principal...\n");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }

        System.out.println();
        MenuReserva();
    }

    public static void MenuSocio(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("           MENÚ DE SOCIO            ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Alta de Socio");
        System.out.println("2. Baja de Socio");
        System.out.println("3. Modificación de Socio");
        System.out.println("4. Listado de Socios");
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println(">> Opción seleccionada: Alta de Socio");
                System.out.println("Escriba el nombre del socio: ");
                String nombre = scanner.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede ser vacío");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba el apellido del socio: ");
                String apellido = scanner.nextLine();
                if (apellido.isEmpty()) {
                    System.out.println("El apellido no puede ser vacío");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba el apellido materno del socio (opcional): ");
                String apellidoMaterno = scanner.nextLine();


                System.out.println("Escriba la cedula del socio (sin puntos ni guiones): ");
                String cedula = scanner.nextLine();
                if (cedula.length() != 8) {
                    System.out.println("El cedula no puede ser vacía ni diferente a 8 caracteres");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                String cedulaReconvertida;
                try {//si la conversion es correcta, la cedula contiene solo numeros
                    Integer.parseInt(cedula);
                    cedulaReconvertida = String.valueOf(cedula);
                } catch (NumberFormatException e) {
                    System.out.println("La cedula debe contener solo numeros");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.print("Ingrese una fecha de nacimiento (formato dd-MM-yyyy): ");
                String entradaUsuario = scanner.nextLine();
                LocalDate fechaNacimiento = null;
                try {
                    fechaNacimiento = LocalDate.parse(entradaUsuario, formatter);

                } catch (DateTimeParseException e) {
                    System.out.println("Error: El formato de la fecha es incorrecto o la fecha no es válida.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba el celular del socio: ");
                String celular = scanner.nextLine();
                if (celular.length() != 9) {
                    System.out.println("El celular no puede ser vacío ni diferente a 9 caracteres");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                if (!celular.startsWith("09")) {
                    System.out.println("El celular debe comenzar en 09");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Escriba el pais del socio: ");
                String pais = scanner.nextLine();
                if (pais.isEmpty()) {
                    System.out.println("El pais no puede ser vacío");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                int idSocio = proximoIdSocio();
                if (apellidoMaterno.isEmpty()){
                    Socio nuevoSocio = new Socio(idSocio, nombre, apellido, cedulaReconvertida, fechaNacimiento, celular, pais);
                    if (agregarSocio(nuevoSocio)) {
                        System.out.println("Socio agregado con éxito");
                    } else {
                        System.out.println("Hubo un error al agregar el socio, intente de nuevo");
                    }
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                } else {
                    Socio nuevoSocioMaterno = new Socio(idSocio, nombre, apellido, apellidoMaterno, cedulaReconvertida, fechaNacimiento, celular, pais);
                    if (agregarSocio(nuevoSocioMaterno)) {
                        System.out.println("Socio agregado con éxito");
                    } else {
                        System.out.println("Hubo un error al agregar el socio, intente de nuevo");
                    }
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
            case 2:
                System.out.println(">> Opción seleccionada: Baja de Socio");
                System.out.println("Digite el id del socio a eliminar");
                int id = scanner.nextInt();
                scanner.nextLine();
                Socio socio = buscarSocio(id);
                if (socio == null){
                    System.out.println("El socio que intenta eliminar no existe");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Seguro desea eliminar el socio: " +socio.toString());
                System.out.println("Digite 1 para confirmar, Digite 2 para cancelar");
                int confirmar = scanner.nextInt();
                scanner.nextLine();
                if (confirmar == 1){
                    if (eliminarSocio(socio)){
                        System.out.println("Se eliminó el registro correctamente");
                        System.out.println("Pulse cualquier tecla para continuar...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Hubo un error al eliminar el socio, intente de nuevo");
                }
                System.out.println("Socio no eliminado");
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 3:
                System.out.println(">> Opción seleccionada: Modificación de Socio");
                System.out.println("Escriba el id del socio a modificar: ");
                int idSocioModificar = scanner.nextInt();
                scanner.nextLine();
                Socio socioModificar = buscarSocio(idSocioModificar);
                if (socioModificar == null) {
                    System.out.println("Socio no encontrado");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Socio seleccionado: " + socioModificar.toString());
                System.out.println("Digite 1 para confirmar, pulse otro numero para cancelar: ");
                int opcionConfirmar = scanner.nextInt();
                scanner.nextLine();
                if (opcionConfirmar != 1) {
                    System.out.println("Cancelando operacion");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Ingrese los nuevos datos o '0' para mantener el actual.");

                System.out.println("Nombre actual: \"" + socioModificar.getNombre() + "\"");
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.equals("0")) {
                    if (nuevoNombre.isEmpty()) {
                        System.out.println("El nombre no puede ser vacío.");
                    } else {
                        socioModificar.setNombre(nuevoNombre);
                    }
                }

                System.out.println("Apellido paterno actual: \"" + socioModificar.getApellidoPaterno() + "\"");
                System.out.print("Nuevo apellido paterno: ");
                String nuevoApellidoP = scanner.nextLine();
                if (!nuevoApellidoP.equals("0")) {
                    if (nuevoApellidoP.isEmpty()) {
                        System.out.println("El apellido paterno no puede ser vacío.");
                    } else {
                        socioModificar.setApellidoPaterno(nuevoApellidoP);
                    }
                }

                System.out.println("Apellido materno actual: \"" + socioModificar.getApellidoMaterno() + "\"");
                System.out.print("Nuevo apellido materno: ");
                String nuevoApellidoM = scanner.nextLine();
                if (!nuevoApellidoM.equals("0")) {
                    socioModificar.setApellidoMaterno(nuevoApellidoM);
                }

                System.out.println("Número de documento actual: \"" + socioModificar.getNum_documento() + "\"");
                System.out.print("Nuevo número de documento (8 dígitos): ");
                String nuevoDocumento = scanner.nextLine();
                if (!nuevoDocumento.equals("0")) {
                    if (nuevoDocumento.length() != 8) {
                        System.out.println("El número de documento debe tener 8 caracteres.");
                    } else {
                        try {
                            Integer.parseInt(nuevoDocumento);
                            socioModificar.setNum_documento(nuevoDocumento);
                        } catch (NumberFormatException e) {
                            System.out.println("El número de documento debe contener solo números.");
                        }
                    }
                }

                DateTimeFormatter formatto = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.println("Fecha de nacimiento actual: \"" + socioModificar.getFechaNacimiento().format(formatto) + "\"");
                System.out.print("Nueva fecha de nacimiento (dd-MM-yyyy): ");
                String fechaEntrada = scanner.nextLine();
                if (!fechaEntrada.equals("0")) {
                    try {
                        LocalDate nuevaFecha = LocalDate.parse(fechaEntrada, formatto);
                        socioModificar.setFechaNacimiento(nuevaFecha);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha incorrecto o inválido.");
                    }
                }

                System.out.println("Teléfono actual: \"" + socioModificar.getTelefono() + "\"");
                System.out.print("Nuevo teléfono (9 dígitos, comienza con 09): ");
                String nuevoTelefono = scanner.nextLine();
                if (!nuevoTelefono.equals("0")) {
                    if (nuevoTelefono.length() != 9 || !nuevoTelefono.startsWith("09")) {
                        System.out.println("Teléfono inválido.");
                    } else {
                        socioModificar.setTelefono(nuevoTelefono);
                    }
                }

                System.out.println("País actual: \"" + socioModificar.getPais() + "\"");
                System.out.print("Nuevo país: ");
                String nuevoPais = scanner.nextLine();
                if (!nuevoPais.equals("0")) {
                    if (nuevoPais.isEmpty()) {
                        System.out.println("El país no puede estar vacío.");
                    } else {
                        socioModificar.setPais(nuevoPais);
                    }
                }

                System.out.println("Modificación completada:");
                System.out.println(socioModificar.toString());
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 4:
                System.out.println(">> Opción seleccionada: Listado de Socios");
                ArrayList<Socio> listaSocios = getListaSocios();
                for (Socio s : listaSocios){
                    System.out.println(s.toString());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 5:
                System.out.println("Volviendo al menú principal...\n");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }

        System.out.println();
        MenuSocio();
    }

    public static void MenuExtra(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("          MENÚ DE EXTRA           ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Alta de Extra");
        System.out.println("2. Baja de Extra");
        System.out.println("3. Baja de Extra");
        System.out.println("4. Listado de Extras");
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println(">> Opción seleccionada: Alta de Extra");
                System.out.println("Escriba el tipo del extra: ");
                String tipo = scanner.nextLine();
                if (tipo.isEmpty()) {
                    System.out.println("El tipo no puede ser vacío");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Escriba el precio del extra: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                if (precio <= 0){
                    System.out.println("El precio debe ser mayor a 0");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                int idExtra = proximoIdExtra();
                Extra nuevoExtra = new Extra(idExtra, tipo, precio);
                if (agregarExtra(nuevoExtra)){
                    System.out.println("Extra agregado con éxito");
                } else {
                    System.out.println("Hubo un error al agregar el extra, intente de nuevo");
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println(">> Opción seleccionada: Baja de Extra");
                System.out.println("Digite el id del extra a eliminar");
                int id = scanner.nextInt();
                scanner.nextLine();
                Extra extra = buscarExtra(id);
                if (extra == null){
                    System.out.println("El extra que intenta eliminar no existe");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Seguro desea eliminar el extra: " +extra.toString());
                System.out.println("Digite 1 para confirmar, Digite 2 para cancelar");
                int confirmar = scanner.nextInt();
                scanner.nextLine();
                if (confirmar == 1){
                    if (eliminarExtra(extra)){
                        System.out.println("Se eliminó el registro correctamente");
                        System.out.println("Pulse cualquier tecla para continuar...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Hubo un error al eliminar el Extra, intente de nuevo");
                }
                System.out.println("Extra no eliminado");
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 3:
                System.out.println(">> Opción seleccionada: Modificación de Extra");
                System.out.println("Escriba el id del extra a modificar: ");
                int idExtraModificar = scanner.nextInt();
                scanner.nextLine();
                Extra extraModificar = buscarExtra(idExtraModificar);
                if (extraModificar == null) {
                    System.out.println("Extra no encontrado");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Extra seleccionado: " + extraModificar.toString());
                System.out.println("Digite 1 para confirmar, pulse otro numero para cancelar: ");
                int opcionConfirmar = scanner.nextInt();
                scanner.nextLine();
                if (opcionConfirmar != 1) {
                    System.out.println("Cancelando operacion");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                System.out.println("Ingrese los nuevos datos o '0' para mantener el actual.");

                System.out.println("Precio actual: \"" + extraModificar.getPrecio() + "\"");
                System.out.print("Nuevo precio o '0' para mantener el actual: ");
                String nuevoPrecioEntrada = scanner.nextLine();
                if (!nuevoPrecioEntrada.equals("0")) {
                    try {
                        double nuevoPrecio = Double.parseDouble(nuevoPrecioEntrada);
                        if (nuevoPrecio < 0) {
                            System.out.println("El precio no puede ser negativo.");
                        } else {
                            extraModificar.setPrecio(nuevoPrecio);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un valor numérico válido.");
                    }
                }

                System.out.println("Modificación completada:");
                System.out.println(extraModificar.toString());
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 4:
                System.out.println(">> Opción seleccionada: Listado de Extras");
                ArrayList<Extra> listaExtras = getListaExtras();
                for (Extra e : listaExtras){
                    System.out.println(e.toString());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 5:
                System.out.println("Volviendo al menú principal...\n");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }

        System.out.println();
        MenuExtra();
    }

    public static void MenuConsultas(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("          MENÚ DE CONSULTAS           ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Cancha por Deporte");
        System.out.println("2. Cancha por Nombre");
        System.out.println("3. Cancha por fecha");
        System.out.println("4. Cancha por Condicion");
        System.out.println("5. Reserva por Periodo");
        System.out.println("6. Filtro Canchas con/sin reserva por fecha");
        System.out.println("7. Volver al Menú Principal");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (opcion) {
            case 1:
                System.out.println(">> Opción seleccionada: Cancha por Deporte");
                System.out.println("Escriba el id del deporte: ");
                int idDeporte = scanner.nextInt();
                scanner.nextLine();
                Deporte deporte = buscarDeporte(idDeporte);
                if (deporte == null){
                    System.out.println("Deporte no encontrado");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                ArrayList<Cancha> canchaPorDeporte = CanchaPorDeporte(deporte);
                if (canchaPorDeporte.isEmpty()){
                    System.out.println("No existen canchas de "+deporte.getNombre());
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Canchas de "+deporte.getNombre());
                for (Cancha cancha : canchaPorDeporte){
                    System.out.println("Id: "+cancha.getId()+ " Nombre: "+cancha.getDeporte().getNombre());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println(">> Opción seleccionada: Cancha por Nombre");
                System.out.println("Escriba el nombre de la cancha: ");
                String nombre = scanner.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede ser vacío");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                ArrayList<Cancha> canchaPorNombre = CanchaPorNombre(nombre);
                if (canchaPorNombre.isEmpty()){
                    System.out.println("No existen canchas con nombre: " +nombre);
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Canchas con nombre: "+ nombre);
                for (Cancha cancha : canchaPorNombre){
                    System.out.println("Id: "+cancha.getId()+ " Nombre: "+cancha.getNombre());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 3:
                System.out.println(">> Opción seleccionada: Canchas Con Reserva por día");
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.print("Ingrese la fecha (formato dd-MM-yyyy): ");
                String fechaEntradaUsuario = scanner.nextLine();
                LocalDate fechaInicioFiltro = null;
                try {
                    fechaInicioFiltro = LocalDate.parse(fechaEntradaUsuario, formato);
                } catch (DateTimeParseException e) {
                    System.out.println("Error: El formato de la fecha es incorrecto o la fecha no es válida.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                ArrayList<Reserva> reservaPorFecha = reservasEntreFechas(fechaInicioFiltro, fechaInicioFiltro);
                ArrayList<Cancha> listaCanchas = getListaCanchas();
                for (Cancha cancha : listaCanchas) {
                    boolean tieneReserva = false;
                    for (Reserva reserva : reservaPorFecha) {
                        if (reserva.getCancha().equals(cancha)) {
                            tieneReserva = true;
                            break;
                        }
                    }
                    if (tieneReserva) {
                        System.out.println("Cancha: " + cancha.getId() + " con reserva en el día.");
                    } else {
                        System.out.println("Cancha: " + cancha.getId() + " no tiene reserva en el día.");
                    }
                }
                break;
            case 4:
                System.out.println(">> Opción seleccionada: Cancha por Condicion");
                System.out.println("Digite 1 para listar cubiertas, 2 para no: ");
                int opcionCubierta = scanner.nextInt();
                scanner.nextLine();
                String tipoCondicion = "";
                if (opcionCubierta != 1 && opcionCubierta != 2){
                    System.out.println("Opcion invalida, Digite 1 o 2");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                boolean cubierta = false;
                if (opcionCubierta == 1){
                    cubierta = true;
                    tipoCondicion = "Cubierta";
                } else {
                    tipoCondicion = "Descubierta";
                }
                ArrayList<Cancha> canchaPorCondicion = CanchaPorCondicion(cubierta);
                System.out.println("Canchas de condicion: "+tipoCondicion);
                for (Cancha cancha : canchaPorCondicion){
                    System.out.println("Id: "+cancha.getId()+ " Nombre: "+cancha.getNombre()+ " Condicion: "+tipoCondicion);
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 5:
                System.out.println(">> Opción seleccionada: Reserva por Periodo");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.print("Ingrese la primer fecha (formato dd-MM-yyyy): ");
                String fechaInicioEntradaUsuario = scanner.nextLine();
                LocalDate fechaInicio = null;
                System.out.print("Ingrese la segunda fecha (formato dd-MM-yyyy): ");
                String fechaFinEntradaUsuario = scanner.nextLine();
                LocalDate fechaFin = null;
                try {
                    fechaInicio = LocalDate.parse(fechaInicioEntradaUsuario, formatter);
                    fechaFin = LocalDate.parse(fechaFinEntradaUsuario, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Error: El formato de la fecha es incorrecto o la fecha no es válida.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                if (fechaInicio.isAfter(fechaFin) || fechaInicio.isEqual(fechaFin)) {
                    System.out.println("Error: La fecha de inicio no puede ser igual o posterior a la fecha de fin.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                ArrayList<Reserva> reservaEntreFechas = reservasEntreFechas(fechaInicio, fechaFin);
                if (reservaEntreFechas.isEmpty()){
                    System.out.println("No existen reservas entre las fechas selecionadas");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }
                System.out.println("Reservas Entre las fechas: ");
                for (Reserva reserva : reservaEntreFechas){
                    System.out.println("Id Reserva: "+reserva.getIdReserva()+ " cancha: "+reserva.getCancha().getNombre()+ " Fecha: "+reserva.getFecha() +" Hora: "+reserva.getHora());
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 6:
                System.out.println(">> Opción seleccionada: Filtro Canchas con/sin reserva por fecha");
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.print("Ingrese la fecha (formato dd-MM-yyyy): ");
                String fechaEntradaUsuarioFecha = scanner.nextLine();
                LocalDate fechaInicioFiltroFecha = null;
                try {
                    fechaInicioFiltroFecha = LocalDate.parse(fechaEntradaUsuarioFecha, formatoFecha);
                } catch (DateTimeParseException e) {
                    System.out.println("Error: El formato de la fecha es incorrecto o la fecha no es válida.");
                    System.out.println("Pulse cualquier tecla para continuar...");
                    scanner.nextLine();
                    break;
                }

                ArrayList<Reserva> reservaPorFechaFiltro = reservasEntreFechas(fechaInicioFiltroFecha, fechaInicioFiltroFecha);
                ArrayList<Cancha> listaCanchasFiltro = getListaCanchas();
                for (Cancha cancha : listaCanchasFiltro) {
                    boolean tieneReserva = false;
                    for (Reserva reserva : reservaPorFechaFiltro) {
                        if (reserva.getCancha().equals(cancha)) {
                            tieneReserva = true;
                            break;
                        }
                    }
                    if (tieneReserva) {
                        System.out.println("Cancha: " + cancha.getId() + " con reserva en el día.");
                    } else {
                        System.out.println("Cancha: " + cancha.getId() + " no tiene reserva en el día.");
                    }
                }
                System.out.println("Pulse cualquier tecla para continuar...");
                scanner.nextLine();
                break;
            case 7:
                System.out.println("Volviendo al menú principal...\n");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }

        System.out.println();
        MenuConsultas();
    }

}
