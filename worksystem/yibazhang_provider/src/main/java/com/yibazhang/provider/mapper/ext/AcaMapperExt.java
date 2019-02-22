package com.yibazhang.provider.mapper.ext;

import com.yibazhang.provider.entity.ext.AcaAndProAndClassExt;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/21 10:45
 * @Description TODO
 * @Version 1.0
 **/
public interface AcaMapperExt {

    List<Map<String,Object>> selectAcas(AcaAndProAndClassExt acaAndProAndClassExt);

    List<Map<String,Object>> selectAcaAndPro(AcaAndProAndClassExt acaAndProAndClassExt);

    List<Map<String,Object>> selectAcaAndProAndClass(AcaAndProAndClassExt acaAndProAndClassExt);
}
