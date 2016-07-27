package bookmark.parser.netscape;

import java.io.File;
import java.io.IOException;


/**
 * Will parse a Netscape formated bookmark file and export a CSV file
 * TODO: filename as argument
 * TODO: write a file CSV with same name
 * WARNING: does not output the last bookmark!
 */
public class Main {

    public static void main(String[] args) throws IOException {

        // Argument
        String fileName = "Bookmarks-Google_2016-07-25.html";
        if (args.length > 0) {
            fileName = args[0];
        }

        (new Parser(new File(fileName))).parse();
    }

}

