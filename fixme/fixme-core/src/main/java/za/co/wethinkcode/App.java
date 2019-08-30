package za.co.wethinkcode;

import za.co.wethinkcode.exceptions.FixMessageException;
import za.co.wethinkcode.helpers.FixMessageValidator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( CheckSum.generateCheckSum(args[0]) );
        // System.out.println(CheckSum.validateCheckSum(args[0], "065"));

        try {

          FixMessage testBuy = new FixMessage(
            "1D5P8X",
            "6Q8D7Z",
            "XAU",
            "1",
            "100"
          );

          FixMessage testSell = new FixMessage(
            "1D5P8X",
            "6Q8D7Z",
            "XAU",
            "2",
            "100"
          );

          FixMessage testExecutionReport = new FixMessage(
            "6Q8D7Z",
            "1D5P8X",
            "2",
            "XAU",
            "2",
            "1000",
            "1000",
            "25.9"
          );

          System.out.println(testBuy.toString());
          System.out.println(testSell.toString());
          System.out.println(testExecutionReport.toString());

          SingleOrderDecoded buyMessageDecoded = new SingleOrderDecoded(testBuy.toString());
          SingleOrderDecoded sellMessageDecoded = new SingleOrderDecoded(testSell.toString());
          ExecutionReportDecoded executionReportDecoded = new ExecutionReportDecoded(testExecutionReport.toString());

          // Validating message checksums. These will throw a FixMessageException if the checksum is invalid.
          FixMessageValidator.validateCheckSum(buyMessageDecoded.getMessageWithoutChecksum(), buyMessageDecoded.getChecksum());
          FixMessageValidator.validateCheckSum(sellMessageDecoded.getMessageWithoutChecksum(), sellMessageDecoded.getChecksum());
          FixMessageValidator.validateCheckSum(executionReportDecoded.getMessageWithoutChecksum(), executionReportDecoded.getChecksum());

          System.out.println();
          System.out.println("Testing buyMessageDecoded getters.");
          System.out.println();

          System.out.println(buyMessageDecoded.getFixVersion());
          System.out.println(buyMessageDecoded.getBodyLength());
          System.out.println(buyMessageDecoded.getMessageType());
          System.out.println(buyMessageDecoded.getSourceID());
          System.out.println(buyMessageDecoded.getTargetID());
          System.out.println(buyMessageDecoded.getMessageSeqNum());
          System.out.println(buyMessageDecoded.getMessageTimeSent());
          System.out.println(buyMessageDecoded.getBrokerOrderID());
          System.out.println(buyMessageDecoded.getOrderHandling());
          System.out.println(buyMessageDecoded.getSymbol());
          System.out.println(buyMessageDecoded.getBuyOrSell());
          System.out.println(buyMessageDecoded.getOrderAmount());
          System.out.println(buyMessageDecoded.getOrderType());

          System.out.println();
          System.out.println("Testing executionReportDecoded getters.");
          System.out.println();

          System.out.println(executionReportDecoded.getFixVersion());
          System.out.println(executionReportDecoded.getBodyLength());
          System.out.println(executionReportDecoded.getMessageType());
          System.out.println(executionReportDecoded.getSourceID());
          System.out.println(executionReportDecoded.getTargetID());
          System.out.println(executionReportDecoded.getMessageSeqNum());
          System.out.println(executionReportDecoded.getMessageTimeSent());
          System.out.println(executionReportDecoded.getMarketOrderID());
          System.out.println(executionReportDecoded.getExecID());
          System.out.println(executionReportDecoded.getExecTransType());
          System.out.println(executionReportDecoded.getOrderStatus());
          System.out.println(executionReportDecoded.getSymbol());
          System.out.println(executionReportDecoded.getBuyOrSell());
          System.out.println(executionReportDecoded.getOrderAmount());
          System.out.println(executionReportDecoded.getFilledAmount());
          System.out.println(executionReportDecoded.getAvgFilledPrice());
        }
        catch (FixMessageException e) {

          e.printStackTrace(System.out);
        }
    }
}
