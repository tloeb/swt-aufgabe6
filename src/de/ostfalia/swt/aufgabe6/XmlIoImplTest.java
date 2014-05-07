package de.ostfalia.swt.aufgabe6;
import static org.junit.Assert.*;

import org.junit.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Tobias on 07.05.2014.
 */
public class XmlIoImplTest {
//    @Test
    void testWriteProducts() {

    }
    @Test
    public void testReadProducts() {
        System.out.println("Read Products");
        try {
            InputStream inputstream = new FileInputStream("products.xml");
            XmlIo tmp = new XmlIoImpl();
            List<Product> pList = tmp.readProducts(inputstream);
            System.out.println(pList.size());
            for(Product p : pList) {
                System.out.println("-------------------");
                System.out.println(p.getId());
                System.out.println(p.getDescription());
                System.out.println(p.getPrice());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void testGetProduct() {
    	try {
            InputStream inputstream = new FileInputStream("products.xml");
            XmlIo tmp = new XmlIoImpl();
            Product p = tmp.getProduct(inputstream, 1);
            assertNotNull(p);
            System.out.println(p.getId());
            System.out.println(p.getDescription());
            System.out.println(p.getPrice());
            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }
//    @Test
    void testIncreasePrices() {

    }
}
