import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Iterator;
public class CustomList<E> {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private int capacity=10;
    private Object[] Element;
    public CustomList()
    {
        Element=new Object[capacity];
    }

    public void addEle(E ele) {
        LOGGER.info("Entered into addEle() method\n");
        if (capacity <= Element.length){
                ensureCapacity();
        }
        Element[capacity++] = ele;
        LOGGER.info("Exited from addEle() method\n");
    }
    public E getEle(int i) {
        LOGGER.info("Entered into getEle() method\n");
        if (i >= capacity || i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        LOGGER.info("Exited from getEle() method\n");
        return (E) Element[i];
    }
    private void ensureCapacity() {
        LOGGER.info("Entered into ensureCapacity() method\n");
        int newCapacity = Element.length * 2;
        Element = Arrays.copyOf(Element, newCapacity);
        LOGGER.info("Exited from ensureCapacity() method\n");
    }
    public void removeEle(int i) {
        LOGGER.info("Entered into removeEle() method\n");
        if (i >= capacity|| i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int num = Element.length - ( i + 1 ) ;
        System.arraycopy( Element, i + 1, Element, i, num ) ;
        capacity--;
        LOGGER.info("Exited from removeEle() method\n");
    }
    public int currSize() { //Get Size of list
        LOGGER.info("Entered into currSize() method\n");
        LOGGER.info("Exited from currSize() method\n");
        return capacity;
    }

    public String toString()
    {
        LOGGER.info("Entered into toString() method\n");
        LOGGER.info("Exited from toString() method\n");
        Iterator<E> it=iterator();
        assert it != null;
        if(!it.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(;;) {
            E i = it.next();
            sb.append(i == this ? "(this Collection)" : i);
            if (!it.hasNext())
                return sb.append("]").toString();
            sb.append(',');
        }

    }

    public Iterator<E> iterator() {
        return new Itr();
    }
    public class Itr implements Iterator<E>{
        int cursor;
        public boolean hasNext(){
            LOGGER.info("Entered into hasNext() method\n");
            LOGGER.info("Exited from hasNext() method\n");
            return cursor!=CustomList.this.capacity;
        }
        @SuppressWarnings("unchecked")
        public E next(){
            LOGGER.info("Entered into next() method\n");
            LOGGER.info("Exited from next() method\n");
            return (E)CustomList.this.Element[cursor++];
        }
        public void remove(){
            LOGGER.info("Entered into remove() method\n");
            CustomList.this.removeEle(cursor);
            LOGGER.info("Exited from remove() method\n");
        }
    }

}


