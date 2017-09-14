package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Resources;
import com.ttn.model.dao.PostCountOnDashboardDao;
import com.ttn.model.service.ServiceInterface.PostCountOnDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/18/2017.
 */
@Service
public class PostCountServiceImp implements PostCountOnDashboardService {
    @Autowired
    PostCountOnDashboardDao postCountOnDashboardDao;
    public List<Resources> getResources() {
        return postCountOnDashboardDao.getResources();
    }
}
