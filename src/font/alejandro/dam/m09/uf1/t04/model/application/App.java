package font.alejandro.dam.m09.uf1.t04.model.application;

import font.alejandro.dam.m09.uf1.t04.model.controller.UsuarioController;

public class App {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.registrarUsuario();
    }
}
