package dataTransfer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class TXTComm
{

    private ArrayList<String> pages;
    private String reqPlace;
    private Integer location = null;

    public TXTComm(TXTOrders order, String reqPlace)
    {
        pages = new ArrayList<>();
        this.reqPlace = reqPlace;

        switch (order)
        {
            case READ: read(); break;
            case WRITE: write(); break;
        }
    }

    public ArrayList<String> getPages() {return pages;}

    private void read()
    {
        if (isExist())
        {

        }
    }

    private void write()
    {

    }

    private boolean isExist()
    {
        boolean isExist = false;

        String wholeNotes = getNotes();
        String compare = null;
        for (int i = 0; i < wholeNotes.length(); i++)
        {
            if (i+33 < wholeNotes.length() && wholeNotes.charAt(i) == '{' && wholeNotes.charAt(i+33) == '}')
            {
                for (int j = i; j < i+34; j++)
                {
                    if (compare == null) compare = Character.toString(wholeNotes.charAt(j));
                    else compare += Character.toString(wholeNotes.charAt(j));
                }

                if (encapsulate().equals(compare))
                {
                    isExist = true;
                    location = i;
                    break;
                }
            }
        }

        return isExist;
    }

    private String encapsulate()
    {
        String requested = null;

        if (reqPlace.length() <= 32)
        {
            requested = "{" + reqPlace;
            for (int i = 0; i < 32 - reqPlace.length(); i++) requested += "0";
        }
        else if (reqPlace.length() > 32)
        {
            requested = "{";
            for (int i = 0; i < 32; i++) requested += Character.toString(reqPlace.charAt(i));
        }

        requested += "}";

        return requested;
    }

    private String getNotes()
    {
        String notes = null;
        try
        {
            File notesFile = new File("outSrc/notes.txt");
            FileReader reader = new FileReader(notesFile);
            BufferedReader buffer = new BufferedReader(reader);

            String line = null;
            while ((line = buffer.readLine()) != null) notes += line;

            buffer.close();
            reader.close();
        }
        catch (Exception e){e.printStackTrace();}


        return notes;
    }

    private String getReqRawNotes()
    {
        String reqRaw = null;
        String wholeNotes = getNotes();
        if (location+34 < wholeNotes.length())
        {
            //get raw notes here
        }


        return reqRaw;
    }

}
