package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise09Test extends FreeSpec with ChiselScalatestTester {
"Exercise 09 Test" in {
    
    test(new Exercise06) { c =>
    
    c.io.in0.poke(false.B)
    c.io.in1.poke(true.B)
    c.io.in2.poke(false.B)
    c.io.in3.poke(true.B)        
     
    c.io.sel.poke(3.U)


    c.clock.step(10)

    c.io.out.expect(true.B)



    }
}
}