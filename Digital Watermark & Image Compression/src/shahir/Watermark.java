package shahir;




import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Watermark {

    
  private static final int MAX_INT_LEN = 4;//maximum number of bytes that an interger value will hold
  private static final int DATA_SIZE = 8;   // 8 bits = 1 byte
           // number of image bytes required to store one watermark byte

 static byte[] imBytes;
 static int msgLen;
 static String fnm;
 static  String msg;

  public static boolean invisible_Watermark(String text_file_name, String image_file_name)
  {
    // read in the message
    String inputText = read_the_Text_File(text_file_name);
    if ((inputText == null) || (inputText.length() == 0))
      return false;

    byte[] stego = buildStego(inputText);

    // access the image's data as a byte array
    BufferedImage im = loadImage(image_file_name);
    if (im == null)
      return false;
    byte imBytes[] = accessBytes(im);

    if (!singleHide(imBytes, stego))   // im is modified with the stego
      return false;

    // store the modified image in <fnm>Msg.png
    String fnm = getFileName(image_file_name);
    return writeImageToFile( fnm + "Msg.png", im);
  }  // end of hide()



  public static String read_the_Text_File(String fnm)
  // read in fnm, returning it as a single string
  {
    BufferedReader br = null;
    StringBuffer sb = new StringBuffer();

    try {
      br = new BufferedReader(new FileReader( new File(fnm) )); 
      String text = null;
      while ((text = br.readLine()) != null)
        sb.append(text + "\n");
    } 
    catch (Exception e) {
        e.printStackTrace();
      System.out.println("Could not completely read " + fnm);
      return null;
    } 
    finally {
      try {
        if (br != null)
          br.close();
       } 
       catch (IOException e) {
         System.out.println("Problem closing " + fnm);
         return null;
       } 
    }
    System.out.println("Read in " + fnm);
    return sb.toString();
  }  // end of readTextFile()



  private static byte[] buildStego(String inputText)
  /* Build a stego (a byte array), made up of 2 fields:
       <size of binary message> 
       <binary message>   */
  { 
    // convert data to byte arrays
    byte[] msgBytes = inputText.getBytes();   
    byte[] lenBs = intToBytes(msgBytes.length);

    int totalLen = lenBs.length + msgBytes.length;
    byte[] stego = new byte[totalLen];    // for holding the resulting stego

    // combine the 2 fields into one byte array
    // public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
    System.arraycopy(lenBs, 0, stego, 0, lenBs.length);          // length of binary message
    System.arraycopy(msgBytes, 0, stego, lenBs.length, msgBytes.length);   // binary message

    // System.out.println("Num. pixels to store fragment " + i + ": " + totalLen*DATA_SIZE);
    return stego;
  }  // end of buildStego()



  private static byte[] intToBytes(int i)
  // split integer i into a MAX_INT_LEN-element byte array
  {
    // map the parts of the integer to a byte array
    byte[] integerBs = new byte[MAX_INT_LEN];
    integerBs[0] = (byte) ((i >>> 24) & 0xFF);
    integerBs[1] = (byte) ((i >>> 16) & 0xFF);
    integerBs[2] = (byte) ((i >>> 8) & 0xFF);
    integerBs[3] = (byte) (i & 0xFF);

    // for (int j=0; j < integerBs.length; j++)
    //  System.out.println(" integerBs[ " + j + "]: " + integerBs[j]);

    return integerBs;
  }  // end of intToBytes()



  public static BufferedImage loadImage(String imFnm)
  // read the image from the imFnm file
  {
    BufferedImage im = null;
    try {
      im = ImageIO.read( new File(imFnm) );
      System.out.println("Read " + imFnm);
    } 
    catch (IOException e) 
    { System.out.println("Could not read image from " + imFnm);  }

    return im;
  }   // end of loadImage()



  private static byte[] accessBytes(BufferedImage image)
  // access the data bytes in the image
  {
    WritableRaster raster = image.getRaster();
    DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
    return buffer.getData();
  }  // end of accessBytes()



  private static boolean singleHide(byte[] imBytes, byte[] stego)
  // store stego in image bytes
  {
    int imLen = imBytes.length;
    System.out.println("Byte length of image: " + imLen);

    int totalLen = stego.length;
    System.out.println("Total byte length of message: " + totalLen);

    // check that the stego will fit into the image
    // multiply stego length by number of image bytes required to store one stego byte
    if ((totalLen*DATA_SIZE) > imLen) {
      System.out.println("Image not big enough for message");
      return false;
    }

    hideStego(imBytes, stego, 0);  // hide at start of image
    return true;
  }  // end of singleHide()
    


  private static void hideStego(byte[] imBytes, byte[] stego, int offset)
  // store stego in image starting at byte posn offset
  {
    for (int i = 0; i < stego.length; i++) {       // loop through stego
      int byteVal = stego[i];
      for(int j=7; j >= 0; j--) {    // loop through the 8 bits of each stego byte
        int bitVal = (byteVal >>> j) & 1;

        // change last bit of image byte to be the stego bit
        imBytes[offset] = (byte)((imBytes[offset] & 0xFE) | bitVal);
        offset++;
      }
    }
  }  // end of hideStego()




  public static String getFileName(String fnm)
  // extract the name from the filename without its suffix
  {
    int extPosn = fnm.lastIndexOf('.');
    if (extPosn == -1) {
      System.out.println("No extension found for " + fnm);
      return fnm;   // use the original file name
    }

    return fnm.substring(0, extPosn);
  }  // end of getFileName()




  public static boolean writeImageToFile(String outFnm, BufferedImage im)
  // save the im image in a PNG file called outFnm
  {
//    if (!canOverWrite(outFnm))
//      return false;

    try {
      ImageIO.write(im, "png", new File(outFnm));
      System.out.println("Image written to PNG file: " + outFnm);
      return true;
    } 
    catch(IOException e)
    { System.out.println("Could not write image to " + outFnm); 
      return false;
    }
  } // end of writeImageToFile();







  // --------------------------- reveal a message -----------------------------------


  public static String reveal(String imFnm)
  /* Retrieve the hidden message from imFnm from the beginning
     of the image after first extractibg its length information.  
     The extracted message is stored in <imFnm>.txt
  */
  {
    // get the image's data as a byte array
    BufferedImage im = loadImage(imFnm);
    if (im == null)
      return "Image in inappropiate!!";
    imBytes = accessBytes(im);
    System.out.println("Byte length of image: " + imBytes.length);

    // get msg length at the start of the image
    msgLen= getMsgLength(imBytes, 0);   
    if (msgLen == -1)
      return "No Message Found";
    System.out.println("Byte length of message: " + msgLen);

    // get message located after the length info in the image
   msg = getMessage(imBytes, msgLen, MAX_INT_LEN*DATA_SIZE);          
    if (msg != null) {
     fnm = getFileName(imFnm);
//      writeStringToFile(fnm + ".txt", msg);  // save message in a text file\
     return msg;
      
    }
    else {
      System.out.println("No message found");
      return "No Message Found";
    }
       
    
  }  // end of reveal()
    
  public String save() {
      return writeStringToFile(fnm + ".txt");
  }


  private static int getMsgLength(byte[] imBytes, int offset)
  // retrieve binary message length from the image
  {
    byte[] lenBytes = extractHiddenBytes(imBytes, MAX_INT_LEN, offset);
              // get the binary message length as a byte array
    if (lenBytes == null)
      return -1;

    // for (int j=0; j < lenBytes.length; j++)
    //  System.out.println(" lenBytes[ " + j + "]: " + lenBytes[j]);

    // convert the byte array into an integer
    int msgLen = ((lenBytes[0] & 0xff) << 24) | 
                 ((lenBytes[1] & 0xff) << 16) | 
                 ((lenBytes[2] & 0xff) << 8) | 
                  (lenBytes[3] & 0xff);
    // System.out.println("Message length: " + msgLen);

    if ((msgLen <= 0) || (msgLen > imBytes.length))  {
      System.out.println("Incorrect message length");
      return -1;
    }
    // else
    //  System.out.println("Revealed message length: " + msgLen);

    return msgLen;
  }  // end of getMsgLength()



  private static String getMessage(byte[] imBytes, int msgLen, int offset)
  /* Extract a binary message of size msgLen from the image, and 
     convert it to a string 
  */
  {
    byte[] msgBytes = extractHiddenBytes(imBytes, msgLen, offset); 
           // the message is msgLen bytes long
    if (msgBytes == null)
      return null;

    String msg = new String(msgBytes);

    // check the message is all characters
    if (isPrintable(msg)) {
    // System.out.println("Found message: "" + msg + """);
      return msg;
    }
    else
      return null;
  }  // end of getMessage()



  private static byte[] extractHiddenBytes(byte[] imBytes, int size, int offset)
  // extract 'size' hidden data bytes, starting from 'offset' in the image bytes
  {
    int finalPosn = offset + (size*DATA_SIZE);
    if (finalPosn > imBytes.length) {
      System.out.println("End of image reached");
      return null;
    }

    byte[] hiddenBytes = new byte[size];

    for (int j = 0; j < size; j++) {    // loop through each hidden byte
      for (int i=0; i < DATA_SIZE; i++) {   // make one hidden byte from DATA_SIZE image bytes
        hiddenBytes[j] = (byte) ((hiddenBytes[j] << 1) | (imBytes[offset] & 1));   
                             // shift existing 1 left; store right most bit of image byte
        offset++;
      }
    }
    return hiddenBytes;
  }  // end of extractHiddenBytes()



  private static boolean isPrintable(String str)
  // is the string printable?
  {
    for (int i=0; i < str.length(); i++)
      if (!isPrintable(str.charAt(i))) {
        System.out.println("Unprintable character found");
        return false;
      }
    return true;
  }  // end of isPrintable()



  private static boolean isPrintable(int ch)
  // is ch a 7-bit ASCII character that could (sensibly) be printed?
  {
    if (Character.isWhitespace(ch) && (ch < 127))  // whitespace, 7-bit
      return true;
    else if ((ch > 32) && (ch < 127))
      return true;

    return false;
  }  // end of isPrintable()



  private static String writeStringToFile(String outFnm)
  // write the message string into the outFnm text file
  {
//    if (!canOverWrite(outFnm))
//      return false;

    try {
        try (FileWriter out = new FileWriter( new File(outFnm) )) {
            out.write(msg);
        }
//      System.out.println("Message written to " + outFnm);
        return outFnm;
      
    }
    catch(IOException e)
    {  System.out.println("Could not write message to " + outFnm);  
       
    }
        return "Something gone Wrong!!";
  }  // end of writeStringToFile()


}  // end of Steganography class



