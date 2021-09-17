package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise07Test extends FreeSpec with ChiselScalatestTester {
"Exercise 07 Test" in {
    
    test(new Exercise07) { c =>
    
    c.io.in0.poke(true.B)
    c.io.in1.poke(false.B)
    c.io.in2.poke(false.B)
    c.io.in3.poke(false.B)        
     
    c.io.sel.poke("b0100".U)


    c.clock.step(10)

    c.io.out.expect(false.B)

    }
}
}