package com.appointment.schedular.tenant;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;
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

   @SuppressWarnings("unchecked")
   @Override
   public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
      
      Map<String, Object> pathVars
              = (Map<String, Object>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
      if (pathVars.containsKey("tenantId")) {
         String tenantId = pathVars.get("tenantId").toString();
         Optional<Tenant> thisTenant = tenantDao.findByTenantKey(tenantId);
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
