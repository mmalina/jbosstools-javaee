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
package org.jboss.tools.struts.ui.preferences;

import org.jboss.tools.common.model.ui.preferences.TabbedPreferencesPage;

public class RsourceInsetsPreferencesPage  extends TabbedPreferencesPage {
	
	public static final String PREFERENCES[] = {
		"%Options%/Struts Studio/Automation/Resources Insets/Default Error Messages" };
		
	public RsourceInsetsPreferencesPage() {
		super(PREFERENCES);
	}
}
