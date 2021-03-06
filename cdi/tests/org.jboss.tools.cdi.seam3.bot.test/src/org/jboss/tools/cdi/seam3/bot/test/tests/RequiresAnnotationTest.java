/*******************************************************************************
 * Copyright (c) 2010-2012 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package org.jboss.tools.cdi.seam3.bot.test.tests;

import org.jboss.tools.cdi.bot.test.CDIConstants;
import org.jboss.tools.cdi.seam3.bot.test.base.SolderAnnotationTestBase;
import org.jboss.tools.cdi.seam3.bot.test.util.SeamLibrary;
import org.junit.After;
import org.junit.Test;

/**
 * 
 * @author jjankovi
 *
 */
public class RequiresAnnotationTest extends SolderAnnotationTestBase {

	@After
	public void waitForJobs() {
		projectExplorer.deleteAllProjects();		
	} 
	
	@Test
	public void testManagedBeans() {
		
		String managerProducer = "ManagerProducer";
		String manager = "Manager";
		String projectName = "requires1";
		
		importSeam3ProjectWithLibrary(projectName, SeamLibrary.SOLDER_3_1);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), APPLICATION_CLASS).toTextEditor());
		
		testNoBeanValidationProblemExists(projectName);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), managerProducer + ".java").toTextEditor());
		editResourceUtil.replaceInEditor("@Requires(\"cdi.test." + manager + "\")",
				"@Requires(\"" + getPackageName() + "." + manager + "\")");
		
		testProperInjectBean(projectName, "managerProducer", managerProducer);
		
	}
	
	@Test
	public void testSessionBean() {
	
		String managerProducer = "ManagerProducer";
		String manager = "Manager";
		String projectName = "requires2";
		
		importSeam3ProjectWithLibrary(projectName, SeamLibrary.SOLDER_3_1);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), APPLICATION_CLASS).toTextEditor());
		
		testNoBeanValidationProblemExists(projectName);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), managerProducer + ".java").toTextEditor());
		editResourceUtil.replaceInEditor("@Requires(\"cdi.test." + manager + "\")",
				"@Requires(\"" + getPackageName() + "." + manager + "\")");
		
		testProperInjectBean(projectName, "managerProducer", managerProducer);
		
	}
	
	@Test
	public void testProducerMethod() {
		
		String managerProducer = "ManagerProducer";
		String manager = "Manager";
		String projectName = "requires3";
		
		importSeam3ProjectWithLibrary(projectName, SeamLibrary.SOLDER_3_1);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), APPLICATION_CLASS).toTextEditor());
		
		testNoBeanValidationProblemExists(projectName);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), managerProducer + ".java").toTextEditor());
		editResourceUtil.replaceInEditor("@Requires(\"cdi.test." + manager + "\")",
				"@Requires(\"" + getPackageName() + "." + manager + "\")");
		
		testProperInjectProducer(projectName, "managerProducer", 
				managerProducer, "getManagerProducer");
		
	}
	
	@Test
	public void testProducerField() {
		
		String managerProducer = "ManagerProducer";
		String manager = "Manager";
		String projectName = "requires4";
		
		importSeam3ProjectWithLibrary(projectName, SeamLibrary.SOLDER_3_1);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), APPLICATION_CLASS).toTextEditor());
		
		testNoBeanValidationProblemExists(projectName);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), managerProducer + ".java").toTextEditor());
		editResourceUtil.replaceInEditor("@Requires(\"cdi.test." + manager + "\")",
				"@Requires(\"" + getPackageName() + "." + manager + "\")");
		
		testProperInjectProducer(projectName, "managerProducer", 
				managerProducer, "managerProducer");
		
	}
	
	@Test
	public void testObserverMethods() {
		
		String managerProducer = "ManagerProducer";
		String manager = "Manager";
		String projectName = "requires5";
		String eventAttribute = "eventAttribute";
		
		importSeam3ProjectWithLibrary(projectName, SeamLibrary.SOLDER_3_1);
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), APPLICATION_CLASS).toTextEditor());
		
		assertFalse(openOnUtil.openOnByOption(eventAttribute, APPLICATION_CLASS, 
				CDIConstants.OPEN_CDI_OBSERVER_METHOD));
		
		setEd(packageExplorer.openFile(projectName, CDIConstants.SRC, 
				getPackageName(), managerProducer + ".java").toTextEditor());
		editResourceUtil.replaceInEditor("@Requires(\"cdi.test." + manager + "\")",
				"@Requires(\"" + getPackageName() + "." + manager + "\")");
		
		assertTrue(openOnUtil.openOnByOption(eventAttribute, APPLICATION_CLASS, 
				CDIConstants.OPEN_CDI_OBSERVER_METHOD));
		assertTrue(getEd().getTitle().equals(managerProducer + ".java"));
		assertTrue(getEd().getSelection().equals("method"));
		
	}
	
}
