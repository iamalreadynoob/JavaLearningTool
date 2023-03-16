package gui;

import dataTransfer.*;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Text
{

    protected Text(boolean isFirst, boolean isReload)
    {
        if (isReload) loadText();
        if (isFirst) loadList();
    }

    private void loadText()
    {
        List<String> text = new CSVComm(CSVInfo.LANGUAGE).getCSVInfoSet();

        //main frame objects
        Screen.prompt.setText(text.get(0));
        Screen.goClassInfo.setText(text.get(2));
        Screen.goNotes.setText(text.get(3));
        Screen.goHelp.setText(text.get(4));
        Screen.goSettings.setText(text.get(1));

        //info frame objects
        Screen.exitClassInfo.setText(text.get(5));
        Screen.moreInfo.setText(text.get(6));
        Screen.copyCode.setText(text.get(7));
        Screen.openNote.setText(text.get(3));
        Screen.goSubInfo.setText(text.get(2));

        //note frame objects
        Screen.next.setText(text.get(8));
        Screen.prev.setText(text.get(9));
        Screen.closeNotes.setText(text.get(5));

        //help frame objects
        Screen.youtubePrompt.setText(text.get(10));
        Screen.docPrompt.setText(text.get(11));
        Screen.webPrompt.setText(text.get(12));
        Screen.exitHelp.setText(text.get(5));
        Screen.goYoutube.setText(text.get(2));
        Screen.goDoc.setText(text.get(2));
        Screen.goWeb.setText(text.get(2));

        //settings frame objects
        Screen.settingsPrompt.setText(text.get(1).toUpperCase());
        Screen.changeLanPrompt.setText(text.get(14));
        Screen.exitSettings.setText(text.get(5));
        Screen.changeLan.setText(text.get(13));
    }

    private void loadList()
    {
        List<String> classes = new CSVComm(CSVInfo.CLASS_LIST).getCSVInfoSet();
        for (String c: classes) Screen.classList.addItem(c);
        Screen.classList.setSelectedItem(null);

        List<String> youtube = new CSVComm(CSVInfo.YOUTUBE).getCSVInfoSet();
        for (String y: youtube) Screen.youtubeList.addItem(y);
        Screen.youtubeList.setSelectedItem(null);

        List<String> doc = new CSVComm(CSVInfo.DOC).getCSVInfoSet();
        for (String d: doc) Screen.docList.addItem(d);
        Screen.docList.setSelectedItem(null);

        List<String> web = new CSVComm(CSVInfo.WEB).getCSVInfoSet();
        for (String w: web) Screen.webList.addItem(w);
        Screen.webList.setSelectedItem(null);

        String[] lan = new DatComm(SettingInfo.LAN_LIST).getInfoSet();
        for (String l: lan) Screen.lanList.addItem(l);
        Screen.lanList.setSelectedItem(null);
    }

    public void loadInfo(String className)
    {
        Integer classID = currentClassID(className);

        //class prompt
        Screen.classPrompt.setText(new CSVComm(CSVInfo.CLASS_INFO_LIST).getCSVInfoSet().get(classID).toUpperCase());

        //class info
        Screen.classInfo.setText(new CSVComm(CSVInfo.CLASS_INFO_GEN).getCSVInfoSet().get(classID));

        String raw = null;

        //field list
        raw = new CSVComm(CSVInfo.FIELD_LIST).getCSVInfoSet().get(classID);
        List<String> fieldList = rawListSeparator(raw, ',');
        Screen.fieldList.addItem("fields");
        for (String f: fieldList) Screen.fieldList.addItem(f);
        Screen.fieldList.setSelectedItem(0);

        //method list
        raw = new CSVComm(CSVInfo.METHOD_LIST).getCSVInfoSet().get(classID);
        List<String> methodList = rawListSeparator(raw, ',');
        Screen.methodList.addItem("methods");
        for (String m: methodList) Screen.methodList.addItem(m);
        Screen.methodList.setSelectedItem(0);

        //constructor list
        raw = new CSVComm(CSVInfo.CONST_LIST).getCSVInfoSet().get(classID);
        List<String> constList = rawListSeparator(raw, 'é');
        Screen.constList.addItem("consts");
        for (String c: constList) Screen.constList.addItem(c);
        Screen.constList.setSelectedItem(0);
    }

    protected void loadInfo(String className, String subName, CSVInfo subType)
    {
        Integer classID = currentClassID(className);

        String rawSubList = new CSVComm(CSVInfo.SUB_PROMPT, subType).getCSVInfoSet().get(classID);
        List<String> subList = null;

        if (subType == CSVInfo.FROM_CONSTS) subList = rawListSeparator(rawSubList, 'é');
        else subList = rawListSeparator(rawSubList, ',');


        Integer subID = currentSubID(subList, subName);

        //sub prompt
        Screen.subPrompt.setText(subName);

        //sub info
        String rawSubInfoList = new CSVComm(CSVInfo.SUB_INFO, subType).getCSVInfoSet().get(classID);
        List<String> subInfoList = rawListSeparator(rawSubInfoList, 'é');
        if (!subInfoList.isEmpty()) Screen.subInfo.setText(subInfoList.get(subID));

        //example code
        String rawSubExList = new CSVComm(CSVInfo.EX_CODE, subType).getCSVInfoSet().get(classID);
        List<String> subExList = rawListSeparator(rawSubExList, 'é');
        if (!subExList.isEmpty()) Screen.exampleCode.setText(subExList.get(subID));
    }

    private List<String> rawListSeparator(String list, char significant)
    {
        List<String> listed = new ArrayList<>();

        for (int i = 0; i < list.length(); i++)
        {
            String item = null;

            while (i < list.length() && list.charAt(i) != significant)
            {
                if (item == null) item = Character.toString(list.charAt(i));
                else item += Character.toString(list.charAt(i));
                i++;
            }

            listed.add(item);
        }

        return listed;
    }

    protected Integer currentClassID(String className)
    {
        List<String> classList = new CSVComm(CSVInfo.CLASS_INFO_LIST).getCSVInfoSet();
        Integer classID = null;
        for (int i = 0; i < classList.size(); i++)
        {
            if (className.equals(classList.get(i)))
            {
                classID = i;
                break;
            }
        }

        return classID;
    }

    private Integer currentSubID(List<String> list, String current)
    {
        Integer subID = null;

        for (int i = 0; i < list.size(); i++)
        {
            if (current.equals(list.get(i)))
            {
                subID = i;
                break;
            }
        }

        return subID;
    }

}
