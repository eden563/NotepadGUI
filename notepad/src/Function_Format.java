import java.awt.*;
import javax.swing.text.*;


public class Function_Format {
    GUIIMain gui;
    Font arial, comicSansMS, timesNewRoman, Verdana,Courier_New ,Tahoma;
    Font italic, bold, regular, bolditalic;
    Font current;
    String selectedFont;


    public Function_Format(GUIIMain gui) {
        this.gui = gui;
    }
    public void createFont(int fontSize, int Fontstyle) {

        arial = new Font("Arial",Fontstyle, fontSize);
        comicSansMS = new Font("Comic Sans MS",Fontstyle, fontSize);
        timesNewRoman = new Font("Times New Roman", Fontstyle, fontSize);
        Tahoma = new Font("Tahoma",Fontstyle, fontSize);
        Courier_New = new Font("Courier New",Fontstyle, fontSize);
        Verdana = new Font("Verdana",Fontstyle, fontSize);
        setFont(selectedFont);
    }


        public void setFont(String font) {
            selectedFont = font;
            int start = gui.TextPane.getSelectionStart();
            int end = gui.TextPane.getSelectionEnd();

            if (start != end) {
                StyledDocument doc = (StyledDocument) gui.TextPane.getDocument();
                AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
                SimpleAttributeSet sas = new SimpleAttributeSet(attrs);


                switch (selectedFont) {
                    case "Arial":
                        StyleConstants.setFontFamily(sas, "Arial");
                        StyleConstants.setFontSize(sas, arial.getSize());
                        StyleConstants.setItalic(sas, (arial.getStyle() ==Font.ITALIC));
                        StyleConstants.setBold(sas, (arial.getStyle() ==Font.BOLD));
                        break;
                    case "Comic Sans Ms":
                        StyleConstants.setFontFamily(sas, "Comic Sans MS");
                        StyleConstants.setFontSize(sas, comicSansMS.getSize());
                        StyleConstants.setItalic(sas, (comicSansMS.getStyle() ==Font.ITALIC));
                        StyleConstants.setBold(sas, (comicSansMS.getStyle() ==Font.BOLD));
                        break;
                    case "Time New Roman":
                        StyleConstants.setFontFamily(sas, "Times New Roman");
                        StyleConstants.setFontSize(sas, timesNewRoman.getSize());
                        StyleConstants.setItalic(sas, (timesNewRoman.getStyle() ==Font.ITALIC));
                        StyleConstants.setBold(sas, (timesNewRoman.getStyle() ==Font.BOLD));
                        break;
                    case "Tahoma":
                        StyleConstants.setFontFamily(sas, "Tahoma");
                        StyleConstants.setFontSize(sas, Tahoma.getSize());
                        StyleConstants.setItalic(sas, (Tahoma.getStyle() ==Font.ITALIC));
                        StyleConstants.setBold(sas, (Tahoma.getStyle() ==Font.BOLD));
                        break;
                    case "CourierNew":
                        StyleConstants.setFontFamily(sas, "Courier New");
                        StyleConstants.setFontSize(sas, Courier_New.getSize());
                        StyleConstants.setItalic(sas, (Courier_New.getStyle() ==Font.ITALIC));
                        StyleConstants.setBold(sas, (Courier_New.getStyle() ==Font.BOLD));
                        break;
                    case "Verdana":
                        StyleConstants.setFontFamily(sas, "Verdana");
                        StyleConstants.setFontSize(sas, Verdana.getSize());
                        StyleConstants.setItalic(sas, (Verdana.getStyle() ==Font.ITALIC));
                        StyleConstants.setBold(sas, (Verdana.getStyle() ==Font.BOLD));
                        break;
                }

                doc.setCharacterAttributes(start, end - start, sas, true);
            }
        }


    public void setFontStyle(String style ) {
        current = gui.TextPane.getFont();
        switch (style) {
            case "Regular":
                createFont(current.getSize(), Font.PLAIN);
                break;
            case "Italic":
                createFont(current.getSize(), Font.ITALIC);
                break;
            case "Bold":
                createFont(current.getSize(), Font.BOLD);
                break;
            case "Bold Italic":
                createFont(current.getSize(), Font.BOLD | Font.ITALIC);
                break;
        }
    }

}