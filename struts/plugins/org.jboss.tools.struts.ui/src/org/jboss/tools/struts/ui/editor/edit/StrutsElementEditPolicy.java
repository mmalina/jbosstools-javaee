/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.struts.ui.editor.edit;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;

public class StrutsElementEditPolicy
	extends org.eclipse.gef.editpolicies.ComponentEditPolicy
{

protected Command createDeleteCommand(GroupRequest request) {
	return null;
	/*DeleteViewCommand deleteCmd = new DeleteViewCommand();
	deleteCmd.setElement((IJSFElement)getHost().getModel());
	return deleteCmd;*/
}

}