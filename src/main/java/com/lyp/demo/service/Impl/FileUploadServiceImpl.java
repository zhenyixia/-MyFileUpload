package com.lyp.demo.service.Impl;

import com.lyp.demo.mapper.FileUploadMapper;
import com.lyp.demo.pojo.FileUpload;
import com.lyp.demo.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/11/2 20:07
 * @code: 愿世间永无Bug!
 * @description:
 */
@Service
@Transactional
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileUploadMapper fileUploadMapper;
    @Override
    public List<FileUpload> findAll(int id) {
        return fileUploadMapper.findAll(id);
    }

    @Override
    public int saveFile(FileUpload fileUpload) {
        return fileUploadMapper.saveFile(fileUpload);
    }

    @Override
    public int deleteFileById(Integer id) {
        return fileUploadMapper.deleteFileById(id);
    }

    @Override
    public FileUpload findFileById(Integer id) {
        return fileUploadMapper.findFileById(id);
    }


    @Override
    public void updateFileDownCounts(Integer id,int downCounts) {
        fileUploadMapper.updateFileDownCounts(id,downCounts);
    }
}
