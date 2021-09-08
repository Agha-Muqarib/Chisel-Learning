package Example

import org.scalatest._
import chiseltest._
import chisel3._

class MultiplexerTest extends FreeSpec with ChiselScalatestTester {
"Multiplexer Test" in {
    
    test(new Mux()) { c =>

    c.io.a.poke(1.U)
    c.io.b.poke(0.U)
    c.io.sel.poke(1.U)
    c.clock.step(1)
    c.io.c.expect(0.U)

    }
}
}

