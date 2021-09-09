package com.neosoft.ticket.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class HousieTicketGeneratorImplementation
 * 
 * @author Santoshi Yadav
 */

public class HousieTicketGeneratorImpl implements IHousieTicketGenerator {

	/** The logger */
	private static Logger logger = LoggerFactory.getLogger(HousieTicketGeneratorImpl.class);

	/**
	 * Generate column number for given column count to be filled.
	 *
	 * @param colCount the column count
	 * @param min      minimum column number
	 * @param max      maximum column number
	 * @return List of column number
	 */
	public List<Integer> generateColumnNumbers(int colCount, int min, int max) {

		logger.trace("generateColumnNumbers() execution started");
		List<Integer> numbers = new ArrayList<Integer>();

		while (numbers.size() < colCount) {
			int num = ThreadLocalRandom.current().nextInt(min, max + 1);
			if (!numbers.contains(num))
				numbers.add(num);
		}
		return numbers;
	}

	/**
	 * Generate ticket.
	 */
	public void generateTicket() {

		logger.trace("Ticket generation process started");
		int col = 0;
		for (int row = 0; row < 3; row++) {
			if (row == 2) {
				col = 0;
				for (int cell = 0; col < 8 && cell < 5; col++) {
					if (TICKET[0][col] == 0 || TICKET[1][col] == 0) {
						generateTicketValue(row, col);
						cell++;
					}
				}
			} else {
				List<Integer> numbers = generateColumnNumbers(5, 0, 8);
				for (int count = 0; count < numbers.size(); count++) {
					col = numbers.get(count);
					generateTicketValue(row, col);
				}
			}
			logger.trace("ticket row-" + (row + 1) + " number generated");
		}
	}

	/**
	 * Generate ticket values.
	 *
	 * @param row the row of ticket
	 * @param col the column of ticket
	 */
	public void generateTicketValue(int row, int col) {

		int num = ThreadLocalRandom.current().nextInt((col * 10) + 1, ((col + 1) * 10) + 1);
		for (int count = row; count > 0; count--) {
			if (TICKET[count - 1][col] == num) {
				num = ThreadLocalRandom.current().nextInt((col * 10) + 1, ((col + 1) * 10) + 1);
			}
		}

		TICKET[row][col] = num;

	}
}
