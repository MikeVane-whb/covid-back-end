package com.mikevane.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.entity.EmpIden;
import com.mikevane.covid.vo.LineVO;
import com.mikevane.covid.vo.PieVo;

import java.util.List;

public interface ChartService extends IService<EmpIden> {
    public LineVO lineVOList();
    public List<PieVo> pieVOMap();
}
