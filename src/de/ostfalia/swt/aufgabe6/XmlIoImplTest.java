package de.ostfalia.swt.aufgabe6;
import static org.junit.Assert.*;

import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tobias on 07.05.2014.
 */
public class XmlIoImplTest {
    @Test
    public void testWriteProducts() {
    	try {
    		File f = new File("products_test.xml");
        	OutputStream out = new FileOutputStream(f);
//    		OutputStream out = System.out;
        	XmlIo tmp = new XmlIoImpl();
        	InputStream inputstream = new FileInputStream("products.xml");
            List<Product> pList = tmp.readProducts(inputstream);
            tmp.writeProducts(pList, out);
		} catch (Exception e) {
			// TODO: handle exception
		}

    	
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
    @Test
    public void testIncreasePrices() {
    	try {
    		File f = new File("products_test_price.xml");
    		OutputStream out = System.out;
        	XmlIo tmp = new XmlIoImpl();
        	InputStream in1 = new FileInputStream("products.xml");
            System.out.println("---------");
            tmp.increasePrices(in1, out, new BigDecimal(2));
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
