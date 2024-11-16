import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class Function_edit {
    GUIIMain gui;
    String replaceWord;
    public   Function_edit(GUIIMain gui)
    {
        this.gui = gui;
    }
    public void undo()
    {
        gui.un.undo();
    }
    public void redo()
    {
        gui.un.redo();
    }
    public void find() {
        String searchTerm = JOptionPane.showInputDialog(null, "Enter text to search:", "Search", JOptionPane.QUESTION_MESSAGE);
            if (searchTerm != null && !searchTerm.isEmpty()) {
                String searchString = searchTerm;
                gui.TextPane.getHighlighter().removeAllHighlights();
                searchAndHighlight(searchString ,0);
            }
    }
    private void searchAndHighlight(String searchString ,int i ) {
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
            String text = gui.TextPane.getText();
            int startIndex = text.indexOf(searchString);
                if(startIndex >0){
            while (startIndex >= 0) {
                int endIndex = startIndex + searchString.length();
                try {
                    gui.TextPane.getHighlighter().addHighlight(startIndex, endIndex, painter);
                    if(i==1)
                    {
                        gui.TextPane.select(startIndex, endIndex);
                      gui.TextPane.replaceSelection(replaceWord);
                    }
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                startIndex = text.indexOf(searchString, endIndex);
        }
    }
            else JOptionPane.showMessageDialog(null,"Word Not Found","search",JOptionPane.ERROR_MESSAGE);
    }
    public void replace()
    {
        JLabel label1 = new JLabel("Find what");
        JLabel label2 = new JLabel("Replace with");
        JTextField textField1 = new JTextField(14);
        JTextField textField2 = new JTextField(14);

        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);

        int option = JOptionPane.showConfirmDialog(null, panel, "Replace", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            // Perform replacement logic here
            String findText = textField1.getText();
            replaceWord = textField2.getText();
            searchAndHighlight(findText,1);
            // Your logic to replace text goes here
            JOptionPane.showMessageDialog(null, "Text replaced successfully.");
        }
    }
    }




