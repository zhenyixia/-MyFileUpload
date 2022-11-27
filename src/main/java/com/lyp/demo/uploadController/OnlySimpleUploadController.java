package com.lyp.demo.uploadController;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 简单的只有上传功能的控制层，访问地址： http://localhost:8080/myFiles/toIndex
 *
 */

@Controller
@RequestMapping("/myFiles")
public class OnlySimpleUploadController {

  @RequestMapping("/toIndex")
  public String index() {
    return "/simpleUpload";
  }

  @PostMapping("/upload")
  public String upload(@RequestParam("file") MultipartFile file, Model model)
      throws IOException{

    String originalFilename = file.getOriginalFilename();
    String extension = FilenameUtils.getExtension(originalFilename);
    String newFilename = LocalDateTime.now().toString() + extension;

    // 获取资源路径，也即将要上传路径
    String path = ResourceUtils.getURL("classpath:").getPath() + "static/files/";

    File dataFile = new File(path);
    dataFile.mkdirs();

    // 文件上传到指定路径
    file.transferTo(new File(dataFile, originalFilename));

    model.addAttribute("msg","上传成功！");

    return "/simpleUpload";
  }
}