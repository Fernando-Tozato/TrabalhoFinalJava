package my.app;

import my.gui.MainInterface;
import com.formdev.flatlaf.FlatDarkLaf;

// Essa classe instancia a classe MainInterface, que inicia todo o Front-end
public class GUI {

    private final API api;
    private final MainInterface main;

    public GUI(API api) {
        FlatDarkLaf.setup();
        this.api = api;
        this.main = new MainInterface();
        main.setApi(api);
    }

    public void init() {
        main.setVisible(true);
    }
}
