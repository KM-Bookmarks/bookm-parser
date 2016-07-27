package bookmark.parser.netscape;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Will parse a Netscape formated bookmark file and export a CSV file
 * TODO: filename as argument
 * TODO: write a file CSV with same name
 * WARNING: does not output the last bookmark!
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new File("Bookmarks-Google_2016-07-25.html"), "UTF-8");
        Element first = doc.select("DL").first();
        Elements dls = first.children();
        (new Parser()).dlElement(dls);
    }

}

