package com.test2.demo.domain;

public class AliOssConfig {
    /**
     * 填写您的AccessKeyId
     */
    public final static String accessId = "LTAIAEWt96MQ6EbR";
    /**
     * 填写您的AccessKeySecret
     */
    public final static String accessKey = "JxpOyA8axOJgyYyMf0GUKgLsbwNQrG";
    /**
     * 填写您的 endpoint（地域节点）,就是你OSS的区域节点的域名
     */
    public final static String endpoint = "oss-cn-shenzhen.aliyuncs.com";
    /**
     * 填写您的 bucketName ，就是你再OSS创建Bucket的名称
     */
    public final static String bucket = "bstu";
    /**
     * 直传地址，格式为 bucketName.endpoint (Bucket域名)
     */
    public final static String host = "https://" + bucket +"."+ endpoint;

    /*
     * ============= 配置上传过期时间、大小等等 =========
     */
    /**
     * 上传截止时间（秒）
     */
    public final static long expireTime = 30;

    /**
     * 上传文件最小（字节）
     */
    public final static long min = 0;
    /**
     * 上传文件最大（字节）
     */
    public final static long max = 1048576000;

    /**
     * 上传文件的前缀、可忽略
     */
    public final static String dir = "oss/";
}
