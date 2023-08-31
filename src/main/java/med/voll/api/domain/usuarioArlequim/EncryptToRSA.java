package med.voll.api.domain.usuarioArlequim;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
@Service
public class EncryptToRSA {


    public static Map<String, Object> map = new HashMap<>();

    public PublicKey createKeys() {
        try {
            String publicModulus = "18431572658253052496439022175041666880955375831101946876931070975046366187540402418607712968941953517892713665808806781345360301094904291353800030896585650968318498295670207019285345133290597469406480081515589828659129622929767928746643770078924266324821134004222570531609752167259819294133723112828102846508107541325328346642459168193509225250083201306019029130003077211813841363930723831087321056376493698515221067507202776770182579883007344141023804284785404803150854187258183959393444979725767280589475687946644949886751649263642029363975862625935739092393426710705356663129033911412420717223048873647219191045747";

            BigInteger keyInt = new BigInteger(publicModulus);
            BigInteger exponentInt = new BigInteger("65537");
            RSAPublicKeySpec keySpeck = new RSAPublicKeySpec(keyInt, exponentInt);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpeck);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String encryptMessage(String plainText) {

        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            PublicKey publicKey = createKeys();
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encrypt = cipher.doFinal(plainText.getBytes("UTF-8"));
            return new String(Base64.getEncoder().encodeToString(encrypt));
        } catch (Exception e) {

        }
        return "";

    }

}
