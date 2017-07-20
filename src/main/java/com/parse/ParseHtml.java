package com.parse; /**
 * Created by user on 2017/2/22.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;


public class ParseHtml {
    public static void main(String[] args) throws IOException {
        String testFilePath = "";
        if (args.length == 1) {
            testFilePath = args[0];
        }else
        {
            return;
        }
        File file = new File(testFilePath);
        Document doc = Jsoup.parse(file, "UTF-8");
        Elements dls =   doc.select("dl");
        if (dls.size() > 0 )
        {
            Elements tbodys =  doc.select("table").select("tbody");
            if (tbodys.size() <= 0)
            {
                return;
            }
            for (Element row : tbodys.get(0).select("tr")) {
                Elements tds = row.select("td");
                System.out.println(String.format("%s %s;",tds.get(2).text().split(" ")[0].trim(),tds.get(0).text().trim()));
            }
        } else
        {
            Elements tbodys =  doc.select("table").select("tbody");
            if (tbodys.size() <= 0)
            {
                return;
            }
            for (Element row : tbodys.get(0).select("tr")) {
                Elements tds = row.select("td");
                System.out.println(String.format("%s %s;",tds.get(1).text().split(" ")[0].trim(),tds.get(0).text().trim()));
            }
        }
    }

/*    *//**
     * 演示向文件中写入字节流
     *
     * @param fileName 要写入文件的文件名
     * @param contents 要写入的文件内容
     *//*
    public static void demoFileWrite(final String fileName, final String contents)
    {
        checkNotNull(fileName, "Provided file name for writing must NOT be null.");
        checkNotNull(contents, "Unable to write null contents.");
        final File newFile = new File(fileName);
        try
        {
            Files.write(contents.getBytes(), newFile);
        }
        catch (IOException fileIoEx)
        {
            System.out.println(  "ERROR trying to write to file '" + fileName + "' - "
                    + fileIoEx.toString());
        }
    }*/
}
