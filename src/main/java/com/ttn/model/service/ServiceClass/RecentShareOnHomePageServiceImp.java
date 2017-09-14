package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Resources;
import com.ttn.model.dao.RecentShareOnHomePageDao;
import com.ttn.model.service.ServiceInterface.RescentShareOnHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/21/2017.
 */
@Service
public class RecentShareOnHomePageServiceImp implements RescentShareOnHomePageService {
    @Autowired
    RecentShareOnHomePageDao recentShareOnHomePageDao;
    public List<Resources> getResources() {
        return recentShareOnHomePageDao.getRsources();
    }
}
