package gui;

import javax.swing.*;

public class Screen extends JFrame
{

    //main frame objects
    protected static JTextField prompt;
    protected static JComboBox<String> classList;
    protected static JButton goClassInfo, goNotes, goHelp, goSettings;

    //info frame objects
    protected static JTextField classPrompt, subPrompt;
    protected static JTextArea classInfo, subInfo, exampleCode;
    protected static JComboBox<String> fieldList, methodList, constList;
    protected static JButton exitClassInfo, moreInfo, copyCode, openNote, goSubInfo;

    //note frame objects
    protected static JTextArea notes;
    protected static JButton next, prev, closeNotes;

    //help frame objects
    protected static JTextField youtubePrompt, docPrompt, webPrompt;
    protected static JComboBox<String> youtubeList, docList, webList;
    protected static JButton exitHelp, goYoutube, goDoc, goWeb;

    //settings frame objects
    protected static JTextField settingsPrompt, changeLanPrompt;
    protected static JComboBox<String> lanList;
    protected static JButton exitSettings, changeLan;

    public Screen()
    {
        this.setSize(900, 600);
        this.setLayout(null);
        this.setResizable(false);

        new CreateNew();
        new Add(this);
        new Positions();
        new Text(true,true);
        new Buttons();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
