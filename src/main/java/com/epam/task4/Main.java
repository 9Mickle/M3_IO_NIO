package com.epam.task4;

import com.epam.task4.model.Book;
import com.epam.task4.model.Catalog;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static String PATH_TO_XML = "./data/xmlfile.xml";
    static File file = new File(PATH_TO_XML);

    public static void main(String[] args) throws JAXBException, IOException, TransformerException, ParserConfigurationException, SAXException {

        List<Book> data = xmlToObject(file).getBooks();

        Files.write(Path.of("./data/result.txt"),
                data
                        .stream()
                        .map(Book::toString)
                        .collect(Collectors.toList()));

        xmlToCsv();
    }

    private static void xmlToCsv() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File style = new File("./data/style.xsl");

        StreamSource styleSource = new StreamSource(style);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        editDocument(document, "description");
        editDocument(document, "author");

        Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
        Source source = new DOMSource(document);
        Result result = new StreamResult(new File("./data/result.csv"));
        transformer.transform(source, result);
    }

    private static Catalog xmlToObject(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (Catalog) unmarshaller.unmarshal(file);
    }

    private static void editDocument(Document document, String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            String textContent = item.getTextContent();
            if (!textContent.isEmpty() && textContent.contains("\n") || textContent.contains(",")) {
                String[] split = textContent.split("\n");
                String collect = Arrays.stream(split)
                        .map(String::trim)
                        .collect(Collectors.joining(" "));
                item.setTextContent("\"" + collect + "\"");
            } else {
                item.setTextContent("\"" + textContent + "\"");
            }
        }
    }
}
