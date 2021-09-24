package Lab06

import chisel3._
import org.scalatest._
import chiseltest._

class Example01Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 01 Test" in {
        
        test(new shiftRegister) {c =>
        c.io.in.poke(1.B)
        c.clock.step(20)
        // c.io.out.expect(3.U)
    }
  }
}