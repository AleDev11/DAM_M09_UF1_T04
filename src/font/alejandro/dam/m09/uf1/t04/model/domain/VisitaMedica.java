package font.alejandro.dam.m09.uf1.t04.model.domain;

import font.alejandro.dam.m09.uf1.t04.model.configuration.Settings;

import java.util.StringTokenizer;

public class VisitaMedica {
    private String dni;
    private String diagnostico;

    public VisitaMedica() {

    }

    public VisitaMedica(String dni, String diagnostico) {
        this.dni = dni;
        this.diagnostico = diagnostico;
    }

    public String toCSV() {
        return this.getDni() + Settings.CSV_SEPARATOR + this.getDiagnostico();
    }

    public static VisitaMedica getAlumnoFromCSV(String linea){
        VisitaMedica resultado = null;
        StringTokenizer st = new StringTokenizer(linea, Settings.CSV_SEPARATOR);

        if (st.countTokens() != 2) {
            throw new RuntimeException("Error al leer el fichero de usuarios");
        }

        resultado = new VisitaMedica();
        resultado.setDni(st.nextToken());
        resultado.setDiagnostico(st.nextToken());

        return resultado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "mail='" + dni + '\'' +
                ", password='" + diagnostico + '\'' +
                '}';
    }
}
