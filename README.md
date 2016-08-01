# bookm-parser
Parse Netscape Bookmark file to CSV

## Get the Bookmarks

- Google  https://www.google.com/bookmarks/bookmarks.html?hl=en
- Chrome chrome://bookmarks/ (settings icon in the upper right corner)

(There are differences in the file format (Timestamp, hierarchy ...) and the HTML is just horrible.)

## Build

Use Maven (sorry)
`mvn build`

## Run

`java -jar target/bookm-parser-jar-with-dependencies.jar Bookmarks...html`


