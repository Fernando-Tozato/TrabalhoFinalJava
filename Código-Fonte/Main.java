
import my.app.API;
import my.app.GUI;

// Essa classe inicia todo o programa instanciando uma classe API que será usada
// até o final do mesmo e uma classe GUI que iniciará todo o Front-end
public class Main {

    public static void main(String[] args) {
        API api = new API();
        GUI gui = new GUI(api);
        gui.init();
    }
}
