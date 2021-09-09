package com.neosoft.ticket.generator;

/**
 * The Interface IHousieTicketGenerator.
 * 
 * @author Santoshi Yadav
 */
public interface IHousieTicketGenerator {
	
	/** The ticket row. */
	final int TICKET_ROW = 3;
	
	/** The ticket column. */
	final int TICKET_COLUMN = 9;
	
	/** The ticket. */
	int[][] TICKET = new int[TICKET_ROW][TICKET_COLUMN];

	/**
	 * Generate ticket.
	 */
	public void generateTicket();
	
}
