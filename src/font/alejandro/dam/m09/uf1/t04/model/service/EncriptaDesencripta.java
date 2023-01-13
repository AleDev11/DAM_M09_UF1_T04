package font.alejandro.dam.m09.uf1.t04.model.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncriptaDesencripta {
    private final String ENCRYPT_KEY = "1234567890123456";
    private final String ENCRYPT_ALGORITHM = "AES";

    public String encript(String text) throws Exception {
        Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);

        byte[] encrypted = cipher.doFinal(text.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);

    }

    public String decrypt(String encrypted) throws Exception {

        byte[] encryptedBytes = Base64.getDecoder().decode(encrypted);

        Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, aesKey);

        String decrypted = new String(cipher.doFinal(encryptedBytes));

        return decrypted;
    }
}
