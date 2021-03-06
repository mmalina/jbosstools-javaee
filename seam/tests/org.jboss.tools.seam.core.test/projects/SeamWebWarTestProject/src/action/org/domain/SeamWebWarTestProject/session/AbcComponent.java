package org.domain.SeamWebWarTestProject.session;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

@Name("abcComponent")
public class AbcComponent {
	
    @Logger private Log log;
    
    @Out private String actionType;
    
    public void abcComponent()
    {
        //implement your business logic here
        log.info("abcComponent.abcComponent() action called");
    }
	
   //add additional action methods
    public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
}
