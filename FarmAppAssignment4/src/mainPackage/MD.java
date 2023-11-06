package mainPackage;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD {
    public static String GenerateMD(String pathName) throws IOException, NoSuchAlgorithmException {
        FileInputStream fis = new FileInputStream(pathName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;
        while ((ch = bis.read()) != -1) baos.write(ch);
        byte buffer[] = baos.toByteArray();
        // Get a MessageDigest for the appropriate algorithm.
        MessageDigest algorithm = MessageDigest.getInstance("MD5");

        // Ensure the digest's buffer is empty.
        algorithm.reset();

        // Fill the digest's buffer with data to compute a message digest from.
        algorithm.update(buffer);

        // Generate the digest. This does any necessary padding required by the algorithm
        byte digest[] = algorithm.digest();

        // Save or print digest bytes.
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
            hexString.append(" ");
        }
        return (hexString.toString());

    }
}