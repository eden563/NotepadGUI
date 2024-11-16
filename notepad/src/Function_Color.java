import java.awt.*;

public class Function_Color {
    GUIIMain gui;

    Function_Color(GUIIMain gui)
    {
        this.gui= gui;
    }

    public void changeBackgroundColor(String color)
    {

        switch (color) {
            case "WhiteB":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.TextPane.setBackground(Color.WHITE);
                //  gui.TextPane.setForeground(Color.BLACK);
                break;

            case "BlackB":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.TextPane.setBackground(Color.BLACK);
                //  gui.TextPane.setForeground(Color.WHITE);
                break;

            case "PinkB":
                gui.window.getContentPane().setBackground(Color.PINK);
                gui.TextPane.setBackground(Color.PINK);
                //  gui.TextPane.setForeground(Color.BLACK);
                break;

            case "GrayB":
                gui.window.getContentPane().setBackground(Color.GRAY);
                gui.TextPane.setBackground(Color.GRAY);
                //  gui.TextPane.setForeground(Color.BLACK);
                break;
        }}



        public void changeForgroundColor(String color)
        {

            switch (color)
            {
                case "WhiteF":
                    gui.TextPane.setForeground(Color.WHITE);
                    break;
                    case "BlackF":
                        gui.TextPane.setForeground(Color.BLACK);
                    break;
                case "PinkF":
                      gui.TextPane.setForeground(Color.PINK);
                    break;
                case "GrayF":
                      gui.TextPane.setForeground(Color.GRAY);
                    break;
 }
    }}
