/**
 * Type: Interface
 * Description: API for a generic Ordered Symbol Table
 * Ref: p. 366
 */

/**
 * OrderedSymbolTable
 */
public interface OrderedSymbolTable<Key, Value> {
  public void put(Key key, Value val);

  public Value get(Key key);

  public Key delete(Key key);

  public boolean contains(Key key);

  public boolean isEmpty();

  public int size();

  public int size(Key lo, Key hi);

  public Key min();

  public Key max();

  public Key floor(Key key);

  public Key ceiling(Key key);

  public int rank(Key key);

  public Key select(int k);

  public void deleteMin();

  public void deleteMax();

  public Iterable<Key> keys();

  public Iterable<Key> keys(Key lo, Key hi);
}