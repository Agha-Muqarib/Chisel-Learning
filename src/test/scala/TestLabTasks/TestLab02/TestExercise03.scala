package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise03Test extends FreeSpec with ChiselScalatestTester {
"Exercise 03 Test" in {
    
    test(new Exercise03) { c =>

    c.io.in.poke(4.U)
    c.io.s0.poke(true.B)
    c.io.s1.poke(false.B)
    c.io.s0.poke(true.B)
    c.io.s2.poke(true.B)
    

    c.clock.step(10)

    c.io.out.expect(false.B)

    }
}
}