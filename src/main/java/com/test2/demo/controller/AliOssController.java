package com.test2.demo.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.test2.demo.domain.AliOssConfig;
import com.test2.demo.domain.AliOssPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@RestController
@RequestMapping("/ali/oss")
public class AliOssController {

    /**
     * 创建OSS客户端
     */
    private OSSClient client = new OSSClient(AliOssConfig.endpoint, AliOssConfig.accessId, AliOssConfig.accessKey);

    /**
     * 前端获取直传的policy信息
     * 前端可以使用响应的参数进行直传到oss存储
     *
     * @return
     */
    @GetMapping("/policy")
    public AliOssPolicy getPolicy() {
        // 直传有效截止时间
        long expireEndTime = System.currentTimeMillis() + (AliOssConfig.expireTime * 1000);
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConditions = new PolicyConditions();
        // 设置可上传文件的大小
        policyConditions.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, AliOssConfig.min, AliOssConfig.max);
        // 设置上传文件的前缀、可忽略
        policyConditions.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, AliOssConfig.dir);
        // 生成policy
        String postPolicy = client.generatePostPolicy(expiration, policyConditions);
        byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = client.calculatePostSignature(postPolicy);
        // 封装policy等信息
        AliOssPolicy aliOssPolicy = new AliOssPolicy();
        aliOssPolicy.setOssAccessKeyId(AliOssConfig.accessId);
        aliOssPolicy.setPolicy(encodedPolicy);
        aliOssPolicy.setSignature(postSignature);
        aliOssPolicy.setDir(AliOssConfig.dir);
        aliOssPolicy.setHost(AliOssConfig.host);
        aliOssPolicy.setExpire(String.valueOf(expireEndTime / 1000));
        return aliOssPolicy;
    }


}
