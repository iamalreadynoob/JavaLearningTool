package gui;

import javax.swing.*;

public class Add
{

    protected Add(JFrame frame)
    {
        //main frame objects
        frame.add(Screen.prompt);
        frame.add(Screen.classList);
        frame.add(Screen.goClassInfo);
        frame.add(Screen.goNotes);
        frame.add(Screen.goHelp);
        frame.add(Screen.goSettings);

        //info frame objects
        frame.add(Screen.classPrompt);
        frame.add(Screen.subPrompt);
        frame.add(Screen.classInfo);
        frame.add(Screen.subInfo);
        frame.add(Screen.exampleCode);
        frame.add(Screen.fieldList);
        frame.add(Screen.methodList);
        frame.add(Screen.constList);
        frame.add(Screen.exitClassInfo);
        frame.add(Screen.moreInfo);
        frame.add(Screen.copyCode);
        frame.add(Screen.openNote);
        frame.add(Screen.goSubInfo);

        //note frame objects
        frame.add(Screen.notes);
        frame.add(Screen.next);
        frame.add(Screen.prev);
        frame.add(Screen.closeNotes);

        //help frame objects
        frame.add(Screen.youtubePrompt);
        frame.add(Screen.docPrompt);
        frame.add(Screen.webPrompt);
        frame.add(Screen.youtubeList);
        frame.add(Screen.docList);
        frame.add(Screen.webList);
        frame.add(Screen.exitHelp);
        frame.add(Screen.goYoutube);
        frame.add(Screen.goDoc);
        frame.add(Screen.goWeb);

        //settings frame objects
        frame.add(Screen.settingsPrompt);
        frame.add(Screen.changeLanPrompt);
        frame.add(Screen.lanList);
        frame.add(Screen.exitSettings);
        frame.add(Screen.changeLan);
    }

}
