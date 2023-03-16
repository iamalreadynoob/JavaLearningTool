package gui;

public class Visibility
{

    protected void setVisible(FrameNames frame, boolean visibility)
    {
        switch (frame)
        {
            case MAIN: main(visibility); break;
            case NOTE: note(visibility); break;
            case HELP: help(visibility); break;
            case SETTINGS: settings(visibility); break;
        }
    }

    protected void setVisible(FrameNames frame, boolean visibility, boolean subVisibility)
    {
        if (frame == FrameNames.INFO) info(visibility, subVisibility);
    }

    private void main(boolean visibility)
    {
        Screen.prompt.setVisible(visibility);
        Screen.classList.setVisible(visibility);
        Screen.goClassInfo.setVisible(visibility);
        Screen.goNotes.setVisible(visibility);
        Screen.goHelp.setVisible(visibility);
        Screen.goSettings.setVisible(visibility);
    }

    private void info(boolean visibility, boolean subVisibility)
    {
        Screen.classPrompt.setVisible(visibility);
        Screen.classInfo.setVisible(visibility);
        Screen.fieldList.setVisible(visibility);
        Screen.methodList.setVisible(visibility);
        Screen.constList.setVisible(visibility);
        Screen.exitClassInfo.setVisible(visibility);
        Screen.moreInfo.setVisible(visibility);
        Screen.openNote.setVisible(visibility);
        Screen.goSubInfo.setVisible(visibility);

        Screen.subPrompt.setVisible(subVisibility);
        Screen.subInfo.setVisible(subVisibility);
        Screen.exampleCode.setVisible(subVisibility);
        Screen.copyCode.setVisible(subVisibility);

    }

    private void note(boolean visibility)
    {
        Screen.notes.setVisible(visibility);
        Screen.next.setVisible(visibility);
        Screen.prev.setVisible(visibility);
        Screen.closeNotes.setVisible(visibility);
    }

    private void help(boolean visibility)
    {
        Screen.youtubePrompt.setVisible(visibility);
        Screen.docPrompt.setVisible(visibility);
        Screen.webPrompt.setVisible(visibility);
        Screen.youtubeList.setVisible(visibility);
        Screen.docList.setVisible(visibility);
        Screen.webList.setVisible(visibility);
        Screen.exitHelp.setVisible(visibility);
        Screen.goYoutube.setVisible(visibility);
        Screen.goDoc.setVisible(visibility);
        Screen.goWeb.setVisible(visibility);
    }

    private void settings(boolean visibility)
    {
        Screen.settingsPrompt.setVisible(visibility);
        Screen.changeLanPrompt.setVisible(visibility);
        Screen.lanList.setVisible(visibility);
        Screen.exitSettings.setVisible(visibility);
        Screen.changeLan.setVisible(visibility);
    }

}
