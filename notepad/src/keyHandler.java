import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class keyHandler implements KeyListener , MouseListener {
    GUIIMain gui;
    public keyHandler(GUIIMain gui)
    {
        this.gui = gui;
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O)
        {
            gui.file.open();
        }

        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)
        {
            gui.file.save();
        }

        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S)
        {
            gui.file.saveAs();
        }
        if (e.isControlDown() && e.isAltDown() && e.getKeyCode() == KeyEvent.VK_S)
        {
            gui.file.saveAll(gui.tb.getTabCount());
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            gui.file.exit();
        }
        if(e.isControlDown() && e.getKeyCode() ==KeyEvent.VK_N)
        {
            gui.iNew_tab.doClick();
        }

        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_N)
        {
            gui.iNew_Window.doClick();
        }

        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z)
        {
            gui.editt.undo();
        }
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y)
        {
            gui.editt.redo();
        }

        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F)
        {
            gui.editt.find();
        }
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_H)
        {
            gui.editt.replace();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_E)
        {
            gui.edit_menu.doClick();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_C)
        {
            gui.color_menu.doClick();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_R)
        {
            gui.format_menu.doClick();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
        gui.TextPane.getHighlighter().removeAllHighlights();
 }
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
