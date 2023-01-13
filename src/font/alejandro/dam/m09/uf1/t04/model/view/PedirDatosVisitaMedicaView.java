package font.alejandro.dam.m09.uf1.t04.model.view;

import font.alejandro.dam.m09.uf1.t04.model.domain.VisitaMedica;

public class PedirDatosVisitaMedicaView {
    public VisitaMedica getUsuario() {
        UtilidadesPeticionView utilidadesPeticion = new UtilidadesPeticionView();
        String DNI = utilidadesPeticion.getString("Introduce el DNI del usuario");
        String Diagnostico = utilidadesPeticion.getString("Introduce el diagnostico: ");

        return new VisitaMedica(DNI, Diagnostico);
    }
}
