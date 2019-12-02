package study.fop.print.fopprinting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;

/**
 * Hello world!
 *
 */
public class FopPrint 
{
    public static void main( String[] args )
    {
    	 printTable();
     }


	private static void printTable() throws TransformerFactoryConfigurationError {
		try {
             File xmlfile = new File(".\\src\\resources\\organization.xml");
             File xsltfile = new File(".\\src\\resources\\organization.xsl");
             File pdfDir = new File(".\\src\\Test");
             pdfDir.mkdirs();
             File pdfFile = new File(pdfDir, "organization.pdf");
             System.out.println(pdfFile.getAbsolutePath());
             // configure fopFactory as desired
             final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
         
             FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
             // configure foUserAgent as desired
         
             // Setup output
             OutputStream out = new FileOutputStream(pdfFile);
             out = new java.io.BufferedOutputStream(out);
             try {
                       // Construct fop with desired output format
                     Fop fop;
                 
                     fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
                 
                     // Setup XSLT
                     TransformerFactory factory = TransformerFactory.newInstance();
                     Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));
                     
                     // Setup input for XSLT transformation
                     Source src = new StreamSource(xmlfile);
                     
                     // Resulting SAX events (the generated FO) must be piped through to FOP
                     SAXResult res = new SAXResult(fop.getDefaultHandler());
                     
                     // Start XSLT transformation and FOP processing
                     transformer.transform(src, res);
             } catch (Exception e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             } finally {
                 out.close();
             }
         }catch(IOException exp){
             exp.printStackTrace();
         }
	}
    

	private static void helloPdf() throws TransformerFactoryConfigurationError {
		try {
             File xmlfile = new File(".\\src\\resources\\name.xml");
             File xsltfile = new File(".\\src\\resources\\style.xsl");
             File pdfDir = new File(".\\src\\Test");
             pdfDir.mkdirs();
             File pdfFile = new File(pdfDir, "hello.pdf");
             System.out.println(pdfFile.getAbsolutePath());
             // configure fopFactory as desired
             final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
         
             FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
             // configure foUserAgent as desired
         
             // Setup output
             OutputStream out = new FileOutputStream(pdfFile);
             out = new java.io.BufferedOutputStream(out);
             try {
                       // Construct fop with desired output format
                     Fop fop;
                 
                     fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
                 
                     // Setup XSLT
                     TransformerFactory factory = TransformerFactory.newInstance();
                     Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));
                     
                     // Setup input for XSLT transformation
                     Source src = new StreamSource(xmlfile);
                     
                     // Resulting SAX events (the generated FO) must be piped through to FOP
                     SAXResult res = new SAXResult(fop.getDefaultHandler());
                     
                     // Start XSLT transformation and FOP processing
                     transformer.transform(src, res);
             } catch (Exception e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             } finally {
                 out.close();
             }
         }catch(IOException exp){
             exp.printStackTrace();
         }
	}
}
