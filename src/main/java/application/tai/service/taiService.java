package application.tai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.domain.DataTableResults;
import application.organization.bean.OrganizationBean;
import application.organization.bean.TreeBean;
import application.organization.dao.OrganizationDAO;
import application.organization.form.OrganizationForm;

@Service
public class taiService {
    @Autowired
    private UttData uttData;
    
    
}
