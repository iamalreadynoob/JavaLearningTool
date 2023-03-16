package dataTransfer;

import java.io.FileInputStream;
import java.util.ArrayList;

public class DatComm
{
    String info = null;
    String[] infoSet;

    public DatComm(SettingInfo wanted)
    {
        switch (wanted)
        {
            case LANGUAGE: learnLan(getRaw()); break;
            case LAN_LIST: learnLanList(getRaw()); break;
        }
    }

    protected String getInfo() {return info;}
    public String[] getInfoSet() {return infoSet;}

    private String getRaw()
    {
        String raw = null;

        try
        {
            FileInputStream stream = new FileInputStream("outSrc/settings.dat");
            byte[] data = new byte[stream.available()];
            stream.read(data);
            stream.close();

            String temp = new String(data, "UTF-8");
            raw = temp;
        }
        catch (Exception e) {e.printStackTrace();}

        return raw;
    }
    private void learnLan(String raw)
    {
        info = Character.toString(raw.charAt(0));
    }

    private void learnLanList(String raw)
    {
        ArrayList<String> temp = new ArrayList<>();

        int location = 1;
        while (location < raw.length() && raw.charAt(location) != '.')
        {
            String lan = null;

            while (location < raw.length() && raw.charAt(location) != ',' && raw.charAt(location) != '.')
            {
                if (lan == null) lan = Character.toString(raw.charAt(location));
                else lan += Character.toString(raw.charAt(location));

                location++;
            }

            temp.add(lan);

            location++;
        }

        infoSet = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) infoSet[i] = temp.get(i);
    }

}
