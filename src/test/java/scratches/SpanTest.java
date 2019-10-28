package scratches;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.xml.internal.xsom.impl.scd.Iterators.Array;

class SpanTest {

  @org.junit.jupiter.api.Test
  void maxSpan() {
    Span s = new Span();
    assertEquals(4, s.maxSpan(new int[]{1, 2, 1, 1, 3}));
    assertEquals(6, s.maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
    assertEquals(6, s.maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}));
  }
}