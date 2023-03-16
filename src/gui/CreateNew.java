package gui;

import javax.swing.*;

public class CreateNew
{

    protected CreateNew()
    {
        //main frame objects
        Screen.prompt = new JTextField();
        Screen.classList = new JComboBox<>();
        Screen.goClassInfo = new JButton();
        Screen.goNotes = new JButton();
        Screen.goHelp = new JButton();
        Screen.goSettings = new JButton();

        //info frame objects
        Screen.classPrompt = new JTextField();
        Screen.subPrompt = new JTextField();
        Screen.classInfo = new JTextArea();
        Screen.subInfo = new JTextArea();
        Screen.exampleCode = new JTextArea();
        Screen.fieldList = new JComboBox<>();
        Screen.methodList = new JComboBox<>();
        Screen.constList = new JComboBox<>();
        Screen.exitClassInfo = new JButton();
        Screen.moreInfo = new JButton();
        Screen.copyCode = new JButton();
        Screen.openNote = new JButton();
        Screen.goSubInfo = new JButton();

        //note frame objects
        Screen.notes = new JTextArea();
        Screen.next = new JButton();
        Screen.prev = new JButton();
        Screen.closeNotes = new JButton();

        //help frame objects
        Screen.youtubePrompt = new JTextField();
        Screen.docPrompt = new JTextField();
        Screen.webPrompt = new JTextField();
        Screen.youtubeList = new JComboBox<>();
        Screen.docList = new JComboBox<>();
        Screen.webList = new JComboBox<>();
        Screen.exitHelp = new JButton();
        Screen.goYoutube = new JButton();
        Screen.goDoc = new JButton();
        Screen.goWeb = new JButton();

        //settings frame objects
        Screen.settingsPrompt = new JTextField();
        Screen.changeLanPrompt = new JTextField();
        Screen.lanList = new JComboBox<>();
        Screen.exitSettings = new JButton();
        Screen.changeLan = new JButton();
    }

}
