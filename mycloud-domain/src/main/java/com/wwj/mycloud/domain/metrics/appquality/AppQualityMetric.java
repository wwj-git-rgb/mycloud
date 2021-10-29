package com.wwj.mycloud.domain.metrics.appquality;

import com.wwj.mycloud.domain.metrics.MainMetric;
import com.wwj.mycloud.domain.metrics.MainMetricType;
import com.wwj.mycloud.domain.metrics.devquality.BugMetric;
import com.wwj.mycloud.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
