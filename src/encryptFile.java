import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

import javax.activation.MimetypesFileTypeMap;


public class encryptFile {
	/*
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		
			//Security.addProvider(new BouncyCastleProvider());

			String data = "hello world";

			MessageDigest mda;
				mda = MessageDigest.getInstance("SHA-512", "BC");
			byte [] digesta = mda.digest(data.getBytes());

			MessageDigest mdb;
				mdb = MessageDigest.getInstance("SHA-512", "BC");
				// TODO Auto-generated catch block
		
			byte [] digestb = mdb.digest(data.getBytes());

			System.out.println(MessageDigest.isEqual(digesta, digestb));

			//System.out.println(Hex.encodeHex(digesta));
	
		
		new encryptFile().encrypt("Zarriorm16", "/home/ephraim/Desktop/testfile", "/home/ephraim/Desktop/testfile2");
		System.out.println("\n");
		new encryptFile().decrypt("Zarriorm16", "/home/ephraim/Desktop/testfile2", "/home/ephraim/Desktop/testfile3");
	}*/
	
	public ArrayList<Integer> getHash(String filePath) {
		ArrayList<Integer> fileBytes = new ArrayList<Integer>();
		try {
			FileInputStream myInputStream = new FileInputStream(new File(filePath));
			do {
				int currentByte = myInputStream.read();
				if(currentByte == -1) {
					System.out.println("broke loop");
					break;
				}
				fileBytes.add(currentByte);
			} while (true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileBytes);
		return fileBytes;
	}
	
	public void writeHash(ArrayList<Integer> hash, String pathName) throws Exception {
		
			OutputStream myOutputStream = new FileOutputStream(new File(pathName));
			for (int currentHash : hash) {
				myOutputStream.write(currentHash);
			}

		//System.out.println(hash);
	}
	
	public void encrypt(String password, String pathInName, String pathOutName) throws Exception {
		encryptMethod method  = new encryptMethod();
		ArrayList<Integer> encryptedHash = method.encrypt(password, getHash(pathInName));
		writeHash(encryptedHash, pathOutName);
		//new MimetypesFileTypeMap().getContentType(new File(pathInName));
		//  "/home/ephraim/Desktop/testfile"
		
	/*	double printIndex = 0;
		for (int currentByte : fileBytes) {
			if (printIndex == 3.0) {
				System.out.println();
				printIndex = 0;
			} else printIndex++;
			System.out.print(currentByte);
			
		}*/
	}
	
	
	public void decrypt(String password, String pathInName, String pathOutName) throws Exception {

		encryptMethod method  = new encryptMethod();
		ArrayList<Integer> decryptedHash = method.decrypt(password, getHash(pathInName));
		writeHash(decryptedHash, pathOutName);
		//  "/home/ephraim/Desktop/testfile"
	}

}
