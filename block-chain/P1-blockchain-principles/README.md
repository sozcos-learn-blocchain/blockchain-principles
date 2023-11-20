# 区块链技术原理

### [P1-区块链介绍](./src/main/java/com/sozcos/p1/P1-what_is_blockchain.md)

---

**相关资料:**  
[博客园——区块链技术原理](https://www.cnblogs.com/davidzhu/p/16396812.html)  
[区块链技术指南](https://yeasy.gitbook.io/blockchain_guide/)

```mermaid
---
title: 区块链的工作过程
---

flowchart 
    比特币客户端 --> 发起交易 -->
    消息广播到比特币网络 --> 消息等待确认 -->
    节点将收到的等待确认的交易请求打包在一起 -->
    添加前一个区块头不的哈希值等信息 --> 组成区块结构 -->
    开始计算随机串("挖矿") --> 找到满足条件的随机串 -->
    成为候选区块 --> 节点将其在网络中广播 -->
    其他节点进行验证 --> 承认是新区块 --> 添加到以维护的本地区块链结构 -->
    其他节点确认添加 --> 该交易被确认
```

```mermaid
sequenceDiagram
    actor  比特币客户端
    participant 比特币网络
    participant 节点
    participant 其他节点
    Note over 比特币客户端,比特币网络: 发起交易
    
    
```