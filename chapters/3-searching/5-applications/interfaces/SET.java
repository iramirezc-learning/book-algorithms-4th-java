/**
 * Type: Interface
 * Description: Basic Set ADT
 * Ref: p. 489
 */

/**
 * SET
 */
public interface SET<Key> { // implements Iterable<Key>
  public void add(Key key);

  public void delete(Key key);

  public boolean contains(Key key);

  public boolean isEmpty();

  public int size();

  public String toString();
}
