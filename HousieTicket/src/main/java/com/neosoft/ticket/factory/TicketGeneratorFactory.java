package com.neosoft.ticket.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neosoft.ticket.HousieTicketSystem;
import com.neosoft.ticket.exception.InvalidGeneratorType;
import com.neosoft.ticket.generator.HousieTicketGeneratorImpl;
import com.neosoft.ticket.generator.IHousieTicketGenerator;

/**
 * A factory for creating TicketGenerator objects.
 * 
 * @author Santoshi Yadav
 */
public abstract class TicketGeneratorFactory {

	/** The Constant GENERATOR_TYPE_HOUSIE_TICKET. */
	public final static String GEN_TYPE_HOUSIE_TICKET = "HOUSIETICKET";

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(HousieTicketSystem.class);

	/**
	 * Gets the ticket generator or if input is not valid then throw the InvalidGeneratorType exception.
	 *
	 * @param type the type of ticket generator
	 * @return the ticket generator
	 */
	public static IHousieTicketGenerator getTicketGenerator(String type) {

		IHousieTicketGenerator ticket;

		switch (type) {
		case GEN_TYPE_HOUSIE_TICKET:

			ticket = new HousieTicketGeneratorImpl();

			break;

		default:
			logger.error("Invalid generator type:{} ",type);
			throw new InvalidGeneratorType("Invalid Generator Type");
		}

		return ticket;
	}

}
