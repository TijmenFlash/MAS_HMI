package theresistance.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		/**
		 * Place custom panels and globals below, for example:
		 * 
	        addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
	        // Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
	        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
	        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
	        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
	        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
	        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
	        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
	        addChooser("chooserVariable2", [1, 66, "seven"], 0)
	        // State change button (method name in observer)
	        addStateChangeButton("change")
	        // State change button with label (method name in observer, label)
	        addStateChangeButtonWL("changeSomething","Change Something")
	        
		 */
		// monitoring
		addMonitorWL("getWinner", "The winner!", 1)
		addGlobal("DI_f_2")
		addGlobal("DI_f_3")
		addGlobal("DI_s_2")
		addGlobal("DI_s_3")
		addGlobal("DO_f_2")
		addGlobal("DO_f_3")
		addGlobal("DO_s_2")
		addGlobal("DO_s_3")
		addGlobal("DO_doublefail")
		addGlobal("DI_doublefail")
		
		// Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
//		addSliderWL("DI_doublefail", "Direct Interaction Failed 2", -1, 0.1, 0, -0.99)
//		addSliderWL("DO_doublefail", "Direct Interaction Failed 2", -1, 0.1, 0, -0.6)
//		addSliderWL("DI_f_2", "Direct Interaction Failed 2", -1, 0.1, 0, -0.99)
//		addSliderWL("DI_f_3", "Direct Interaction Failed 3", -1, 0.1, 0, -0.1)
//		addSliderWL("DI_s_2", "Direct Interaction Succeed 2", 0, 0.1, 1, 0.4)
//		addSliderWL("DI_s_3", "Direct Interaction Succeed 3", 0, 0.1, 1, 0.1)
//		addSliderWL("DO_f_2", "Direct Observation Failed 2", -1, 0.1, 0, -0.2)
//		addSliderWL("DO_f_3", "Direct Observation Failed 3", -1, 0.1, 0, -0.1)
//		addSliderWL("DO_s_2", "Direct Observation Succeed 2", 0, 0.1, 1, 0.2)
//		addSliderWL("DO_s_3", "Direct Observation Succeed 3", 0, 0.1, 1, 0.1)
	}
}