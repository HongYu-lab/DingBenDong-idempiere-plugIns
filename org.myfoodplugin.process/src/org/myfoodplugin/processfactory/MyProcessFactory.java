package org.myfoodplugin.processfactory;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;
import org.myfoodplugin.process.JumpToOrderline;

public class MyProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		
		if(className.equals(JumpToOrderline.class.getName()))
			return new JumpToOrderline();
		return null;
	}

}
