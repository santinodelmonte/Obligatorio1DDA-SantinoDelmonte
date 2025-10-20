package Socio;
import Cancha.Deporte;

import java.time.LocalDate;
import java.util.ArrayList;

public class Socio {
    private static ArrayList<Socio> listaSocios = new ArrayList<>();
    private int idSocio;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno; //opcional
    private String num_documento;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String pais;

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "idSocio=" + idSocio +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", num_documento='" + num_documento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono='" + telefono + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    public Socio(int idSocio, String nombre, String apellidoPaterno, String apellidoMaterno, String num_documento, LocalDate fechaNacimiento, String telefono, String pais) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.num_documento = num_documento;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.pais = pais;
    }

    public Socio(int idSocio, String nombre, String apellidoPaterno, String num_documento, LocalDate fechaNacimiento, String telefono, String pais) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = "";
        this.num_documento = num_documento;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.pais = pais;
    }

    public static boolean agregarSocio(Socio socio){
        if (socio != null){
            listaSocios.add(socio);
            return true;
        } else{
            return false;
        }
    }

    public static boolean eliminarSocio(Socio socio){
        if (socio !=null){
            listaSocios.remove(socio);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Socio> getListaSocios(){
        return listaSocios;
    }

    public static Socio buscarSocio(int idSocio){
        for (Socio socio : listaSocios){
            if (socio.idSocio == idSocio){
                return socio;
            }
        }
        return null;
    }

    public static int proximoIdSocio(){
        int proximoId = 0;
        for (Socio socio : listaSocios){
            if (socio.idSocio > proximoId){
                proximoId = socio.idSocio;
            }
        }
        return proximoId+1;
    }
}
