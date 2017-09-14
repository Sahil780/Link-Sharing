package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Resources;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/18/2017.
 */
@Service
public interface PostCountOnDashboardService {
    List<Resources> getResources();
}
