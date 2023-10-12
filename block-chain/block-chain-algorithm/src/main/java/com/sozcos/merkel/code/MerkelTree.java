package com.sozcos.merkel.code;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * 默克尔数
 *
 * @author Elsen 2023/10/11
 */
public class MerkelTree {
    /*
    相关文章:
        https://zhuanlan.zhihu.com/p/39271872
        https://blog.csdn.net/qq_34902437/article/details/120911504

        java 实现 默克尔树:
        https://zhuanlan.zhihu.com/p/273457592
        https://www.ehcoo.com/MerkleTree.html

        merkle 解析:
        https://www.jianshu.com/p/66d7f53aff75

 */
    public static void main(String[] args) {
        List<String> tempTxList = new ArrayList<String>();
        tempTxList.add("a");
        tempTxList.add("b");
        tempTxList.add("c");
        tempTxList.add("d");
        tempTxList.add("e");

        MerkelTree merkleTrees = new MerkelTree(tempTxList);
        merkleTrees.merkleTree();
        System.out.println("root : " + merkleTrees.getRoot());
    }

    /**
     * 交易列表
     */
    List<String> txList;

    /**
     * 默克尔根
     */
    String merkleRoot;

    /**
     * 默克尔树
     *
     * @param txList 交易列表
     */
    public MerkelTree(List<String> txList) {
        this.txList = txList;
        merkleRoot = "";
    }

    /**
     * execute merkle_tree and set root.
     */
    public void merkleTree() {

        List<String> tempTxList = new ArrayList<String>(this.txList);

        List<String> newTxList = getNewTxList(tempTxList);

        while (newTxList.size() != 1) {
            newTxList = getNewTxList(newTxList);
            System.out.println("newTxList 地址: " + System.identityHashCode(newTxList));
        }

        this.merkleRoot = newTxList.get(0);
    }

    /**
     * return Node Hash List.
     *
     * @param tempTxList
     * @return
     */
    private List<String> getNewTxList(List<String> tempTxList) {
        List<String> newTxList = new ArrayList<String>();
        int index = 0;
        while (index < tempTxList.size()) {
            // left 获取第一个节点
            String left = tempTxList.get(index);
            index++;
            // right 获取第二个节点
            String right = "";
            if (index != tempTxList.size()) {
                right = tempTxList.get(index);
            }
            // sha2 hex value 拼接 左右 节点, 计算获得 hash 值
            String sha2HexValue = getSHA2HexValue(left + right);

            // 将计算的hash值添加到新的交易列表中
            newTxList.add(sha2HexValue);
            index++;

        }

        return newTxList;
    }

    /**
     * Return hex string
     *
     * @param str
     * @return
     */
    public String getSHA2HexValue(String str) {
        byte[] cipher_byte;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            cipher_byte = md.digest();
            StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
            for (byte b : cipher_byte) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Get Root
     *
     * @return
     */
    public String getRoot() {
        return this.merkleRoot;
    }
}
