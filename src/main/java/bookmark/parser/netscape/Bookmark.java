package bookmark.parser.netscape;

/**
 * Dead simple.
 */
public class Bookmark {

    public String name;
    public String URL;
    public String description;
    public String date;
    public String tag;


    @Override
    public String toString() {
        String sep = " ; ";
        return "\"" + name + "\"" + sep
                + URL + sep
                + "\"" + description + "\"" + sep
                + "\"" + date + "\"" + sep
                + "\"" + tag + "\"";
    }
}
