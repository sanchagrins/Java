/* File:	ParseXML.java
 * Name:	sanchagrin
 * Date:	11/19/2016
 * Purpose:	Reads through an XML file and randomly pulls
 *          a dinosaurs name. 
 */

// Imports
import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseXML {
	public static void main(String[] args) {
		try {
			// Generates random number
			Random r = new Random();
			int i = r.nextInt(1512);
			System.out.println(i);

            // Load XML document for parsing
			File inputFile = new File("dinoXML.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			// Creat XPath expression and searchs XML
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/dinosaurs/dinosaur[@ID='" + i + "']";
			Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
			String dino = xPath.compile(expression).evaluate(doc);
			System.out.println("Root Element: " +
				doc.getDocumentElement().getNodeName());

			// Strips whitespace
			String ws = dino.trim();
			System.out.println("Dino 1: " + ws);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
