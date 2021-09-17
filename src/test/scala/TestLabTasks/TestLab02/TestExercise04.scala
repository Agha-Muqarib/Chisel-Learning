package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise04Test extends FreeSpec with ChiselScalatestTester {
"Exercise 04 Test" in {
    
    test(new Exercise04) { c =>
    
    c.io.in.poke(4.U)
    c.io.s1.poke(true.B)
    c.io.s2.poke(false.B)
    c.io.s3.poke(true.B)    

    c.clock.step(10)

    c.io.out.expect(false.B)

    }
}
}