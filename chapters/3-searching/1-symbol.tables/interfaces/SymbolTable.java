/**
 * Type: Interface
 * Description: API for a generic basic Symbol Table
 * Ref: p. 363
 */

/**
 * SymbolTable
 */
public interface SymbolTable<Key, Value> {
  public void put(Key key, Value val);

  public Value get(Key key);

  public Key delete(Key key);

  public boolean contains(Key key);

  public boolean isEmpty();

  public int size();

  public Iterable<Key> keys();
}