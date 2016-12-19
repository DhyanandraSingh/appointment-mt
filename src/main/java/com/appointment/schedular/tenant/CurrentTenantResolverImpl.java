/**
 * 
 */
package com.appointment.schedular.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author Dhyanandra
 *
 */
@Component
public class CurrentTenantResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            String identifier = (String) requestAttributes.getAttribute("Current_Tenant", RequestAttributes.SCOPE_REQUEST);
            
            if (identifier != null) {
                return identifier;
            }
        }
        return "";
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}

