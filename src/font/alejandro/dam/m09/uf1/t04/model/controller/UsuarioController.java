package font.alejandro.dam.m09.uf1.t04.model.controller;

import font.alejandro.dam.m09.uf1.t04.model.domain.VisitaMedica;
import font.alejandro.dam.m09.uf1.t04.model.service.VisitaMedicaService;
import font.alejandro.dam.m09.uf1.t04.model.view.PedirDatosVisitaMedicaView;
import font.alejandro.dam.m09.uf1.t04.model.view.UtilidadesSalidaView;

public class UsuarioController {
    public void registrarUsuario() {
        PedirDatosVisitaMedicaView formularioUsuarioView = new PedirDatosVisitaMedicaView();
        VisitaMedica visitaMedica = formularioUsuarioView.getUsuario();

        VisitaMedicaService visitaMedicaService = new VisitaMedicaService();
        try {
            visitaMedicaService.guardarUsuario(visitaMedica);
            UtilidadesSalidaView utilidadesSalidaView = new UtilidadesSalidaView();
            utilidadesSalidaView.show("Usuario registrado correctamente", false);

        } catch (Exception e) {
            UtilidadesSalidaView utilidadesSalidaView = new UtilidadesSalidaView();
            utilidadesSalidaView.show(e.getMessage(), true);
        }
    }

    public void consultaUsuario(boolean desencriptarDatos) {
        VisitaMedicaService visitaMedicaService = new VisitaMedicaService();

        try {
            VisitaMedica visitaMedica = visitaMedicaService.getUsuario(desencriptarDatos);
            UtilidadesSalidaView utilidadesSalidaView = new UtilidadesSalidaView();
            utilidadesSalidaView.show(visitaMedica.toString(), false);
        } catch (Exception e) {
            UtilidadesSalidaView utilidadesSalidaView = new UtilidadesSalidaView();
            utilidadesSalidaView.show(e.getMessage(), true);
        }
    }
}
