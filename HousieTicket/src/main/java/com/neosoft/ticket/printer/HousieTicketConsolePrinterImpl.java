package com.neosoft.ticket.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neosoft.ticket.HousieTicketSystem;
import com.neosoft.ticket.generator.IHousieTicketGenerator;

/**
 * The Class HousieTicketConsolePrinterImplementation.
 * 
 * @author Santoshi Yadav
 */

public class HousieTicketConsolePrinterImpl implements IHousieTicketConsolePrinter {

	/** The Constant TAB. */
	final static String TAB = "\t";

	/** The Constant EMPTY. */
	final static String EMPTY = "";

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(HousieTicketSystem.class);

	/**
	 * Prints the ticket.
	 *
	 * @param HousieTicket the housie ticket
	 */
	public void printTicket(IHousieTicketGenerator housieTicket) {

		logger.trace("Housie Ticket printing execution started");
		System.out.println("Housie Ticket");
		System.out.println("---------------------------------------------------------------------");
		for (int[] row : housieTicket.TICKET) {
			for (int r : row) {
				System.out.print((r == 0 ? EMPTY : r) + TAB);
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------");

	}

}
