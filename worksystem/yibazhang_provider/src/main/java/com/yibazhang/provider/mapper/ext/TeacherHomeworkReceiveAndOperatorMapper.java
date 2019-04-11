package com.yibazhang.provider.mapper.ext;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/4/7 17:46
 * @Description TODO
 * @Version 1.0
 **/
public interface TeacherHomeworkReceiveAndOperatorMapper {

    Integer deleteHomeworkBatch(List<Long> ids);

    Integer deleteHomeworkOfStudentBatch(List<Long> ids);

    Long selectCurrentHomeworkCommitedCount(Long hId);

    Long selectShouldCommitedCount(Long hId);

    List<Map<String,Object>> selectCommitedStudent(Map<String,Object> map);
}
