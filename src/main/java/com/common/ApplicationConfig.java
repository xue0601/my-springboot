package com.common;

import org.csource.fastdfs.*;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

/**
 * @program: my-springboot
 * @description: fastdfs配置中心
 * @author: Xue0601
 * @create: 2018-11-30 11:47
 **/
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter
{

    static final String FASTDFS_CONFIG = "conf/fdfs-client.conf";

    @Bean
    public StorageClient1 initStorageClient()
    {
        StorageClient1 storageClient = null;
        try
        {
            ClientGlobal.init(FASTDFS_CONFIG);
            System.out.println("ClientGlobal.configInfo(): " + ClientGlobal.configInfo());
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
            TrackerServer trackerServer = trackerClient.getConnection();
            if (trackerServer == null)
            {
                throw new IllegalStateException("getConnection return null");
            }
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            if (storageServer == null)
            {
                throw new IllegalStateException("getStoreStorage return null");
            }
            storageClient = new StorageClient1(trackerServer, storageServer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return storageClient;
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("102400KB");
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("1024000KB");
        return factory.createMultipartConfig();
    }
}
