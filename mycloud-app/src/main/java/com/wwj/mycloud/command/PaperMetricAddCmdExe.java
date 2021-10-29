package com.wwj.mycloud.command;

import com.alibaba.cola.dto.Response;
import com.wwj.mycloud.domain.metrics.techinfluence.InfluenceMetric;
import com.wwj.mycloud.domain.metrics.techinfluence.PaperMetric;
import com.wwj.mycloud.domain.metrics.techinfluence.PaperMetricItem;
import com.wwj.mycloud.domain.user.UserProfile;
import com.wwj.mycloud.dto.PaperMetricAddCmd;
import com.wwj.mycloud.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * PaperMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PaperMetricAddCmdExe {

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(PaperMetricAddCmd cmd) {
        PaperMetricItem paperMetricItem = new PaperMetricItem();
        BeanUtils.copyProperties(cmd.getPaperMetricCO(), paperMetricItem);
        paperMetricItem.setSubMetric(new PaperMetric(new InfluenceMetric(new UserProfile(cmd.getPaperMetricCO().getOwnerId()))));
        paperMetricItem.setMetricOwner(new UserProfile(cmd.getPaperMetricCO().getOwnerId()));
        metricGateway.save(paperMetricItem);

        return Response.buildSuccess();
    }
}