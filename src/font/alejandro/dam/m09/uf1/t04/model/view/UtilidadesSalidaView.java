package font.alejandro.dam.m09.uf1.t04.model.view;

public class UtilidadesSalidaView {
    public void show(String mensaje, boolean isError)
    {
        if (!isError)
        {
            System.out.println(mensaje);
        }
        else
        {
            System.err.println(mensaje);
        }
    }
}
