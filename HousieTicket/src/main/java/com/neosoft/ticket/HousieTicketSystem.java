package com.neosoft.ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neosoft.ticket.factory.TicketGeneratorFactory;
import com.neosoft.ticket.factory.TicketPrinterFactory;
import com.neosoft.ticket.generator.IHousieTicketGenerator;
import com.neosoft.ticket.printer.IHousieTicketConsolePrinter;

/**
 * The Class HousieTicketSystem.
 * 
 * @author Santoshi Yadav
 */
public class HousieTicketSystem {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(HousieTicketSystem.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		logger.info("Main - Start");
		IHousieTicketGenerator ticket = TicketGeneratorFactory
				.getTicketGenerator(TicketGeneratorFactory.GEN_TYPE_HOUSIE_TICKET);
		IHousieTicketConsolePrinter printer = TicketPrinterFactory.getPrinter("console");
		ticket.generateTicket();
		printer.printTicket(ticket);
		logger.info("Main - Completed");
	}

}
