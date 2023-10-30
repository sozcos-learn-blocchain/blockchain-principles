package com.sozcos.p1.code;

/**
 * 字符转换为字节的流程
 *
 * 字符 > unicode 编码 (十六进制) > 二进制
 *
 * @author Elsen 2023/10/30
 */
public class ByteDemo {

    public static void main(String[] args) {
        char character = 'A'; // 要转换的字符
        int unicode = character; // 获取字符的Unicode编码

        // Unicode编码转换为十六进制
        String unicodeHex = String.format("U+%04X", unicode);

        // 十六进制Unicode编码转换为二进制
        String binary = Integer.toBinaryString(unicode);

        System.out.println("字符 '" + character + "' 的Unicode编码为: " + unicode);
        System.out.println("字符 '" + character + "' 的十六进制表示为: " + unicodeHex);
        System.out.println("字符 '" + character + "' 的二进制表示为: " + binary);

    }
}
