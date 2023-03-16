package gui;

import dataTransfer.CSVInfo;

public class SubOperating
{
    private boolean isField, isMethod, isConst;

    protected SubOperating()
    {
        isField = false;
        isMethod = false;
        isConst = false;
    }
    private boolean isValidSelection()
    {
        int selected = 0;

        if (Screen.fieldList.getSelectedIndex() != 0)
        {
            isField = true;
            selected++;
        }
        if (Screen.methodList.getSelectedIndex() != 0)
        {
            isMethod = true;
            selected++;
        }
        if (selected < 1 && Screen.constList.getSelectedIndex() != 0)
        {
            isConst = true;
            selected++;
        }

        if (selected == 1) return true;
        else return false;
    }

    protected void show()
    {
        if (isValidSelection())
        {
            new Visibility().setVisible(FrameNames.INFO, true, true);

            String subText = null;
            CSVInfo info = null;

            if (isField)
            {
                subText = Screen.fieldList.getSelectedItem().toString();
                info = CSVInfo.FROM_FIELDS;
            }
            else if (isMethod)
            {
                subText = Screen.methodList.getSelectedItem().toString();
                info = CSVInfo.FROM_METHODS;
            }
            else if (isConst)
            {
                subText = Screen.constList.getSelectedItem().toString();
                info = CSVInfo.FROM_CONSTS;
            }

            new Text(false, false).loadInfo(Screen.classPrompt.getText().toLowerCase(), subText, info);

        }
    }

}
