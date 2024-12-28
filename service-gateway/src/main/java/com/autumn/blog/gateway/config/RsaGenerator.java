package com.autumn.blog.gateway.config;

/**
 * @author autumn
 * @description 秘钥生成
 * @date 2024年12月26日
 * @version: 1.0
 */
// @Configuration(proxyBeanMethods = false)
public class RsaGenerator {

    // private static KeyPair generateRsaKey() {
    //     KeyPair keyPair;
    //     try {
    //         KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    //         keyPairGenerator.initialize(2048);
    //         keyPair = keyPairGenerator.generateKeyPair();
    //     } catch (Exception ex) {
    //         throw new IllegalStateException(ex);
    //     }
    //     return keyPair;
    // }
    //
    // @Bean
    // public RSAKey rsaKey() {
    //     KeyPair keyPair = generateRsaKey();
    //     RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    //     RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    //     return new RSAKey.Builder(publicKey)
    //             .privateKey(privateKey)
    //             .keyID(UUID.randomUUID().toString())
    //             .build();
    // }

}
