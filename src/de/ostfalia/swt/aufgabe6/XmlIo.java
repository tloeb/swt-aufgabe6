package de.ostfalia.swt.aufgabe6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

public interface XmlIo {

	void writeProducts(List<Product> products, OutputStream out) throws IOException;
	List<Product> readProducts(InputStream in) throws Exception;
	
	/**
	 * Liefert Produkt mit Id <id>.
	 * 
	 * @param in
	 * @param id
	 * @return Product mit Id <id>, null falls nicht vorhanden
	 * @throws Exception
	 */
	Product getProduct(InputStream in, Integer id) throws Exception;
	
	
	/**
	 * Erhoeht für alle Produkte den Preis um <percent> Prozent.
	 * Es wird kaufmännisch gerundet.
	 * 
	 * @param in
	 * @param out
	 * @param percent Wert zwischen 0 und 100. Muss nicht überprüft werden.
	 * @throws Exception
	 */
	void increasePrices(InputStream in, OutputStream out, BigDecimal percent) throws Exception;
}
