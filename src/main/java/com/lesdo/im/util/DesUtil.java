package com.lesdo.im.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


//import net.sf.json.JSONObject;

public class DesUtil {

    private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static String encryptDES(String encryptString, String encryptKey)
            throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key,zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
        return Base64.encode(encryptedData);
    }
 
   public static String decryptDES(String decryptString, String decryptKey)throws Exception {
          byte[] byteMi = Base64.decode(decryptString);
          IvParameterSpec zeroIv = new IvParameterSpec(iv);
          SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(),"DES");
          Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
          cipher.init(Cipher.DECRYPT_MODE,key,zeroIv);
          byte decryptedData[] = cipher.doFinal(byteMi);

          return new String(decryptedData);
      }
    
    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; ++i) {
          String hex = Integer.toHexString(buf[i] & 0xFF);
          if (hex.length() == 1)
            hex = '0' + hex;

          sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

	public static byte[] parseHexStr2Byte(String hexStr) {
	    if (hexStr.length() < 1)
	      return null;
	    byte[] result = new byte[hexStr.length() / 2];
	    for (int i = 0; i < hexStr.length() / 2; ++i) {
	      int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
	      int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
	      result[i] = (byte)(high * 16 + low);
	    }
	    return result;
	}
	
	public static void main(String[] args) throws Exception {
		String encryptDES = encryptDES("{abc:\"123\", qwe:\"987--\"}", "12345678");
		encryptDES = "LmqkA0lntEmtPIWES7sHHho571MmRh3iWSwcK7mYY06Gz3t/QAy1L+VBCo7ksnvi7Km09kX27TZPBBw20cUZVcX2gqJ6nsCflXkPrMXNMPE0agBrVWz/H01RFGSxXH2C+U0W2/Zf8HVZ3NIMzlx591rxqZuVYvTQVCJvL2GswM67WHpk4y4aWvjy+WBQTlTn";
		System.out.println(encryptDES);
		String decryptDES = decryptDES(encryptDES, "12345678");
		System.out.println(decryptDES);
	}

	
}
