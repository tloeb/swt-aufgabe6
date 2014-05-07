package de.ostfalia.swt.aufgabe6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;
import org.jdom2.input.SAXBuilder;

/**
 * Created by Tobias on 07.05.2014.
 */
public class XmlIoImpl implements XmlIo{

    @Override
    public void writeProducts(List<Product> products, OutputStream out) throws IOException {
        Element xmlProducts = new Element("products");
        Document doc = new Document(xmlProducts);
        for(Product p : products) {
            Element product = new Element("product");
            product.addContent(new Element("id").setText(p.getId().toString()));
            product.addContent(new Element("description").setText(p.getDescription()));
            product.addContent(new Element("price").setText(p.getPrice().toString()));
            doc.getRootElement().addContent(product);
        }
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.output(doc, out);
    }

    @Override
    public List<Product> readProducts(InputStream in) throws Exception {
        List<Product> productList = new ArrayList<Product>();
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(in);
        Element rootNode = document.getRootElement();
        List xmlList = rootNode.getChildren("products");
        for( Object o : xmlList) {
            Element e = (Element) o ;
            int id = Integer.parseInt(e.getChildText("id"));
            String desc = e.getChildText("description");
            BigDecimal price = new BigDecimal(e.getChildText("price"));
            Product p = new Product(id, desc, price);
            productList.add(p);
        }
        return productList;
    }

    @Override
    public Product getProduct(InputStream in, Integer id) throws Exception {
        return null;
    }

    @Override
    public void increasePrices(InputStream in, OutputStream out, BigDecimal percent) throws Exception {

    }
}
