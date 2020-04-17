package pf;

import pf.settings.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PF {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        Test.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/fonts/Roboto-Light.ttf")));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(PF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
