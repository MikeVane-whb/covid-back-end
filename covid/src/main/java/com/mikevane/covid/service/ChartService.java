package com.mikevane.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.controller.vo.LineVO;
import com.mikevane.covid.controller.vo.PieVo;
import com.mikevane.covid.entity.EmpIden;

import java.util.List;

public interface ChartService extends IService<EmpIden> {
    public LineVO lineVOList();
    public List<PieVo> pieVOMap();
}
