package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.entity.Department;
import com.mikevane.covid.mapper.DepartMapper;
import com.mikevane.covid.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartServiceImpl extends ServiceImpl<DepartMapper, Department> implements DepartService {
    @Autowired
    private DepartMapper mapper;

    @Override
    public List<String> getAll() {
        List<Department> list;
        List<String> name=new ArrayList<>();
        list=mapper.selectList(null);
        for (Department de:list){
            name.add(de.getName());
        }
        return name;
    }
}
