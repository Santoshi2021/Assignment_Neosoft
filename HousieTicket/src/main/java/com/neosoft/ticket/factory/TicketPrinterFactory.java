package com.neosoft.ticket.factory;

import com.neosoft.ticket.exception.InvalidPrinterType;
import com.neosoft.ticket.printer.HousieTicketConsolePrinterImpl;
import com.neosoft.ticket.printer.IHousieTicketConsolePrinter;

/**
 * A factory for creating TicketPrinter objects.
 * 
 * @author Santoshi Yadav
 */
public abstract class TicketPrinterFactory {

	/**
	 * Gets the printer or if type input is invalid than will throw InvalidPrinterType exception.
	 *
	 * @param type the type of printer
	 * @return the printer
	 */
	public static IHousieTicketConsolePrinter getPrinter(String type) {
		
		IHousieTicketConsolePrinter printer = null;
		
		if(type.equalsIgnoreCase("CONSOLE")) {
			printer = new HousieTicketConsolePrinterImpl();
		}
		else {
			throw new InvalidPrinterType("Invalid Printer Type");
		}
		return printer;
	}
}
