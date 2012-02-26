package stormpot;

/**
 * The expiration is used to determine if a given slot has expired, or
 * otherwise become invalid.
 * @author Chris Vest &lt;mr.chrisvest@gmail.com&gt;
 */
public interface Expiration<T extends Poolable> {
  /**
   * Test whether the slot and poolable object, represented by the given
   * {@link SlotInfo} object, is still valid, or if the pool should
   * deallocate it and allocate a replacement.
   * <p>
   * If the method throws an exception, then that is taken to mean that the
   * slot is invalid. How pools otherwise handle the exception - if it will
   * bubble out, and if so, where - is implementation specific. For this
   * reason, it is generally advised that Expirations do not throw
   * exceptions.
   * @param info An informative representative of the slot being tested.
   * @return <code>true</code> if the slot and poolable in question should be
   * deallocated, <code>false</code> if it is valid and elegible for claiming.
   */
  boolean hasExpired(SlotInfo<? extends T> info);
}
