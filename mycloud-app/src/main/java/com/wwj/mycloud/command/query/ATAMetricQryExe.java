package com.wwj.mycloud.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.wwj.mycloud.domain.metrics.SubMetricType;
import com.wwj.mycloud.dto.ATAMetricQry;
import com.wwj.mycloud.dto.clientobject.ATAMetricCO;
import com.wwj.mycloud.gatewayimpl.database.MetricMapper;
import com.wwj.mycloud.gatewayimpl.database.dataobject.MetricDO;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ATAMetricQryExe{

    @Resource
    private MetricMapper metricMapper;

    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        List<MetricDO> metricDOList = metricMapper.listBySubMetric(cmd.getOwnerId(), SubMetricType.ATA.getMetricSubTypeCode());
        List<ATAMetricCO> ataMetricCOList = new ArrayList<>();
        metricDOList.forEach(metricDO -> {
            ATAMetricCO ataMetricCO = JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
            ataMetricCO.setOwnerId(metricDO.getUserId());
            ataMetricCOList.add(ataMetricCO);
        });
        return MultiResponse.ofWithoutTotal(ataMetricCOList);
    }

}
