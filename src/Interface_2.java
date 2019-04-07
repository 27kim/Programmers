class Interface_2 {
    public static void main(String[] args) {
        new ParseManager().getParser("XML").parse(".XML");
        Parseable p = new ParseManager().getParser("XML");
        p.parse("hoho.xml" );
    }
}

interface Parseable {
    void parse(String fileName);

}

class ParseManager {
    Parseable p = null;

    Parseable getParser(String type) {
        if (type.equals("XML")) {
            p = new XMLParser();
        } else {
            p = new HTMLParser();
        }
        return p;
    }
}

class XMLParser implements Parseable {
    public void parse(String fileName) {
        System.out.println("XMLParser");
    }
}

class HTMLParser implements Parseable {
    public void parse(String fileName) {
        System.out.println("HTMLParser");
    }
}