package gui;

import javax.swing.*;
import java.awt.*;

public class Positions
{

    protected Positions()
    {
        designMain();
        designInfo();
        designNote();
        designHelp();
        designSettings();
    }


    protected void designMain()
    {
        Screen.prompt.setBounds(250, 100, 400, 30);
        Screen.prompt.setBackground(null);
        Screen.prompt.setFont(getFont());
        Screen.prompt.setBorder(null);
        Screen.prompt.setEditable(false);
        Screen.prompt.setHorizontalAlignment(SwingConstants.CENTER);

        Screen.classList.setBounds(200, 280, 150, 30);
        Screen.classList.setBackground(Color.BLACK);
        Screen.classList.setForeground(Color.RED);
        Screen.classList.setBorder(null);

        Screen.goClassInfo.setBounds(550, 280, 150, 30);
        Screen.goClassInfo.setBackground(Color.BLACK);
        Screen.goClassInfo.setForeground(Color.RED);
        Screen.goClassInfo.setBorder(null);

        Screen.goNotes.setBounds(350, 340, 200, 30);
        Screen.goNotes.setBackground(Color.BLACK);
        Screen.goNotes.setForeground(Color.RED);
        Screen.goNotes.setBorder(null);

        Screen.goHelp.setBounds(350, 510, 200, 30);
        Screen.goHelp.setBackground(Color.WHITE);
        Screen.goHelp.setForeground(Color.RED);
        Screen.goHelp.setBorder(null);
        Screen.goHelp.setHorizontalAlignment(SwingConstants.CENTER);

        Screen.goSettings.setBounds(775, 15, 100, 30);
        Screen.goSettings.setBackground(Color.BLACK);
        Screen.goSettings.setForeground(Color.RED);
        Screen.goSettings.setBorder(null);
    }

    protected void designInfo()
    {
        new Visibility().setVisible(FrameNames.INFO, false, false);

        Screen.classPrompt.setBounds(50, 30, 200, 30);
        Screen.classPrompt.setBackground(null);
        Screen.classPrompt.setBorder(null);
        Screen.classPrompt.setEditable(false);
        Screen.classPrompt.setFont(getFont());

        Screen.classInfo.setBounds(50, 130, 800, 100);
        Screen.classInfo.setBackground(Color.BLACK);
        Screen.classInfo.setForeground(Color.RED);
        Screen.classInfo.setBorder(null);
        Screen.classInfo.setEditable(false);
        Screen.classInfo.setLineWrap(true);
        Screen.classInfo.setWrapStyleWord(true);

        Screen.fieldList.setBounds(50, 260, 120, 30);
        Screen.fieldList.setBackground(Color.BLACK);
        Screen.fieldList.setForeground(Color.RED);
        Screen.fieldList.setBorder(null);

        Screen.methodList.setBounds(220, 260, 120, 30);
        Screen.methodList.setBackground(Color.BLACK);
        Screen.methodList.setForeground(Color.RED);
        Screen.methodList.setBorder(null);

        Screen.constList.setBounds(390, 260, 120, 30);
        Screen.constList.setBackground(Color.BLACK);
        Screen.constList.setForeground(Color.RED);
        Screen.constList.setBorder(null);

        Screen.moreInfo.setBounds(560, 260, 120, 30);
        Screen.moreInfo.setBackground(Color.BLACK);
        Screen.moreInfo.setForeground(Color.RED);
        Screen.moreInfo.setBorder(null);

        Screen.openNote.setBounds(730, 260, 120, 30);
        Screen.openNote.setBackground(Color.BLACK);
        Screen.openNote.setForeground(Color.RED);
        Screen.openNote.setBorder(null);

        Screen.exitClassInfo.setBounds(775, 15, 100, 30);
        Screen.exitClassInfo.setBackground(Color.BLACK);
        Screen.exitClassInfo.setForeground(Color.RED);
        Screen.exitClassInfo.setBorder(null);

        Screen.subPrompt.setBounds(50, 330, 800, 30);
        Screen.subPrompt.setBackground(null);
        Screen.subPrompt.setForeground(Color.MAGENTA.darker());
        Screen.subPrompt.setBorder(null);
        Screen.subPrompt.setEditable(false);
        Screen.subPrompt.setFont(new Font("arial", Font.BOLD, 20));

        Screen.subInfo.setBounds(50, 375, 800, 75);
        Screen.subInfo.setBackground(Color.BLACK);
        Screen.subInfo.setForeground(Color.RED);
        Screen.subInfo.setBorder(null);
        Screen.subInfo.setEditable(false);
        Screen.subInfo.setLineWrap(true);
        Screen.subInfo.setWrapStyleWord(true);

        Screen.exampleCode.setBounds(50, 475, 700, 75);
        Screen.exampleCode.setBackground(Color.BLACK);
        Screen.exampleCode.setForeground(Color.RED);
        Screen.exampleCode.setBorder(null);
        Screen.exampleCode.setEditable(false);
        Screen.exampleCode.setLineWrap(true);
        Screen.exampleCode.setWrapStyleWord(true);

        Screen.copyCode.setBounds(775, 500, 75, 30);
        Screen.copyCode.setBackground(Color.BLACK);
        Screen.copyCode.setForeground(Color.RED);
        Screen.copyCode.setBorder(null);

        Screen.goSubInfo.setBounds(390, 300, 120, 30);
        Screen.goSubInfo.setBackground(Color.BLACK);
        Screen.goSubInfo.setForeground(Color.RED);
        Screen.goSubInfo.setBorder(null);
    }

    protected void designNote()
    {
        new Visibility().setVisible(FrameNames.NOTE, false);

        Screen.closeNotes.setBounds(775, 15, 100, 30);
        Screen.closeNotes.setBackground(Color.BLACK);
        Screen.closeNotes.setForeground(Color.RED);
        Screen.closeNotes.setBorder(null);

        Screen.notes.setBounds(50, 60, 800, 340);
        Screen.notes.setBackground(Color.BLACK);
        Screen.notes.setForeground(Color.RED);
        Screen.notes.setLineWrap(true);
        Screen.notes.setWrapStyleWord(true);
        Screen.notes.setBorder(null);

        Screen.prev.setBounds(50, 470, 100, 30);
        Screen.prev.setBackground(Color.BLACK);
        Screen.prev.setForeground(Color.RED);
        Screen.prev.setBorder(null);

        Screen.next.setBounds(750, 470, 100, 30);
        Screen.next.setBackground(Color.BLACK);
        Screen.next.setForeground(Color.RED);
        Screen.next.setBorder(null);
    }

    protected void designHelp()
    {
        new Visibility().setVisible(FrameNames.HELP, false);
    }

    protected void designSettings()
    {
        new Visibility().setVisible(FrameNames.SETTINGS, false);
    }

    private Font getFont()
    {
        return new Font("arial", Font.BOLD, 25);
    }

}


