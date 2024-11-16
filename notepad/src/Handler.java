import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
public class Handler {
    GUIIMain gui ;
    String fileName;
    String fileAdress;
    public Handler(GUIIMain gui)
    {
       this.gui= gui;
    }
    public void open()
    {
           FileDialog fd = new FileDialog(gui.window, "open" , FileDialog.LOAD);
          fd.setVisible(true);
                if(fd.getFile() != null)
                {
                    fileName = fd.getFile();
                    fileAdress = fd.getDirectory();
                    gui.tb.setTitleAt(GUIIMain.selectedIndex,fileName);

                }
                try{
                    BufferedReader br = new BufferedReader(new FileReader(fileAdress+fileName));
                    gui.TextPane.setText("");
                    String line = null;

                    while ((line=br.readLine()) != null)
                    {
                        JTextArea textArea = new JTextArea();
                        textArea.append(line+"\n");
                        gui.TextPane.setText(textArea.getText());
                    }
                    br.close();

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"ERROR OPENNING ","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }

    public void  save() {
            if (fileName == null) saveAs();
            else {
                try {
                    FileWriter fw = new FileWriter(fileAdress + fileName);
                    fw.write(gui.TextPane.getText());
                    gui.tb.setTitleAt(GUIIMain.selectedIndex,fileName);

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"ERROR OPENNING ","ERROR",JOptionPane.ERROR_MESSAGE);
                } }
        }
    public void saveAs()
    {
        FileDialog fd = new FileDialog(gui.window, "save" , FileDialog.SAVE);
        fd.setVisible(true);
               if((fd.getFile()) != null)
               {
                   fileName = fd.getFile();
                   fileAdress = fd.getDirectory();
                   gui.tb.setTitleAt(GUIIMain.selectedIndex,fileName);

               }

               try{
                   FileWriter  fw  = new FileWriter(fileAdress+fileName);
                   fw.write(gui.TextPane.getText());
                   fw.close();

               }catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null,"ERROR SAVING ","ERROR",JOptionPane.ERROR_MESSAGE);
               }


    }
    public void saveAll(int no_tab)
    {
            for( gui.selectedIndex=0;gui.selectedIndex <no_tab; gui.selectedIndex ++)
            {
                JScrollPane scrollPane = (JScrollPane) gui.tb.getComponentAt(gui.selectedIndex );
                JViewport viewport = scrollPane.getViewport();
                JTextPane textPane = (JTextPane) viewport.getComponent(0);
                gui.TextPane = textPane;
                  saveAs();
            }
    }
    public void exit()
    {
        System.exit(0);
    }

}
