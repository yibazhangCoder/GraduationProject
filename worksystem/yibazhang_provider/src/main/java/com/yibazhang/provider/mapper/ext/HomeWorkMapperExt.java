package com.yibazhang.provider.mapper.ext;

import com.yibazhang.provider.entity.ext.HomeWorkExt;

import java.util.List;
import java.util.Map;

public interface HomeWorkMapperExt {

    int insertHomeworkToStudentBatch(Map<String,Object> map);

    List<Map<String,Object>> selectHomeworkOfTeacher(HomeWorkExt homeWorkExt);

    List<Map<String,Object>> selectHomeworkOfStudent(HomeWorkExt homeWorkExt);

    List<Map<String,Object>> selectDownloadFileOfStudent(Map<String,Object> map);

    List<Map<String,Object>> selectDownloadFileOfTeacher(Map<String,Object> map);

    int updateHomeworkStatuBatchStudent(Map<String,Object> map);
}