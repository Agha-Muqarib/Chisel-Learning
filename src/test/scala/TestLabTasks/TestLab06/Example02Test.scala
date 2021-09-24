package Lab06

import chisel3._
import org.scalatest._
import chiseltest._

class Example02Test extends FreeSpec with ChiselScalatestTester {
    
    "Example02" in {
        
        test(new Counter(20)) {c =>
        c.clock.step(40)
        // c.io.out.expect(3.U)
    }
  }
}