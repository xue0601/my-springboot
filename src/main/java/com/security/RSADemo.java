package com.security;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-06 16:27
 **/
public class RSADemo {


    public static void main(String args[]) {

    }

//    /**
//     * 公钥密钥
//     * @throws Exception
//     */
//    public static void getKeys() throws Exception {
//        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
//        keyPairGen.initialize(1024);
//        KeyPair keyPair = keyPairGen.generateKeyPair();
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//
//        String publicKeyStr = getPublicKeyStr(publicKey);
//        String privateKeyStr = getPrivateKeyStr(privateKey);
//
//        System.out.println("公钥\r\n" + publicKeyStr);
//        System.out.println("私钥\r\n" + privateKeyStr);
//    }

    /**
     * 获取密钥
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String getPrivateKeyStr(PrivateKey privateKey)
            throws Exception {
        return new String(Base64Utils.encode(privateKey.getEncoded()));
    }

    /**
     * 获取公钥
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String getPublicKeyStr(PublicKey publicKey) throws Exception {
        return new String(Base64Utils.encode(publicKey.getEncoded()));
    }


}