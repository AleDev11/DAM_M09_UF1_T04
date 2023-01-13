package font.alejandro.dam.m09.uf1.t04.model.service;

import font.alejandro.dam.m09.uf1.t04.model.configuration.Settings;
import font.alejandro.dam.m09.uf1.t04.model.domain.VisitaMedica;
import font.alejandro.dam.m09.uf1.t04.model.repository.PersistenciaTexto;

public class VisitaMedicaService {
    public void guardarUsuario(VisitaMedica visitaMedica) throws Exception {
        validaciones(visitaMedica);

        EncriptaDesencripta encriptaDesencripta = new EncriptaDesencripta();
        String passwordEncriptado = encriptaDesencripta.encript(visitaMedica.getDiagnostico());
        visitaMedica.setDiagnostico(passwordEncriptado);

        PersistenciaTexto persistenciaTexto = new PersistenciaTexto();
        persistenciaTexto.save(Settings.USUARIOS_DB, visitaMedica.toCSV(), false);

    }

    public VisitaMedica getUsuario(boolean desencriptar) throws Exception {
        VisitaMedica visitaMedica;

        PersistenciaTexto persistenciaTexto = new PersistenciaTexto();
        String usuarioCSV = persistenciaTexto.readOptimitzat(Settings.USUARIOS_DB);

        visitaMedica = VisitaMedica.getAlumnoFromCSV(usuarioCSV);

        if (desencriptar) {
            EncriptaDesencripta encriptaDesencripta = new EncriptaDesencripta();
            visitaMedica.setDiagnostico(encriptaDesencripta.decrypt(visitaMedica.getDiagnostico()));
        }

        return visitaMedica;
    }



    private  void validaciones(VisitaMedica visitaMedica) {
        System.out.println("Validando datos de usuario");
        System.out.println("Validando DNI: " + visitaMedica.getDni());
        System.out.println("Validando Diagnostico: " + visitaMedica.getDiagnostico());
        if (visitaMedica == null) throw new RuntimeException("El usuario no puede ser nulo");
        if (visitaMedica.getDni() == null && checkDni(visitaMedica.getDni())) throw new RuntimeException("El DNI no puede ser nulo");
        if (visitaMedica.getDiagnostico() == null || visitaMedica.getDiagnostico().equals("")) throw new RuntimeException("El diagnostico no puede ser nulo");
    }

    private boolean checkDni(String dni) {
        if (dni.length() != 9) throw new RuntimeException("DNI incorrecto (9 caracteres)");
        String numeros = dni.substring(0, 8);
        String letra = dni.substring(8, 9);
        if (!numeros.matches("[0-9]+")) throw new RuntimeException("DNI incorrecto (8 primeros caracteres numéricos)");
        if (!letra.matches("[A-Z]")) throw new RuntimeException("DNI incorrecto (último caracter alfabético)");
        return true;
    }
}
