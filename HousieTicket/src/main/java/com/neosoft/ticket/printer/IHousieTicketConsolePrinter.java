package com.neosoft.ticket.printer;

import com.neosoft.ticket.generator.IHousieTicketGenerator;

/**
 * The Interface IHousieTicketConsolePrinter.
 * 
 * @author Santoshi Yadav
 */
public interface IHousieTicketConsolePrinter {

	/**
	 * Prints the ticket.
	 *
	 * @param HousieTicket the housie ticket
	 */
	public void printTicket(IHousieTicketGenerator HousieTicket);
}
