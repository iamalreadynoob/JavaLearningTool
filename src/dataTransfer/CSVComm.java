package dataTransfer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CSVComm
{

    private List<String> csvInfoSet = new ArrayList<>();

    public CSVComm(CSVInfo type)
    {
        switch (type)
        {
            case LANGUAGE: language(); break;
            case CLASS_LIST: classList(); break;
            case YOUTUBE: useful("youtube-suggestions.csv"); break;
            case DOC: useful("doc-suggestions.csv"); break;
            case WEB: useful("web-suggestions.csv"); break;
            case CLASS_INFO_LIST: info("name"); break;
            case CLASS_INFO_GEN: info("general-info"); break;
            case FIELD_LIST: info("fields"); break;
            case METHOD_LIST: info("methods"); break;
            case CONST_LIST: info("constructors"); break;
            case LINK: info("link"); break;
        }
    }

    public CSVComm(CSVInfo type, CSVInfo subType)
    {
        switch (type)
        {
            case SUB_PROMPT:
                switch (subType)
                {
                    case FROM_FIELDS: info("fields"); break;
                    case FROM_METHODS: info("methods"); break;
                    case FROM_CONSTS: info("constructors"); break;
                }
                break;
            case SUB_INFO:
                switch (subType)
                {
                    case FROM_FIELDS: info("fields-info"); break;
                    case FROM_METHODS: info("methods-info"); break;
                    case FROM_CONSTS: info("constructors-info"); break;
                }
                break;
            case EX_CODE:
                switch (subType)
                {
                    case FROM_FIELDS: info("fields-ex"); break;
                    case FROM_METHODS: info("methods-ex"); break;
                    case FROM_CONSTS: info("constructors-ex"); break;
                }
                break;
        }
    }

    public List<String> getCSVInfoSet() {return csvInfoSet;}

    private List<String> dataGetter(String dir, String file, String[] headers, String reqHeader)
    {
        List<String> data = new ArrayList<>();

        Path path = Paths.get(dir);
        Path filePath = path.resolve(file);

        try
        {
            CSVParser parser = CSVParser.parse(filePath, Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader(headers));
            Stream<CSVRecord> stream = StreamSupport.stream(parser.spliterator(), false);
            List<Map<String, String>> temp = stream.skip(1).map(record -> record.toMap()).collect(Collectors.toList());

            data = temp.stream().map(column -> column.get(reqHeader)).collect(Collectors.toList());
        }
        catch (Exception e) {e.printStackTrace();}

        return data;
    }

    private void language()
    {
        Integer lanCode = Integer.parseInt(new DatComm(SettingInfo.LANGUAGE).getInfo());
        String[] headers = new DatComm(SettingInfo.LAN_LIST).getInfoSet();

        csvInfoSet = dataGetter("outSrc", "constant-text.csv", headers, headers[lanCode]);
    }

    private void classList()
    {
        String[] header = {"names"};
        csvInfoSet = dataGetter("outSrc", "class-names.csv", header, "names");
    }

    private void useful(String file)
    {
        String[] headers = {"name", "link"};
        csvInfoSet = dataGetter("outSrc/suggestions", file, headers, "name");
    }

    private void info(String header)
    {
        String[] headers = {"name","general-info","fields","methods","constructors","fields-info","methods-info","constructors-info","fields-ex","methods-ex","constructors-ex","link"};

        int lanID = Integer.parseInt(new DatComm(SettingInfo.LANGUAGE).getInfo());
        String language = new DatComm(SettingInfo.LAN_LIST).getInfoSet()[lanID];
        csvInfoSet = dataGetter("outSrc", "class-info-"+language+".csv", headers, header);
    }


}
