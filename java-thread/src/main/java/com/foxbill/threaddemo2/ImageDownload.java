package com.foxbill.threaddemo2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageDownload implements Runnable {

    private String url; //网络图片地址
    private String name;//保存的文件名

    public ImageDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url,name);
        System.out.println("下载了文件：" + name);
    }

    public static void main(String[] args) {
        ImageDownload t1 = new ImageDownload("https://www.runoob.com/wp-content/uploads/2013/06/image-icon.png", "icon.png");
        ImageDownload t2 = new ImageDownload("https://www.runoob.com/wp-content/uploads/2013/06/02A7DD95-22B4-4FB9-B994-DDB5393F7F03.jpg", "html1.jpg");
        ImageDownload t3 = new ImageDownload("https://www.runoob.com/wp-content/uploads/2013/06/EAD13C0B-0BE9-411E-8E2A-23600B0BEF9B.jpg", "html2.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

//下载器
class WebDownloader{
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
