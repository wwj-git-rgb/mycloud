package com.wwj.mycloud.domain.metrics.devquality;

import com.wwj.mycloud.domain.metrics.MainMetric;
import com.wwj.mycloud.domain.metrics.MainMetricType;
import com.wwj.mycloud.domain.user.UserProfile;
import lombok.Data;

@Data
public class DevQualityMetric extends MainMetric {

    private BugMetric bugMetric;

    public DevQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setDevQualityMetric(this);
        this.metricMainType = MainMetricType.DEV_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getDevQualityWeight();
    }
}
