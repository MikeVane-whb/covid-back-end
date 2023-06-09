package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.controller.vo.LineVO;
import com.mikevane.covid.controller.vo.PieVo;
import com.mikevane.covid.entity.EmpIden;
import com.mikevane.covid.entity.EmpIs;
import com.mikevane.covid.entity.MaterialManage;
import com.mikevane.covid.mapper.EmpIdenMapper;
import com.mikevane.covid.mapper.EmpIsMapper;
import com.mikevane.covid.mapper.MaterialMapper;
import com.mikevane.covid.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ChartServiceImpl extends ServiceImpl<EmpIdenMapper, EmpIden> implements ChartService {

    @Autowired
    private EmpIdenMapper empIdenMapper;
    @Autowired
    private EmpIsMapper empIsMapper;
    @Autowired
    private MaterialMapper materialMapper;

        @Override
        public LineVO lineVOList() {
            LineVO lineVO = new LineVO();
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            List<String> month = new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            Map<String, List> all = new HashMap<>();
            String type[] = {"确诊", "疑似", "治愈", "死亡"};

            for (int i = 0; i < 7; i++) {
                cal.setTime(date);
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - i);
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM");
                String mon = ft.format(cal.getTime());
                month.add(mon);
            }
            //设置折线图月份
            Collections.reverse(month);
            lineVO.setMonth(month);

            //  设置 类型-数量 键值对
            for (String t : type) {
                List<Integer> cot=new ArrayList<>();
                int j = 0;
                while (j <7 ) {
                    QueryWrapper<EmpIden> userQueryWrapper = Wrappers.query();
                    userQueryWrapper.like("status", t).likeRight("idate", month.get(j++));
                    Integer count = empIdenMapper.selectCount(userQueryWrapper);
                    cot.add(count);
                    userQueryWrapper.clear();
                }
                all.put(t, cot);
            }
            int j = 0;
            while (j <7 ) {
                QueryWrapper<EmpIs> userQueryWrapper = Wrappers.query();
                userQueryWrapper.likeRight("begin", month.get(j++));
                Integer count = empIsMapper.selectCount(userQueryWrapper);
                list.add(count);
            }
            all.put("隔离", list);
            lineVO.setStatus(all);
            return lineVO;
        }

    @Override
    public List<PieVo> pieVOMap() {
        List<PieVo> pielist=new ArrayList<>();
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("isImp","1");
        List<MaterialManage> list=materialMapper.selectList(queryWrapper);
        for (MaterialManage mat:list){
            PieVo pieVo=new PieVo();
            pieVo.setName(mat.getName());
            pieVo.setValue(mat.getCount());
            pielist.add(pieVo);
        }
        return pielist;
    }


}
