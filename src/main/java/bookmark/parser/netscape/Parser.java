package bookmark.parser.netscape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Horrible, would have been better to use a Stream parser, the Netscape format is barely HTML.
 */
public class Parser {
    final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    int indent = 0;
    Bookmark bookmark = new Bookmark();
    private Element first;


    public Parser(File theDoc) throws IOException {
        Document doc = Jsoup.parse(theDoc, "UTF-8");
        first = doc.select("DL").first();
    }

    public void parse() {
        dlElement(first.children());
    }

    private void dlElement(Elements elems) {
        indent++;
        for (Element elem : elems) {
            switch (elem.nodeName()) {
                case "dt":
                    if (bookmark.URL != null) {
                        System.out.println(bookmark.toString());
                        bookmark.URL = null;
                    }
                    dtElement(elem.children());
                    break;
                case "dd":
                    //System.out.println("# Descr: " + elem.html());
                    bookmark.description = elem.html();
                    break;
                case "dl": dlElement(elem.children()); break;
                case "p":  continue;
                default:   System.err.println("! No comprendo: " + elem.nodeName() + ": " + elem.html());
            }
        }
        indent--;
    }

    private void dtElement(Elements elems) {
        indent++;
        for (Element elem : elems) {
            switch (elem.nodeName()) {
                case "h3":
                    //System.out.println("# Tag: " + elem.ownText());
                    bookmark.tag = elem.ownText();
                    break;
                case "a":
                    //System.out.println("# "+ indent + " Link: " + elem.html());
                    bookmark.name = elem.html();
                    bookmark.URL = elem.attr("href");
                    long dv = Long.parseLong(elem.attr("add_date")) / 1000;   // http://stackoverflow.com/questions/539900/google-bookmark-export-date-format
                    bookmark.date = format.format(new Date(dv));
                    break;
                case "dl": dlElement(elem.children());  break;
                case "p":  continue;
                default:   System.err.println("! No comprendo: " + elem.html());
            }
        }
        indent--;
    }
}
