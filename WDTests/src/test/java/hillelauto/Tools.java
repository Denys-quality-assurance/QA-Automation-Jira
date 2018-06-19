package hillelauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tools {
    private static WebDriver browser;

    public static void setDriver(WebDriver browser) {
        Tools.browser = browser;
    }

    public static WebElement clearAndFill(By selector, String data) {
        WebElement element = browser.findElement(selector);
        element.clear();
        element.sendKeys(data);

        return element;
    }

    public static String timestamp(boolean forMail) {
    	if (forMail) {
        return new SimpleDateFormat("dd/MM/yy_HH_mm").format(new Date());
    	} else {
    		return new SimpleDateFormat("dd/MM/yy HH:mm").format(new Date());
    	}
    }
    
    public static byte[] getURLDigest(String source, String target) 
    		throws NoSuchAlgorithmException, IOException{
    	URL sourceUrl = new URL(source);
    	Path targetPath = new File(target + File.separator + "DownloadedFileName").toPath();
    	try (InputStream inputStream = sourceUrl.openStream()) {
    	    Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
    	}
    	File file = new File(target + "DownloadedFileName");
    	InputStream fis =  new FileInputStream(file);
    	MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    	messageDigest.reset();
    	byte[] bytes = new byte[1024];
    	int numBytes;
    	while ((numBytes = fis.read(bytes)) != -1) {
    		messageDigest.update(bytes, 0, numBytes);
    	}
    	fis.close();
    	byte[] digest = messageDigest.digest();
    	return digest;
    }
    
    public static byte[] getFileDigest(String targeFile) 
    		throws NoSuchAlgorithmException, IOException{
    	File file = new File(targeFile);
    	InputStream fis =  new FileInputStream(file);
    	MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    	messageDigest.reset();
    	byte[] bytes = new byte[1024];
    	int numBytes;
    	while ((numBytes = fis.read(bytes)) != -1) {
    		messageDigest.update(bytes, 0, numBytes);
    	}
    	fis.close();
    	byte[] digest = messageDigest.digest();
    	return digest;
    	
    	
    }
}