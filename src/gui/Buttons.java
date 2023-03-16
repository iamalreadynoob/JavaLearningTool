package gui;

import dataTransfer.CSVComm;
import dataTransfer.CSVInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class Buttons
{
    private Boolean fromMain = null;

    protected Buttons()
    {
        main();
        info();
        note();
        help();
        settings();
    }

    private void main()
    {
        Screen.goClassInfo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (Screen.classList.getSelectedItem() != null)
                {
                    new Visibility().setVisible(FrameNames.MAIN, false);
                    new Visibility().setVisible(FrameNames.INFO, true, false);
                    new Text(false, false).loadInfo(Screen.classList.getSelectedItem().toString());
                }
            }
        });


        Screen.goNotes.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility().setVisible(FrameNames.MAIN, false);
                new Visibility().setVisible(FrameNames.NOTE, true);
                fromMain = true;
            }

        });

        Screen.goHelp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility().setVisible(FrameNames.MAIN, false);
                new Visibility().setVisible(FrameNames.HELP, true);
            }

        });

        Screen.goSettings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility().setVisible(FrameNames.MAIN, false);
                new Visibility().setVisible(FrameNames.SETTINGS, true);
            }

        });
    }

    private void info()
    {
        Screen.exitClassInfo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility().setVisible(FrameNames.INFO, false, false);
                new Visibility().setVisible(FrameNames.MAIN, true);

                Screen.fieldList.removeAllItems();
                Screen.methodList.removeAllItems();
                Screen.constList.removeAllItems();
                Screen.classList.setSelectedItem(null);
            }

        });

        Screen.moreInfo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    Desktop.getDesktop().browse(new URI(new CSVComm(CSVInfo.LINK).getCSVInfoSet().get(new Text(false, false).currentClassID(Screen.classPrompt.getText().toLowerCase()))));
                }
                catch (Exception e) {e.printStackTrace();}
            }

        });

        Screen.copyCode.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.openNote.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                fromMain = false;
                new Visibility().setVisible(FrameNames.INFO, false, false);
                new Visibility().setVisible(FrameNames.NOTE, true);
            }

        });

        Screen.goSubInfo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new SubOperating().show();
            }
        });
    }

    private void note()
    {
        Screen.next.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.prev.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.closeNotes.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility().setVisible(FrameNames.NOTE, false);

                if (fromMain) new Visibility().setVisible(FrameNames.MAIN, true);
                else if (!fromMain) new Visibility().setVisible(FrameNames.INFO, true, true);
            }

        });
    }

    private void help()
    {
        Screen.exitHelp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.goYoutube.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.goDoc.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.goWeb.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });
    }

    private void settings()
    {
        Screen.exitSettings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.changeLan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });
    }

}
