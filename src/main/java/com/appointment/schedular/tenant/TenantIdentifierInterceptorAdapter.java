package com.appointment.schedular.tenant;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.appointment.schedular.dao.master.TenantDao;
import com.appointment.schedular.model.master.Tenant;

/**
 * @author Dhyanandra
 *
 */
@Component
public class TenantIdentifierInterceptorAdapter extends HandlerInterceptorAdapter {

   @Autowired
   private TenantDao tenantDao;

@SuppressWarnings({ "rawtypes" })
@Override
   public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
      
      
	  Map<String, String> map = new HashMap<String, String>();
	
	  Enumeration headerNames = req.getHeaderNames();
	  while (headerNames.hasMoreElements()) {
		String key = (String) headerNames.nextElement();
		String value = req.getHeader(key);
		map.put(key, value);
	  }
	
      if (map.containsKey("tenantid")) {
         String tenantId = map.get("tenantid").toString();
         Optional<Tenant> thisTenant = (Optional<Tenant>) tenantDao.findByTenantKey(tenantId);
         if (thisTenant.isPresent()) {
            req.setAttribute("Current_Tenant", thisTenant.get().getTenantKey());
            return true;
         } else {
            //res.sendRedirect(req.getContextPath() + "/signUp");
            return false;
         }
      } else {
         return true;
      }

   }
}
