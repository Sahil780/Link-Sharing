package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.FetchUserInfoOnDashboardDao;
import com.ttn.model.service.ServiceInterface.FetchUserInfoOnDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 7/16/2017.
 */
@Service
public class FetchUserInfoOnDashboardServiceImp implements FetchUserInfoOnDashboard {
    @Autowired
    FetchUserInfoOnDashboardDao fetchUserInfoOnDashboardDao;
    public List<?> userInfoService(int id) {
       return fetchUserInfoOnDashboardDao.userInfo(id);
    }
}
