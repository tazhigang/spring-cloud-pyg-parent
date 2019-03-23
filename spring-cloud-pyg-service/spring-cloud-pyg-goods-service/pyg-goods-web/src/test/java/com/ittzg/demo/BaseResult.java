package com.ittzg.demo;

import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Author: ittzg
 * @CreateDate: 2019/3/2 21:35
 * @Description:
 */
public class BaseResult implements Serializable{

    private String remsg;
    public String getRemsg() {
        return remsg;
    }

    public void setRemsg(String remsg) {
        this.remsg = remsg;
    }
}
