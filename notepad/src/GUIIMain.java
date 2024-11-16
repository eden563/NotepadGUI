import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIIMain implements ActionListener {

    JFrame window ;

  //  JScrollPane scrollPane;

    JMenuBar menuBar;
    JTextPane TextPane = new JTextPane();

    JMenu file_menu,edit_menu, format_menu,color_menu ;
    JMenuItem iNew_tab, iNew_Window , iOpen,iSave,iSaveAs,iSaveAll, iExit ;

    //FORMAT MENU
   // JMenu menuFormat = new JMenu("Format");
    JMenuItem  iFontArial , iFontCMCS, iFontTNR ,iFontTahoma,iFontVerdana, iFontCourier_New ,iFontSize8, iFontSize12, iFontSize16,iFontSize20 ,iFontSize24 ,iFontSize28;
    JMenu menufontSize, menuFontfamily, menuFontStyle;
    JMenuItem styleRegular, styleItalic, styleBold, styleBoldItalic;
    static int count = 1 , selectedIndex;

    //color menuItem
    JMenu iForground , iBackGround;

    JMenuItem iColor1B , iColor2B, iColor3B, iColor4B,iColor1F , iColor2F, iColor3F, iColor4F;
  //  JColorChooser cc;
   // JPanel colorChooserPanel;

    //edit menu
    JMenuItem iRedo ,iUndo , iCut, iCopy, iPaste,iFind,  iReplace,iselectedAll;
    JTabbedPane tb = new JTabbedPane();


    UndoManager un = new UndoManager();
    Handler file = new Handler(this);
    Function_Format format = new Function_Format(this);
    Function_Color functionColor = new Function_Color(this);
    Function_edit editt = new Function_edit(this);
    keyHandler Khandler = new keyHandler(this);

    public static void main(String [] args)
    {
        new GUIIMain();
    }
    public GUIIMain()
    {
        creatWindow();
        createmenuBar();
        creatFileMenu();
        createFormatMenu();
        format.selectedFont= "Arial";
        format.createFont(16 ,Font.PLAIN);
        createColorMenu();
        format.selectedFont= "Arial";
        functionColor.changeBackgroundColor("White");
        creatEditMenu();
        window.setVisible(true);

    }

    public void creatWindow()
    {
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("icon.png");
        window.setIconImage(icon.getImage());



        JTextPane jtp = new JTextPane();
        jtp.setFont(new Font("calibri", Font.PLAIN,14));
        jtp.addKeyListener(Khandler);
        jtp.addMouseListener(Khandler);


        jtp.getDocument().addUndoableEditListener(
                new  UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        un.addEdit(e.getEdit());
                    }
                });


        JScrollPane jsp = new JScrollPane(jtp);
        tb.addTab("new tab",jsp);
        tb.setSelectedIndex(0);
        TextPane = jtp;
        window.add(tb);

    }
    public void createmenuBar()
    {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        file_menu = new JMenu("File");
        file_menu.setToolTipText("Alt+F");
        menuBar.add(file_menu);

        edit_menu = new JMenu("Edit");
        edit_menu.setToolTipText("Alt+E");
        menuBar.add(edit_menu);

        format_menu = new JMenu("Format");
        format_menu.setToolTipText("Alt+R");
        menuBar.add(format_menu);

        color_menu = new JMenu("Color");
        color_menu.setToolTipText("Alt+C");
        menuBar.add(color_menu);






    }


    public void creatFileMenu()
    {
        iNew_tab = new JMenuItem("New tab  Ctrl+N");
        iNew_tab.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             JTextPane textPane = new JTextPane();
             textPane.setFont(new Font("calibri", Font.PLAIN,14));
             textPane.addKeyListener(Khandler);
             textPane.addMouseListener(Khandler);
             textPane.getDocument().addUndoableEditListener(
                     new  UndoableEditListener() {
                         public void undoableEditHappened(UndoableEditEvent e) {
                             un.addEdit(e.getEdit());
                         }
                     });
             JScrollPane scrollPane = new JScrollPane(textPane);
             TextPane = textPane;
             tb.addTab("Untiteled"+count, scrollPane);
             tb.setSelectedIndex(tb.getTabCount()-1);
             count++;
         }
     });
        iNew_tab.setActionCommand("new tab");
        file_menu.add(iNew_tab);

        iNew_Window =new JMenuItem("New window Ctrl+Shift+N");
        iNew_Window.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new GUIIMain();
            }
        });
        iNew_Window.setActionCommand("new window");
        file_menu.add(iNew_Window);
        file_menu.addSeparator();

        iOpen = new JMenuItem("Open    Ctrl+O");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("open");
        file_menu.add(iOpen);

        iSave = new JMenuItem("Save    Ctrl+S");
        iSave.addActionListener(this);
        iSave.setActionCommand("save");
        file_menu.add(iSave);

        iSaveAs = new JMenuItem("SaveAs  Ctrl+Shift+S");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("saveAs");
        file_menu.add(iSaveAs);

        iSaveAll = new JMenuItem("SaveAll  Ctrl+Alt+S");
        iSaveAll.addActionListener(this);
        iSaveAll.setActionCommand("saveAll");
        file_menu.add(iSaveAll);
        file_menu.addSeparator();


        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("exit");
        file_menu.add(iExit);
    }

    public void createFormatMenu()
    {

       menuFontfamily = new JMenu("Font Family");
       format_menu.add(menuFontfamily);
       iFontArial = new JMenuItem("Arial");
       iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFontfamily.add(iFontArial);

        iFontCMCS = new JMenuItem("Comic Sans Ms");
        iFontCMCS.addActionListener(this);
        iFontCMCS.setActionCommand("Comic Sans Ms");
        menuFontfamily.add(iFontCMCS);

        iFontTNR = new JMenuItem("Time New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Time New Roman");
        menuFontfamily.add(iFontTNR);

        iFontTahoma= new JMenuItem("Tahoma");
        iFontTahoma.addActionListener(this);
        iFontTahoma.setActionCommand("Tahoma");
        menuFontfamily.add(iFontTahoma);

        iFontVerdana= new JMenuItem("Verdana");
        iFontVerdana.addActionListener(this);
        iFontVerdana.setActionCommand("Verdana");
        menuFontfamily.add(  iFontVerdana);

        iFontCourier_New= new JMenuItem("Courier New");
        iFontCourier_New.addActionListener(this);
        iFontCourier_New.setActionCommand("CourierNew");
        menuFontfamily.add(  iFontCourier_New);

        menuFontStyle = new JMenu("Font Style");
        format_menu.add(menuFontStyle);

        styleRegular = new JMenuItem("Regular");
        styleRegular.addActionListener(this);
        styleRegular.setActionCommand("Regular");
        menuFontStyle.add(styleRegular);

        styleItalic = new JMenuItem("Italic");
        styleItalic.addActionListener(this);
        styleItalic.setActionCommand("Italic");
        menuFontStyle.add(styleItalic);


        styleBold = new JMenuItem("Bold");
        styleBold.addActionListener(this);
        styleBold.setActionCommand("Bold");
        menuFontStyle.add(styleBold);

        styleBoldItalic = new JMenuItem("BoldItalic");
        styleBoldItalic.addActionListener(this);
        styleBoldItalic.setActionCommand("BoldItalic");
        menuFontStyle.add(styleBoldItalic);

       menufontSize = new JMenu("FontSize");
       format_menu.add(menufontSize);

       iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");
        menufontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        menufontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        menufontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("20");
        menufontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");
        menufontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");
        menufontSize.add(iFontSize28);
    }

    public void createColorMenu()
    {

        iForground = new JMenu("Foreground");
        iBackGround = new JMenu("Background");
        color_menu.add(iForground);
        color_menu.add(iBackGround);

       iColor1B = new JMenuItem("White") ;
       iColor1B.addActionListener(this);
       iColor1B.setActionCommand("WhiteB");
       iBackGround.add(iColor1B);

        iColor1F = new JMenuItem("White") ;
        iColor1F.addActionListener(this);
        iColor1F.setActionCommand("WhiteF");
        iForground.add(iColor1F);

        iColor2B = new JMenuItem("Black") ;
        iColor2B.addActionListener(this);
        iColor2B.setActionCommand("BlackB");
        iBackGround.add(iColor2B);

        iColor2F = new JMenuItem("Black") ;
        iColor2F.addActionListener(this);
        iColor2F.setActionCommand("BlackF");
        iForground.add(iColor2F);



        iColor3B = new JMenuItem("Pink") ;
        iColor3B.addActionListener(this);
        iColor3B.setActionCommand("PinkB");
        iBackGround.add(iColor3B);

        iColor3F = new JMenuItem("Pink") ;
        iColor3F.addActionListener(this);
        iColor3F.setActionCommand("PinkF");
        iForground.add(iColor3F);

        iColor4B = new JMenuItem("Gray") ;
        iColor4B.addActionListener(this);
        iColor4B.setActionCommand("GrayB");
        iBackGround.add(iColor4B);

        iColor4F = new JMenuItem("Gray") ;
        iColor4F.addActionListener(this);
        iColor4F.setActionCommand("GrayF");
        iForground.add(iColor4F);
    }
    public void  creatEditMenu (){


        iCut = new JMenuItem("Cut    Ctrl+X") ;
        iCut.addActionListener(this);
        iCut.setActionCommand("cut");
        edit_menu.add(iCut);

        iCopy = new JMenuItem("Copy    Ctrl+c") ;
        iCopy.addActionListener(this);
        iCopy.setActionCommand("copy");
        edit_menu.add(iCopy);

        iPaste = new JMenuItem("Paste    Ctrl+V") ;
        iPaste.addActionListener(this);
        iPaste.setActionCommand("paste");
        edit_menu.add(iPaste);
        edit_menu.addSeparator();

        iRedo = new JMenuItem("Redo    Ctrl+Y") ;
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        edit_menu.add(iRedo);

        iUndo = new JMenuItem("Undo    Ctrl+Z") ;
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        edit_menu.add(iUndo);
        edit_menu.addSeparator();
        iFind = new JMenuItem("Find    Ctrl+F") ;
        iFind.addActionListener(this);
        iFind.setActionCommand("find");
        edit_menu.add(iFind);


        iReplace = new JMenuItem("Replace    Ctrl+H") ;
        iReplace.addActionListener(this);
        iReplace.setActionCommand("replace");
        edit_menu.add(iReplace);

        iselectedAll = new JMenuItem("Select All    Ctrl+A") ;
        iselectedAll.addActionListener(this);
        iselectedAll.setActionCommand("selectall");
        edit_menu.add(iselectedAll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String command= e.getActionCommand();
            int no_tab = tb.getTabCount();
            selectedIndex = tb.getSelectedIndex();
            JScrollPane scrollPane = (JScrollPane) tb.getComponentAt(selectedIndex);
            JViewport viewport = scrollPane.getViewport();
            TextPane = (JTextPane)viewport.getComponent(0);

        switch (command)
        {
            case "open": file.open() ; break;
            case "save": file.save() ; break;
            case "saveAs": file.saveAs() ; break;
            case "saveAll": file.saveAll(no_tab); break;
            case "exit": file.exit() ; break;
            case "Undo": editt.undo() ; break;
            case "Redo": editt.redo() ; break;
            case "cut": TextPane.cut(); break;
            case "copy": TextPane.copy(); break;
            case "paste": TextPane.paste(); break;
            case "find": editt.find(); break;
            case "selectall": TextPane.selectAll(); break;
            case "replace": editt.replace(); break;

            case "Arial":
            case "Comic Sans Ms":
            case "Tahoma":
            case "CourierNew":
            case "Verdana":
            case "Time New Roman":

                format.setFont(command);
                break;

            case "8":
            case "12":
            case "16":
            case "20":
            case "24":
            case "28":
                format.createFont(Integer.parseInt(command),TextPane.getFont().getStyle()); ; break;
            case "WhiteB":
            case "BlackB":
            case "PinkB":
            case "GrayB":

                    functionColor.changeBackgroundColor(command);
                    break;
            case "WhiteF":
            case "BlackF":
            case "PinkF":
            case "GrayF":

                    functionColor.changeForgroundColor(command);
                break;
            case "Regular":
            case "Italic":
            case "Bold":
            case "Bold Italic":
                format.setFontStyle(command);
                break;

        }
    }}

