import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args)
    {
        LOGGER.info("Entered into main() method\n");
        CustomList<String> list = new CustomList<String>();

        //Add elements
        list.addEle("Sai");
        list.addEle("Supriya");
        list.addEle("Jashhu");
        LOGGER.info(list);

        //Remove elements from index
        list.removeEle(0);
        LOGGER.info(list);

        //Get element with index
        LOGGER.info( list.getEle(1) );
        LOGGER.info( list.getEle(2) );

        //List Size
        LOGGER.info(list.currSize());
        LOGGER.info("Exited into main() method\n");
    }
}