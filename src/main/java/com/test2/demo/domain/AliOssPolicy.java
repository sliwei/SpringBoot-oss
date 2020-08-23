package com.test2.demo.domain;

import java.io.Serializable;

public class AliOssPolicy implements Serializable {
    /**
     * 上传认证id
     */
    private String ossAccessKeyId;
    /**
     * policy
     */
    private String policy;
    /**
     * 签名
     */
    private String signature;
    /**
     * 直传文件的开头（路径）
     */
    private String dir;
    /**
     * 直传地址
     */
    private String host;
    /**
     * 上传截止时间
     */
    private String expire;

    // get和set省略

    public String getOssAccessKeyId() {
        return ossAccessKeyId;
    }

    public void setOssAccessKeyId(String ossAccessKeyId) {
        this.ossAccessKeyId = ossAccessKeyId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public AliOssPolicy() {
    }

    public AliOssPolicy(String ossAccessKeyId, String policy, String signature, String dir, String host, String expire) {
        this.ossAccessKeyId = ossAccessKeyId;
        this.policy = policy;
        this.signature = signature;
        this.dir = dir;
        this.host = host;
        this.expire = expire;
    }
}